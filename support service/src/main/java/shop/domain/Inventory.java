package shop.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import shop.SupportServiceApplication;
import shop.domain.InventoryIncreased;
import shop.domain.Inventorydecreased;

@Entity
@Table(name = "Inventory_table")
@Data
//<<< DDD / Aggregate Root
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String productname;

    private Integer qty;

    private Integer price;

    public static InventoryRepository repository() {
        InventoryRepository inventoryRepository = SupportServiceApplication.applicationContext.getBean(
            InventoryRepository.class
        );
        return inventoryRepository;
    }

    //<<< Clean Arch / Port Method
    public static void inventoryIncrease(DeliveryCanceled deliveryCanceled) {
        //implement business logic here:

        /** Example 1:  new item 
        Inventory inventory = new Inventory();
        repository().save(inventory);

        InventoryIncreased inventoryIncreased = new InventoryIncreased(inventory);
        inventoryIncreased.publishAfterCommit();
        */

        /** Example 2:  finding and process
        

        repository().findById(deliveryCanceled.get???()).ifPresent(inventory->{
            
            inventory // do something
            repository().save(inventory);

            InventoryIncreased inventoryIncreased = new InventoryIncreased(inventory);
            inventoryIncreased.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void inventoryDecrease(DeliveryStarted deliveryStarted) {
        //implement business logic here:

        /** Example 1:  new item 
        Inventory inventory = new Inventory();
        repository().save(inventory);

        Inventorydecreased inventorydecreased = new Inventorydecreased(inventory);
        inventorydecreased.publishAfterCommit();
        */

        /** Example 2:  finding and process
        

        repository().findById(deliveryStarted.get???()).ifPresent(inventory->{
            
            inventory // do something
            repository().save(inventory);

            Inventorydecreased inventorydecreased = new Inventorydecreased(inventory);
            inventorydecreased.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
