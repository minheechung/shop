package shop.domain;

import java.util.*;
import lombok.*;
import shop.domain.*;
import shop.infra.AbstractEvent;

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
}
