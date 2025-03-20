package shop.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import shop.SupportServiceApplication;
import shop.domain.DeliveryCanceled;
import shop.domain.DeliveryStarted;

@Entity
@Table(name = "Deliveryad_table")
@Data
//<<< DDD / Aggregate Root
public class Deliveryad {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String orderId;

    private String address;

    private String customerId;

    private String productId;

    private Integer qty;

    private String status;

    public static DeliveryadRepository repository() {
        DeliveryadRepository deliveryadRepository = SupportServiceApplication.applicationContext.getBean(
            DeliveryadRepository.class
        );
        return deliveryadRepository;
    }

    //<<< Clean Arch / Port Method
    public static void deliveryStart(Orderplaced orderplaced) {
        //implement business logic here:

        /** Example 1:  new item 
        Deliveryad deliveryad = new Deliveryad();
        repository().save(deliveryad);

        DeliveryStarted deliveryStarted = new DeliveryStarted(deliveryad);
        deliveryStarted.publishAfterCommit();
        */

        /** Example 2:  finding and process
        

        repository().findById(orderplaced.get???()).ifPresent(deliveryad->{
            
            deliveryad // do something
            repository().save(deliveryad);

            DeliveryStarted deliveryStarted = new DeliveryStarted(deliveryad);
            deliveryStarted.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void deliveryCancel(OrderCanceled orderCanceled) {
        //implement business logic here:

        /** Example 1:  new item 
        Deliveryad deliveryad = new Deliveryad();
        repository().save(deliveryad);

        DeliveryCanceled deliveryCanceled = new DeliveryCanceled(deliveryad);
        deliveryCanceled.publishAfterCommit();
        */

        /** Example 2:  finding and process
        

        repository().findById(orderCanceled.get???()).ifPresent(deliveryad->{
            
            deliveryad // do something
            repository().save(deliveryad);

            DeliveryCanceled deliveryCanceled = new DeliveryCanceled(deliveryad);
            deliveryCanceled.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
