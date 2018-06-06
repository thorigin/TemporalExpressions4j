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
public class MinuteRange extends AbstractRange {

    public MinuteRange(int minute) {
        this(minute, minute);
    }

    public MinuteRange(int from, int to) {
        super(AbstractRange.Type.MINUTE_RANGE);
        TemporalUtil.validateFromTo(from, to, 0, 60);        
        this.from = from;
        this.to = to;
    }

    public boolean include(Calendar date) {
        int minute = date.get(Calendar.MINUTE);
        return (from >= to && (minute <= to || minute >= from)) || (minute >= from && minute <= to);
    }
    
    private final int from;
    private final int to;
    
}
