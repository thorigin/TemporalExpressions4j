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
public class HourRange extends AbstractRange {

    public HourRange(int hour) {
        this(hour, hour);
    }

    public HourRange(int from, int to) {
        super(RangeExpression.Type.HOUR_RANGE);
        TemporalUtil.validateFromTo(from, to, 0, 60);
        this.from = from;
        this.to = to;
    }

    @Override
    public boolean include(Calendar date) {
        int hour = date.get(Calendar.HOUR_OF_DAY);
        return (from >= to && (hour <= to || hour >= from)) || (hour >= from && hour <= to);
    }
    
    private final int from;
    private final int to;
    
}
