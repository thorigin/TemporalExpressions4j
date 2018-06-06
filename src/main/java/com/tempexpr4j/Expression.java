/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tempexpr4j;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author thor
 */
public interface Expression {
       
    public boolean include(Calendar cal);
    public boolean include(Date date);
    public boolean include(Object cal);
    
    public boolean exclude(Calendar cal);
    public boolean exclude(Date date);
    public boolean exclude(Object cal);
    
    /**
     * First occurence on or after a specified date.
     * Returns null if nothing matches.
     * @param cal
     * @return 
     */
    public Calendar first(Calendar cal);
    
    /**
     * Returns the next occurence after a specified date
     * Returns null if there are no matches.
     * @param next
     * @return 
     */
    public Calendar next(Calendar next);
    
}
