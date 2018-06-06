/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tempexpr4j;

import java.util.Calendar;
import java.util.List;

/**
 *
 * @author thor
 */
public interface NodeExpression extends Expression {

    public NodeExpression addSecondRange(final int second);

    public NodeExpression addSecondRange(final int from, final int to);
    
    public NodeExpression addDateRange(final Calendar from, final Calendar to);

    public NodeExpression addDayOfWeek(final int from, final int to);

    public NodeExpression addDayOfWeek(final int weekday);

    public NodeExpression addDaysInMonth(final int dayOfWeek, final int occurence);

    public NodeExpression addDaysOfMonth(final int dayOfMonth);

    public NodeExpression addDaysOfMonth(final int from, final int to);

    public NodeExpression addHourRange(final int from, final int to);

    public NodeExpression addHourRange(final int hour);

    public NodeExpression addMinuteRange(final int from, final int to);

    public NodeExpression addMinuteRange(final int minute);

    public NodeExpression addMonthRange(final int dayOfMonth);

    public NodeExpression addMonthRange(final int from, final int to);
    
    public List<Expression> getInclude();
    
}
