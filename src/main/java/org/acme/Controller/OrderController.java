package org.acme.Controller;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.acme.Builder.Order;
import org.acme.ChainOfResponsibility.OrderHandler;
import org.acme.ChainOfResponsibility.PackagingHandler;
import org.acme.ChainOfResponsibility.PaymentHandler;
import org.acme.ChainOfResponsibility.ShippingHandler;
import org.acme.ChainOfResponsibility.StockCheckHandler;
import org.acme.Request.OrderRequest;
import org.acme.Factory.ProductFactory;
import org.acme.Factory.ProductType;
import org.acme.Strategy.DeliveryStrategyFactory;

@Path("/order")
public class OrderController {

    @POST
    public Response createOrder(OrderRequest request) {

        Order.Builder orderBuilder = new Order.Builder(request.getCustomerName(), request.getAddress())
                .giftWrap(request.isGiftWrap())
                .note(request.getNote())
                .deliveryStrategy(DeliveryStrategyFactory.getStrategy(request.getDeliveryType()));

        for (ProductType productType : request.getProductTypes()) {
            orderBuilder.addProduct(ProductFactory.createProduct(productType));
        }
        Order order = orderBuilder.build();
        System.out.println("hello world  ");
        OrderHandler orderHandler = new StockCheckHandler();
        orderHandler
                .setNext(new PaymentHandler())
                .setNext(new PackagingHandler())
                .setNext(new ShippingHandler());
        orderHandler.handle(order);

        return Response.ok("Successful, order created").build();
    }

}
