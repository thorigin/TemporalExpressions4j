/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tempexpr4j;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;
import org.junit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author thor
 */
public class ExpressionTest {
    

    /**
     * Test of addUnion method, of class Expression.
     */
    @Test
    public void testExpressionAddHourRange() {
        System.out.println("testExpressionAddHourRange");
        DateTime one_hour_before_now = DateTime.now().minusHours(1);
        DateTime one_hour_from_now = DateTime.now().plusHours(1);
        assertTrue(BaseExpression.create().addHourRange(    one_hour_before_now.getHourOfDay(), 
                                                        one_hour_from_now.getHourOfDay()).include(Calendar.getInstance()));
    }
    
    /**
     * Test of addUnion method, of class Expression.
     */
    @Test
    public void testExpressionAddMinuteRange() {
        System.out.println("testExpressionAddHourRange");
        DateTime one_hour_before_now = DateTime.now().minusMinutes(1);
        DateTime one_hour_from_now = DateTime.now().plusMinutes(1);
        assertTrue(BaseExpression.create().addMinuteRange(  one_hour_before_now.getMinuteOfHour(), 
                                                        one_hour_from_now.getMinuteOfHour()).include(Calendar.getInstance()));
    }
  
    
    /**
     * Test of addUnion method, of class Expression.
     */
    @Test
    public void testExpressionAddDayOfWeekRange() {
        System.out.println("testExpressionAddDayOfWeekRange1");
        DateTime one_hour_before_now = DateTime.now().minusDays(1);
        DateTime one_hour_from_now = DateTime.now().plusDays(1);
        assertTrue(BaseExpression.create().addDayOfWeek(  one_hour_before_now.toGregorianCalendar().get(Calendar.DAY_OF_WEEK),
                                                        one_hour_from_now.toGregorianCalendar().get(Calendar.DAY_OF_WEEK)).include(Calendar.getInstance()));
    }
    
    /**
     * Test of addUnion method, of class Expression.
     */
    @Test
    public void testExpressionAddDayOfWeekRange2() {
        System.out.println("testExpressionAddDayOfWeekRange2");
        DateTime now = DateTime.now().withDayOfWeek(DateTimeConstants.SATURDAY);
        assertTrue(BaseExpression.create().addDayOfWeek(  6,
                                                      1).include(now.toGregorianCalendar()));
    }  
    
    
    /**
     * Test of addUnion method, of class Expression.
     */
    @Test
    public void testExpressionaddDaysOfMonth() {
        System.out.println("testExpressionaddDaysOfMonth");
        DateTime now = DateTime.now().withDayOfMonth(7);
        assertTrue(BaseExpression.create().addDaysOfMonth(  6,
                                                        1).include(now.toGregorianCalendar()));
    }      
    
    /**
     * Test of addUnion method, of class Expression.
     */
    @Test
    public void testExpressionaddDaysOfMonth2() {
        System.out.println("testExpressionaddDaysOfMonth2");
        DateTime now = DateTime.now().withDayOfMonth(5);
        assertFalse(BaseExpression.create().addDaysOfMonth(  6,
                                                        1).include(now.toGregorianCalendar()));
    }
    
        /**
     * Test of addUnion method, of class Expression.
     */
    @Test
    public void testExpressionaddDaysInMonth() {
        System.out.println("testExpressionaddDaysInMonth");
        DateTime now = DateTime.now().withDayOfMonth(1);
        while(now.getDayOfWeek() != DateTimeConstants.MONDAY) {
            now = now.plusDays(1);
        }
        now = now.plusDays((2 -1) * 7);
        assertTrue(BaseExpression.create().addDaysInMonth( Calendar.MONDAY,
                                                        2).include(now.toGregorianCalendar()));
    } 
    
        /**
     * Test of addUnion method, of class Expression.
     */
    @Test
    public void testExpressionaddDaysInMonth2() {
        System.out.println("testExpressionaddDaysInMonth2");
        DateTime now = DateTime.now().withDayOfMonth(1);
        while(now.getDayOfWeek() != DateTimeConstants.MONDAY) {
            now = now.plusDays(1);
        }
        now = now.plusDays((2 -1) * 7).plusDays(1);
        assertFalse(BaseExpression.create().addDaysInMonth( Calendar.MONDAY,
                                                        2).include(now.toGregorianCalendar()));
    }
    
    /**
     * Test of addUnion method, of class Expression.
     */
    @Test
    public void testExpressionaddDateRange() {
        System.out.println("testExpressionaddDateRange");
        DateTime now = DateTime.now();
        GregorianCalendar one_hour_before_now = DateTime.now().minusDays(1).toGregorianCalendar();
        GregorianCalendar one_hour_from_now = DateTime.now().plusDays(1).toGregorianCalendar();
        assertTrue(BaseExpression.create().addDateRange(  one_hour_before_now,
                                                one_hour_from_now).include(now.toGregorianCalendar()));
    }    
        
    @Test
    public void testMultipleExpressions1() {
        System.out.println("testMultipleExpressions1");
        DateTime now = DateTime.now().withDate(2012, 12, 1).withTime(1, 1, 1, 1);
        BaseExpression b = BaseExpression.create()
                .addDateRange(now.minusDays(20).toGregorianCalendar(), now.plusDays(20).toGregorianCalendar())
                .addDayOfWeek(Calendar.SUNDAY)
                .addHourRange(1);
        assertTrue(b.include(now.toGregorianCalendar()));
    }
    
    @Test
    public void testMultipleExpressionsExclude() {
        System.out.println("testMultipleExpressions1");
        DateTime now = DateTime.now().withDate(2012, 12, 1).withTime(2, 1, 1, 1);
        BaseExpression b = BaseExpression.create();
                b.addUnion()
                .addDateRange(now.minusDays(20).toGregorianCalendar(), now.plusDays(20).toGregorianCalendar())
                .addDayOfWeek(Calendar.SUNDAY)
                .addHourRange(1, 3);
                b.addIntersection().addHourRange(2);
        assertFalse(b.include(now.toGregorianCalendar()));
    }
    
    @Test
    public void testMultipleExpressionsSubstitute() {
        System.out.println("testMultipleExpressionsSubstitute");
        DateTime now = DateTime.now().withDate(2012, 12, 1).withTime(2, 1, 1, 1);
        BaseExpression b = BaseExpression.create();
                b.addUnion()
                .addDateRange(now.minusDays(20).toGregorianCalendar(), now.plusDays(20).toGregorianCalendar())
                .addDayOfWeek(Calendar.SUNDAY)
                .addHourRange(1, 3);
                b.addIntersection().addHourRange(2);
        assertFalse(b.include(now.toGregorianCalendar()));        
    }
    
    @Test
    public void testFrequencyExpression() {
        System.out.println("testFrequencyExpression");
        DateTime now = DateTime.now();
        int freq = 10;        
        BaseExpression b = BaseExpression.create(); b.addFrequency(now.toGregorianCalendar(), Frequency.Type.HOUR, freq);
        assertFalse(b.include(now.plusHours(freq-1).toGregorianCalendar()));
        assertTrue(b.include(now.plusHours(freq).toGregorianCalendar()));
        assertFalse(b.include(now.plusHours(freq+1).toGregorianCalendar()));
    }
    
    @Test
    public void testDayOfMonthExpressionNext() {
        System.out.println("testDayOfMonthExpressionNext");
        GregorianCalendar now = DateTime.now().withDayOfMonth(1).toGregorianCalendar();
        BaseExpression b = BaseExpression.create(); b.addDaysOfMonth(1);
        assertEquals(b.next(now), now);
    }
    
    //@Test
    public void testDayOfMonthExpressionNext2() {
        System.out.println("testDayOfMonthExpressionNext2");
        GregorianCalendar now = DateTime.now().withDayOfMonth(2).toGregorianCalendar();
        BaseExpression b = BaseExpression.create(); b.addDaysOfMonth(1);
        assertEquals(b.next(now), new DateTime(now).withDayOfMonth(1).plusMonths(1).toGregorianCalendar());
    }
    
    @Test
    public void testAlternatives() {
        System.out.println("testDayOfMonthExpressionNext");
        DateTime date = DateTime.now().plus(8).withDayOfWeek(DateTimeConstants.MONDAY);
        GregorianCalendar date1 = date.toGregorianCalendar();
        GregorianCalendar date2 = date.plusDays(8).withDayOfWeek(Calendar.SATURDAY).toGregorianCalendar();
        BaseExpression b = BaseExpression.create();
        Alternative a = b.addAlternative();
        a.addDayOfWeek(Calendar.MONDAY);
        a.addDayOfWeek(Calendar.SATURDAY);
        assertTrue(b.include(date1));
        assertTrue(b.include(date2));
    }    
    
    public static final DateFormat df = SimpleDateFormat.getDateInstance(SimpleDateFormat.LONG);
}
