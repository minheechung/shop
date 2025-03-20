package shop.infra;

import shop.domain.*;
import shop.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ViewStatusViewHandler {

//<<< DDD / CQRS
    @Autowired
    private ViewStatusRepository viewStatusRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderplaced_then_CREATE_1 (@Payload Orderplaced orderplaced) {
        try {

            if (!orderplaced.validate()) return;

            // view 객체 생성
            ViewStatus viewStatus = new ViewStatus();
            // view 객체에 이벤트의 Value 를 set 함
            viewStatus.setId(orderplaced.getId());
            viewStatus.setCustomerId(orderplaced.getCustomerId());
            viewStatus.setProductId(orderplaced.getProductId());
            viewStatus.setQty(Integer.parseInt(orderplaced.getQty()));
            viewStatus.setAddress(orderplaced.getAddress());
            viewStatus.setOrderStatus(ordered);
            // view 레파지 토리에 save
            viewStatusRepository.save(viewStatus);

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenDeliveryStarted_then_UPDATE_1(@Payload DeliveryStarted deliveryStarted) {
        try {
            if (!deliveryStarted.validate()) return;
                // view 객체 조회
            Optional<ViewStatus> viewStatusOptional = viewStatusRepository.findById(Long.valueOf(deliveryStarted.getOrderId()));

            if( viewStatusOptional.isPresent()) {
                 ViewStatus viewStatus = viewStatusOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                viewStatus.setDeliveryStatus(delivery start);    
                // view 레파지 토리에 save
                 viewStatusRepository.save(viewStatus);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenDeliveryCanceled_then_UPDATE_2(@Payload DeliveryCanceled deliveryCanceled) {
        try {
            if (!deliveryCanceled.validate()) return;
                // view 객체 조회
            Optional<ViewStatus> viewStatusOptional = viewStatusRepository.findById(Long.valueOf(deliveryCanceled.getOrderId()));

            if( viewStatusOptional.isPresent()) {
                 ViewStatus viewStatus = viewStatusOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                viewStatus.setDeliveryStatus(delivery canceled);    
                // view 레파지 토리에 save
                 viewStatusRepository.save(viewStatus);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }


//>>> DDD / CQRS
}

