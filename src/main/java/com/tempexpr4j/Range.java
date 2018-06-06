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
public final class Range {

    public Range(Calendar from, Calendar to) {
        this.from = from;
        this.to = to;
    }
    
    public Calendar getFrom() {
        return from;
    }

    public Calendar getTo() {
        return to;
    }        
    
    private Calendar from;
    private Calendar to;
}
