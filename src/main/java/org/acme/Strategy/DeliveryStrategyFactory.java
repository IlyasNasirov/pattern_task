package org.acme.Strategy;

public class DeliveryStrategyFactory {

    public static DeliveryStrategy getStrategy(DeliveryType deliveryType) {
        return switch (deliveryType) {
            case STANDARD -> new StandardDelivery();
            case EXPRESS -> new ExpressDelivery();
            default -> throw new IllegalStateException("Unexpected value: " + deliveryType);
        };
    }

}

