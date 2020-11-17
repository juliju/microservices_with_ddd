package p1.myshop.shipping.entities;

import java.util.List;
import java.util.stream.Collectors;

public class DeliveryRequest {
    private final List<DeliveryLine> deliveryLines;

    public DeliveryRequest(List<DeliveryLine> deliveryLines) {
        this.deliveryLines = deliveryLines;
    }

    public List<DeliveryLine> getDeliveryLines() {
        return deliveryLines;
    }

    public List<Item> items() {
        return deliveryLines.stream().map(DeliveryLine::getItem).collect(Collectors.toList());
    }
}
