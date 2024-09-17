package org.acme.ChainOfResponsibility;

import org.acme.Builder.Order;

public class ShippingHandler extends OrderHandler{

    @Override
    public void handle(Order order) {
        order.getDeliveryStrategy().deliver(order.getAddress());
        System.out.println("Shipping order...");
    }
}
