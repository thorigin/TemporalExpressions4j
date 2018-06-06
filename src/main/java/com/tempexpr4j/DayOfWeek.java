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
public class DayOfWeek extends AbstractRange {

    public DayOfWeek(int dayOfWeek) {
        this(dayOfWeek, dayOfWeek);
    }

    public DayOfWeek(int from, int to) {
        super(AbstractRange.Type.DAY_OF_WEEK_RANGE);
        TemporalUtil.validateFromTo(from, to, Calendar.SUNDAY, Calendar.SATURDAY);
        this.from = from;
        this.to = to;
    }
    
    public boolean include(Calendar date) {
        int now = date.get(Calendar.DAY_OF_WEEK);
        return (from >= to && (now <= to || now >= from)) || (now >= from && now <= to);
    }
    
    private final int from;
    private final int to;
    
}
