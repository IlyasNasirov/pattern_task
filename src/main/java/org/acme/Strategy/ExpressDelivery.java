package org.acme.Strategy;

public class ExpressDelivery implements DeliveryStrategy{

    @Override
    public void deliver(String address) {
        System.out.println("Delivering to " + address + " using Express Delivery.");
    }

}
