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
public class TemporalUtil {
       
    public static boolean isExpressionsIncluded(List<Expression> exprList, Calendar cal) {
        for (Expression e : exprList) {
            if (!e.include(cal)) {
                return false;
            }
        }
        return true;
    }   
    
    public static void validateMinMax(int value, int min, int max) {
        if(value > max) {
            throw new IllegalArgumentException("Value is more than maximum");
        }
        if(value < min) {
            throw new IllegalArgumentException("Value is less than minimum");
        }
    }
    
    public static void validateFromTo(int from, int to, int min, int max) {
        if(from > max) {
            throw new IllegalArgumentException("From value is more than maximum");
        }
        if(from < min) {
            throw new IllegalArgumentException("From Value is less than minimum");
        }
        if(to > max) {
            throw new IllegalArgumentException("To value is more than maximum");
        }
        if(to < min) {
            throw new IllegalArgumentException("From Value is less than minimum");
        }
    }
    
}
 