package org.acme.ChainOfResponsibility;

import org.acme.Builder.Order;

public class StockCheckHandler extends OrderHandler {

    @Override
    public void handle(Order order) {
        System.out.println("Checking stock...");
        if (next != null) {
            next.handle(order);
        }
    }
}
