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
public class SecondRange extends AbstractRange {
    
    public SecondRange(int minute) {
        this(minute, minute);
    }

    public SecondRange(int from, int to) {
        super(AbstractRange.Type.SECOND_RANGE);
        TemporalUtil.validateFromTo(from, to, 0, 60);        
        this.from = from;
        this.to = to;
    }

    @Override
    public boolean include(Calendar date) {
        int minute = date.get(Calendar.SECOND);
        return (from >= to && (minute <= to || minute >= from)) || (minute >= from && minute <= to);
    }
    
    private final int from;
    private final int to;
}
