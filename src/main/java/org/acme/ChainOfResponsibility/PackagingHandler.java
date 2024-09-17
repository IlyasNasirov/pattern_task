package org.acme.ChainOfResponsibility;

import org.acme.Builder.Order;

public class PackagingHandler extends OrderHandler{

    @Override
    public void handle(Order order) {
        System.out.println("Packaging order...");
        if (next != null) {
            next.handle(order);
        }
    }
}
