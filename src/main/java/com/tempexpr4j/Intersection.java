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
public class Intersection<T extends Intersection> extends AbstractNodeExpression<T> {

    public Intersection() {
        super();
    }

    @Override
    public boolean include(Calendar cal) {
        return !TemporalUtil.isExpressionsIncluded(this.include, cal);
    }
    
}
