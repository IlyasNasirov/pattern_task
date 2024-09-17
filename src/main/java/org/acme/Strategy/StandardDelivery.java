package org.acme.Strategy;

public class StandardDelivery implements DeliveryStrategy{

    @Override
    public void deliver(String address) {
        System.out.println("Delivering to " + address + " using Standard Delivery.");
    }

}
