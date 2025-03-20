package shop.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import shop.config.kafka.KafkaProcessor;
import shop.domain.*;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    DeliveryadRepository deliveryadRepository;

    @Autowired
    InventoryRepository inventoryRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Orderplaced'"
    )
    public void wheneverOrderplaced_DeliveryStart(
        @Payload Orderplaced orderplaced
    ) {
        Orderplaced event = orderplaced;
        System.out.println(
            "\n\n##### listener DeliveryStart : " + orderplaced + "\n\n"
        );

        // Sample Logic //
        Deliveryad.deliveryStart(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='OrderCanceled'"
    )
    public void wheneverOrderCanceled_DeliveryCancel(
        @Payload OrderCanceled orderCanceled
    ) {
        OrderCanceled event = orderCanceled;
        System.out.println(
            "\n\n##### listener DeliveryCancel : " + orderCanceled + "\n\n"
        );

        // Sample Logic //
        Deliveryad.deliveryCancel(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='DeliveryCanceled'"
    )
    public void wheneverDeliveryCanceled_InventoryIncrease(
        @Payload DeliveryCanceled deliveryCanceled
    ) {
        DeliveryCanceled event = deliveryCanceled;
        System.out.println(
            "\n\n##### listener InventoryIncrease : " +
            deliveryCanceled +
            "\n\n"
        );

        // Sample Logic //
        Inventory.inventoryIncrease(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='DeliveryStarted'"
    )
    public void wheneverDeliveryStarted_InventoryDecrease(
        @Payload DeliveryStarted deliveryStarted
    ) {
        DeliveryStarted event = deliveryStarted;
        System.out.println(
            "\n\n##### listener InventoryDecrease : " + deliveryStarted + "\n\n"
        );

        // Sample Logic //
        Inventory.inventoryDecrease(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
