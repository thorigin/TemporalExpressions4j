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
public class Frequency extends AbstractExpression {

    public enum Type {
        
        SECOND(Calendar.SECOND),        
        MINUTE(Calendar.MINUTE),
        HOUR(Calendar.HOUR),
        DAY(Calendar.DAY_OF_MONTH),
        WEEK(Calendar.WEEK_OF_MONTH),
        MONTH(Calendar.MONTH),
        YEAR(Calendar.YEAR);
        
        private Type(int type) {
            this.CalendarType = type;
        }
        
        public final int CalendarType;
        
    }
    
    public Frequency(Calendar start, Type type, int frequency) {
        super();
        if(frequency < 1) {
            throw new IllegalArgumentException("Frequency must be 1 or higher");
        }        
        this.start = start;
        this.type = type;
        this.frequency = frequency;
    }

    @Override
    public boolean include(Calendar cal) {        
        Calendar next = (Calendar)this.start.clone();
        while(next.before(cal)) {
            next.add(this.type.CalendarType, this.frequency);
        }
        return next.equals(cal);
    }
    
    private Calendar start;
    private Type type;
    private int frequency;
}
