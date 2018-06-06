/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tempexpr4j;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author thor
 */
abstract class AbstractExpression implements Expression {

    public AbstractExpression() {
    }         

    @Override
    public boolean include(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return this.include(c);
    }

    @Override
    public boolean include(Object cal) {
        throw new UnsupportedOperationException("@TODO impl");
    }

    @Override
    public boolean exclude(Calendar cal) {
        return !this.include(cal);
    }

    @Override
    public boolean exclude(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return this.exclude(c);
    }

    @Override
    public boolean exclude(Object cal) {
        return !this.include(cal);
    }

    /**
     * Default implementation returns the argument if it is in the in the inclusion range.
     * 
     * @param cal
     * @return 
     */
    @Override
    public Calendar first(Calendar cal) {
        return include(cal) ? cal : null;
    }

    /**
     * Default implementation returns the argument if it is in the in the inclusion range.
     * 
     * @param next
     * @return 
     */
    @Override
    public Calendar next(Calendar next) {  
        return this.include(next) ? next : null;
    }        
}
