package org.acme.Builder;

import lombok.Getter;
import lombok.Setter;
import org.acme.Factory.Product;
import org.acme.Strategy.DeliveryStrategy;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Order {
    private String customerName;
    private String address;
    private boolean giftWrap;
    private String note;
    private DeliveryStrategy deliveryStrategy;
    private List<Product> products;

    private Order(Builder builder) {
        this.customerName = builder.customerName;
        this.address = builder.address;
        this.giftWrap = builder.giftWrap;
        this.note = builder.note;
        this.deliveryStrategy = builder.deliveryStrategy;
        this.products = builder.products;
    }

    public static class Builder {
        private String customerName;
        private String address;
        private boolean giftWrap;
        private String note;
        private DeliveryStrategy deliveryStrategy;
        private List<Product> products = new ArrayList<>();

        public Builder(String customerName, String address) {
            this.customerName = customerName;
            this.address = address;
        }

        public Builder giftWrap(boolean giftWrap) {
            this.giftWrap = giftWrap;
            return this;
        }

        public Builder note(String note) {
            this.note = note;
            return this;
        }

        public Builder deliveryStrategy(DeliveryStrategy strategy) {
            this.deliveryStrategy = strategy;
            return this;
        }

        public Builder addProduct(Product product) {
            this.products.add(product);
            return this;
        }

        public Order build() {
            return new Order(this);
        }
    }

}

