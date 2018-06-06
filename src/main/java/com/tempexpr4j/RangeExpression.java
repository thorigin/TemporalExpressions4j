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
public interface RangeExpression extends Expression {
    
    public enum Type {
        
        SECOND_RANGE,
        MINUTE_RANGE,
        HOUR_RANGE,
        DAY_OF_WEEK_RANGE,
        DAY_OF_MONTH_RANGE,
        DAYS_IN_MONTH,
        DATE_RANGE,
        WEEK_RANGE,
        MONTH_RANGE,
        YEAR_RANGE;
        
    }
    
}
