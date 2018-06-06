/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tempexpr4j;

import java.util.Calendar;

/**
 *
 * @author thor
 */
public class DateRange extends AbstractRange {

    public DateRange(Calendar date) {
        this(date, date);
    }       

    public DateRange(Calendar from, Calendar to) {
        super(AbstractRange.Type.DAY_OF_WEEK_RANGE);
        if(!from.equals(to) && !from.before(to)) {
            throw new IllegalArgumentException("'From' must be before or the same date as 'to'");
        }        
        this.from = from;
        this.to = to;        
    }
    
    @Override
    public boolean include(Calendar date) {
        return (from.equals(date) || from.before(date)) && (to.equals(to) || to.after(date));
    }
    
    private final Calendar from;
    private final Calendar to;
    
}
