package org.acme;

import io.smallrye.common.constraint.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.acme.Factory.ProductType;
import org.acme.Strategy.DeliveryType;

import java.util.List;

@Setter
@Getter
public class OrderRequest {
    @NotNull
    private String customerName;

    @NotNull
    private String address;

    private boolean giftWrap;

    private String note;

    @NotNull
    private DeliveryType deliveryType;

    @NotNull
    private List<ProductType> productTypes;

}
