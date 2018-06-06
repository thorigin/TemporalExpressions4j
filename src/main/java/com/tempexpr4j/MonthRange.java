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
public class MonthRange extends AbstractRange {

    public MonthRange(int from, int to) {
        super(Type.MONTH_RANGE);
        TemporalUtil.validateFromTo(from, to, 0, 11);
        this.from = from;
        this.to = to;
    }

    @Override
    public boolean include(Calendar cal) {
        int month = cal.get(Calendar.MONTH);
        return (from >= to && (month <= to || month >= from)) || (month >= from && month <= to);
    }
    
    private int from;
    private int to;
}
