/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tempexpr4j;

import java.text.MessageFormat;
import java.util.Calendar;
import java.util.List;

/**
 * 
 * @author thor
 * @param <F> Root object type
 * @param <T> Node object type
 */
public abstract class TemporalTreeConvertor<F, T> {
       
    public TemporalTreeConvertor(Class<F> fClass, Class<T> tClass) {
        this.fClass = fClass;
        this.tClass = tClass;
    }

    public BaseExpression build(F value) {
        BaseExpression base = BaseExpression.create();
        for(T te :  this.getBaseExpressionList(value)) {
            this.doTraversal(base, te);
        }
        return base;
    }
    
    public F compose(BaseExpression bExpr) {
        try {
            F newValue = this.fClass.newInstance();
            BaseExpression baseExpression = BaseExpression.create();
            return newValue;
        } catch (InstantiationException | IllegalAccessException ex) {
            throw new RuntimeException("Error", ex);
        }
    }
    
    protected void convertTree(NodeExpression parent, T value) {
        T e = this.createNode(value);
        if(!this.isLeaf(value)) {
            for(T t : this.getIncludes(value)) {
                this.convertTree(parent, value);
            }
            for(T t: this.getExcludes(value)) {
                //this.createNode(parent, t); //@TODO FIx
            }
        }
        this.addToNode(value, parent);
    }
    
    protected abstract BaseExpression createBaseNode(F baseExpr);
    protected abstract T createNode(T parent);
    protected abstract boolean isLeaf(T node);
    protected abstract void addToBase(F base, Expression e);
    protected abstract void addToNode(T node, Expression e);
    

    
    protected abstract String getNodeType(T value);    
    protected abstract Integer getLeafInteger1(T value);
    protected abstract Integer getLeafInteger2(T value);
    protected abstract Calendar getLeafDate1(T value);
    protected abstract Calendar getLeafDate2(T value);
    protected abstract List<T> getIncludes(T value);
    protected abstract List<T> getExcludes(T value);
    protected abstract List<T> getBaseExpressionList(F value);
    
    protected void doTraversal(NodeExpression e, T te) {
        this.recurser(e, e.getInclude(), this.getIncludes(te));
    }

    protected void doTraversal(Difference e, T te) {
        this.recurser(e, e.getInclude(), this.getIncludes(te));
        this.recurser(e, e.getExclude(),this.getExcludes(te));
    }

    protected void recurser(NodeExpression e, List<Expression> nodeAddList, List<T> teList) throws UnsupportedOperationException {            
        for(T i : teList) {
            String i_type_name = this.getNodeType(i);
            Expression addExpr = null;
            Integer int1 = this.getLeafInteger1(i);
            Integer int2 = this.getLeafInteger2(i);
            Calendar date1 = this.getLeafDate1(i);
            Calendar date2 = this.getLeafDate2(i);
            switch(i_type_name) {                    
                case "Union":
                        addExpr = new Union();
                        this.doTraversal((Union)addExpr, i);
                    break;                        
                case "Difference":                            
                        addExpr = new Difference();
                        this.doTraversal((Difference)addExpr, i);
                    break;         
                case "Intersection":
                        addExpr = new Intersection();
                        this.doTraversal((Intersection)addExpr, i);
                    break;
                case "Alternative":
                        addExpr = new Alternative();
                        this.doTraversal((Alternative)addExpr, i);
                    break;                    
                case "Substitution":
                        throw new UnsupportedOperationException("Not supported yet");
                case "Frequency":
                        addExpr = new Frequency(date1, Frequency.Type.values()[int1], int2);
                    break;
                case "SecondRange":
                        addExpr = new SecondRange(int1, int2);
                    break;
                case "MinuteRange":
                        addExpr = new MinuteRange(int1, int2);
                    break;
                case "HourRange":
                        addExpr = new HourRange(int1, int2);
                    break;
                case "DayOfWeek":
                        addExpr = new DayOfWeek(int1, int2);
                    break;
                case "DayOfMonth":
                        addExpr = new DayOfMonth(int1, int2);                        
                    break;
                case "DayInMonth":
                        addExpr = new DayInMonth(int1, int2);
                    break;
                case "DateRange":
                        addExpr = new DateRange(date1, date2);
                    break;
                case "MonthRange":
                        addExpr = new MonthRange(int1, int2);
                    break;
                default: 
                    throw new UnsupportedOperationException(MessageFormat.format("Cannot create expression type {0}", i_type_name));                                                
            }
            nodeAddList.add(addExpr);                
        }
    }
      
    private final Class<F> fClass;
    private final Class<T> tClass;
}
