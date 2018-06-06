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
public class Schedule {

    public Schedule(Expression base) {
        this.base = base;
    }


    
    /**
     *
     * @param when
     * @return
     */
    public Calendar nextOccurence(Calendar when) {
        return null;        
    }
    
    public List<Calendar> occurences(Calendar from, Calendar to) {
        List<Calendar> occurences = new ArrayList<>();
        Calendar curr = (Calendar) from.clone();
        //while(curr.before(this)) {
            //this.base.first(curr)
        //}
        return occurences;
    }
    
    private Expression base;
}
