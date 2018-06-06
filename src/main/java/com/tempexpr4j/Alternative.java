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
public class Alternative extends AbstractNodeExpression<Alternative> {

    public Alternative() {
        super();
    }

    @Override
    public boolean include(Calendar cal) {
        for (Expression e : this.getInclude()) {
            if (e.include(cal)) {
                return true;
            }
        }
        return false;
    }    
}
