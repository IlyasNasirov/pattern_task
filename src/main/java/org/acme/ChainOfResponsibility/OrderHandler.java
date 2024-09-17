package org.acme.ChainOfResponsibility;

import org.acme.Builder.Order;

public abstract class OrderHandler {

    protected OrderHandler next;

    public OrderHandler setNext(OrderHandler next) {
        this.next = next;
        return next;
    }

    public abstract void handle(Order order);
}
