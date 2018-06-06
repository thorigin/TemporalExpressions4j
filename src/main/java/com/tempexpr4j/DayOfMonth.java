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
public class DayOfMonth extends AbstractRange {

    public DayOfMonth(int day) {
        this(day, day);
    }

    public DayOfMonth(int from, int to) {
        super(AbstractRange.Type.DAY_OF_MONTH_RANGE);
        TemporalUtil.validateFromTo(from, to, 1, 31);
        this.from = from;
        this.to = to;
    }

    public boolean include(Calendar date) {
        int now = date.get(Calendar.DAY_OF_MONTH);
        return (from >= to && (now <= to || now >= from)) || (now >= from && now <= to);
    }
    
    private final int from;
    private final int to;
    
}
