package p1.myshop.shipping.domain;

import p1.myshop.shipping.domain.entities.DeliveryRequest;
import p1.myshop.shipping.domain.entities.HasWeight;


public class DeliveryService {


    public double calculateDeliveryWeight(DeliveryRequest request) {
        return request.items().stream()
                .mapToDouble(HasWeight::weight)
                .sum();
    }


}
