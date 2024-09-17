package org.acme.ChainOfResponsibility;

import org.acme.Builder.Order;

public class PackagingHandler extends OrderHandler{

    @Override
    public void handle(Order order) {
        System.out.print("Packaging order ( ");
        order.getProducts().forEach(product -> System.out.print(product.getName()+" "));
        System.out.println(")");
        if (next != null) {
            next.handle(order);
        }
    }
}
