package shop.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import shop.domain.*;
import shop.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class Orderplaced extends AbstractEvent {

    private Long id;
    private String customerId;
    private String productId;
    private Integer price;
    private String qty;
    private String status;
    private String address;

    public Orderplaced(Order aggregate) {
        super(aggregate);
    }

    public Orderplaced() {
        super();
    }
}
//>>> DDD / Domain Event
