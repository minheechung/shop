package shop.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;
import shop.infra.AbstractEvent;

@Data
public class Orderplaced extends AbstractEvent {

    private Long id;
    private String customerId;
    private String productId;
    private Integer price;
    private String qty;
    private String status;
    private String address;
}
