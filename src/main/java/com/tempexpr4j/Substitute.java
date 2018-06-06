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
public class Substitute extends Intersection {

    public Substitute() {
        super();
        this.excludes = new ArrayList<>();
        this.substitutes = new ArrayList<>();
    }

    @Override
    public boolean include(Calendar cal) {
        boolean diff = TemporalUtil.isExpressionsIncluded(this.include, cal) && !TemporalUtil.isExpressionsIncluded(this.excludes, cal);
        
        //return diff && !TemporalUtil.isChildrenIncluded(this, cal)
        return false;
    }

    public List<Expression> getExclude() {
        return this.excludes;
    }
    
    private final List<Expression> excludes;
    private final List<Expression> substitutes;
}
