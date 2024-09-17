package org.acme.ChainOfResponsibility;

import org.acme.Builder.Order;

public class ShippingHandler extends OrderHandler{

    @Override
    public void handle(Order order) {
        System.out.print("Shipping order... ");
        order.getDeliveryStrategy().deliver(order.getAddress());
    }
}
