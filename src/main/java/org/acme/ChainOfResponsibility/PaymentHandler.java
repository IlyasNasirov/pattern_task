package org.acme.ChainOfResponsibility;

import org.acme.Builder.Order;

public class PaymentHandler extends OrderHandler {

    @Override
    public void handle(Order order) {
        System.out.println("Processing payment...");
        if (next != null) {
            next.handle(order);
        }
    }
}