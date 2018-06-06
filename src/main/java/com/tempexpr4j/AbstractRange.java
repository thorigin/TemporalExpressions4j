/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tempexpr4j;

/**
 *
 * @author thor
 */
public abstract class AbstractRange extends AbstractExpression implements RangeExpression {

    public AbstractRange(Type type) {
        super();
        this.type = type;
    }
                                
    public Type getType() {
        return this.type;
    }

    private Type type;
}
