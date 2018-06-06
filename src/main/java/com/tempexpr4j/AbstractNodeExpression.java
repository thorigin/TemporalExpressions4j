/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tempexpr4j;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author thor
 */
public abstract class AbstractNodeExpression<T extends NodeExpression> extends AbstractExpression implements NodeExpression {

    public AbstractNodeExpression() {
        super();
    }   
    
   /**
    * Default implementation of this method checks to see if node has include 
    * and if it does it returns true if they all include given Calendar value. 
    * @param cal
    * @return 
    */
    @Override
    public boolean include(Calendar cal) {
        return TemporalUtil.isExpressionsIncluded(this.include, cal);
    }

    @Override
    public List<Expression> getInclude() {
        return include;
    }                    
                
    @Override
    public T addSecondRange(final int second) {
        return this.addSecondRange(second, second);
    }

    @Override
    public T addSecondRange(final int from, final int to) {
       this.include.add(new SecondRange(from, to));
       return (T)this;
    }
    
    
    @Override
    public T addMinuteRange(final int minute) {
        return this.addMinuteRange(minute, minute);
    }

    @Override
    public T addMinuteRange(final int from, final int to) {
       this.include.add(new MinuteRange(from, to));
       return (T)this;
    }

    @Override
    public T addHourRange(final int hour) {
        return this.addHourRange(hour, hour);
    }

    @Override
    public T addHourRange(final int from, final int to) {
        this.include.add(new HourRange(from, to));
        return (T)this;
    }

    @Override
    public T addDayOfWeek(final int weekday) {
        return this.addDayOfWeek(weekday, weekday);
    }

    @Override
    public T addDayOfWeek(final int from, final int to) {
        this.include.add(new DayOfWeek(from, to));
        return (T)this;
    }

    @Override
    public T addDaysOfMonth(final int dayOfMonth) {
        return this.addDaysOfMonth(dayOfMonth, dayOfMonth);
    }

    @Override
    public T addDaysOfMonth(final int from, final int to) {
       this.include.add(new DayOfMonth(from, to));
       return (T)this;
    }

    @Override
    public T addDaysInMonth(final int dayOfWeek, final int occurence) {
        this.include.add(new DayInMonth(dayOfWeek, occurence));
        return (T)this;
    }

    @Override
    public T addDateRange(final Calendar from, final Calendar to) {
        this.include.add(new DateRange(from, to));
        return (T)this;
    }    
    
    public T addFrequency(final Calendar start, Frequency.Type type, int frequency) {
        this.include.add(new Frequency(start, type, frequency));
        return (T)this;
    }

    @Override
    public NodeExpression addMonthRange(int dayOfMonth) {
        return this.addMonthRange(dayOfMonth, dayOfMonth);
    }

    @Override
    public NodeExpression addMonthRange(int from, int to) {
        this.include.add(new MonthRange(from, to));
        return (T)this;
    }        
    
    public <T extends Expression> T add(T e) {
        this.include.add(e);
        return e;
    }

    @Override
    public Calendar first(Calendar cal) { 
        for(Expression e : this.include) {
            Calendar first = e.first(cal);
            if(first != null && this.include(first)) {
                return first;
            }
        }
        return null;
    }

    @Override
    public Calendar next(Calendar cal) {
        Calendar result = null;
        for(Expression e : this.include) {
            Calendar next = e.next(cal);
            if(next != null && (result == null || next.before(result))) {
                result = next;
            }
        }
        return result;
    }        
    
    protected final List<Expression> include = new ArrayList<>();
}
