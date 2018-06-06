/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tempexpr4j;

/**
 *
 * @author thor
 */
public class BaseExpression extends Union<BaseExpression> {

    public BaseExpression() {
        super();
    }
    
    /**
     * Create a new BaseExpression node expression.
     * 
     * @return a new base node
     */
    public static BaseExpression create() {
        return new BaseExpression();
    }    

    /**
     * Returns a new Union instance linked to current context in the include collection
     * 
     * @return 
     */        
    public Union addUnion() {
       Union u = new Union();
       this.include.add(u);
       return u;
    }

    /**
     * Returns a new Intersection instance linked to current context in the include collection
     * 
     * @return 
     */    
    public Intersection addIntersection() {
        Intersection i = new Intersection();
        this.include.add(i);
        return i;
    }

    /**
     * Returns a new Difference instance linked to current context in the include collection
     * 
     * @return 
     */
    public Difference addDifference() {
        Difference d = new Difference();
        this.include.add(d);
        return d;
    }
    
    /**
     * Returns a new Alternative instance linked to current context in the include collection
     * 
     * @return 
     */    
    public Alternative addAlternative() {
        Alternative a = new Alternative();
        this.include.add(a);
        return a;
    }
    
}
