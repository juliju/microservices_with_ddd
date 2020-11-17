package p1.myshop.shipping.services;

import p1.myshop.shipping.entities.DeliveryRequest;
import p1.myshop.shipping.entities.HasWeight;


public class DeliveryService {


    public double calculateDeliveryWeight(DeliveryRequest request) {
        return request.items().stream()
                .mapToDouble(HasWeight::weight)
                .sum();
    }


}
