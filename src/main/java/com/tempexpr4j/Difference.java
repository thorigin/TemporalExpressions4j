/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tempexpr4j;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author thor
 */
public class Difference extends AbstractNodeExpression<Difference> {

    public Difference() {
        super();
        this.excludes = new ArrayList<>();
    }

    @Override
    public boolean include(Calendar cal) {
        return  TemporalUtil.isExpressionsIncluded(this.include, cal) && 
                !TemporalUtil.isExpressionsIncluded(this.excludes, cal);
    }
    
    public List<Expression> getExclude() {
        return this.excludes;
    }
    
    private final List<Expression> excludes;
    
}
