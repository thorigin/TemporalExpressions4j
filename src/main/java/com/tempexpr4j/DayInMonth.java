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
public class DayInMonth extends AbstractRange {

    public DayInMonth(int dayOfWeek, int occurence) {
        super(AbstractRange.Type.DAYS_IN_MONTH);
        TemporalUtil.validateMinMax(dayOfWeek, Calendar.SUNDAY, Calendar.SATURDAY);
        this.occurence = occurence;
        this.dayOfWeek = dayOfWeek;
    }

    public boolean include(Calendar date) {
        Calendar next = (Calendar) date.clone();
        next.set(Calendar.DAY_OF_MONTH, 1);
        if (occurence > 0) {
            while (next.get(Calendar.DAY_OF_WEEK) != dayOfWeek) {
                next.add(Calendar.DAY_OF_MONTH, 1);
            }
            next.add(Calendar.DAY_OF_MONTH, (occurence - 1) * 7);
        } else {
            next.add(Calendar.MONTH, 1);
            next.add(Calendar.DAY_OF_MONTH, -1);
            while (next.get(Calendar.DAY_OF_WEEK) != dayOfWeek) {
                next.add(Calendar.DAY_OF_MONTH, -1);
            }
            next.add(Calendar.DAY_OF_MONTH, (occurence + 1) * 7);
        }
        return date.get(Calendar.DAY_OF_MONTH) == next.get(Calendar.DAY_OF_MONTH) && date.get(Calendar.MONTH) == next.get(Calendar.MONTH);
    }
    private final int dayOfWeek;
    private final int occurence;
    
}
