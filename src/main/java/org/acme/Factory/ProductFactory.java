package org.acme.Factory;

public class ProductFactory {

    public static Product createProduct(ProductType productType){
        return switch (productType) {
            case ELECTRONIC -> new ElectronicProduct();
            case PHYSICAL -> new PhysicalProduct();
            case SERVICE -> new ServiceProduct();
        };
    }

}
