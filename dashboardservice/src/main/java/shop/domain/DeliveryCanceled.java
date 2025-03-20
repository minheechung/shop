package shop.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;
import shop.infra.AbstractEvent;

@Data
public class DeliveryCanceled extends AbstractEvent {

    private Long id;
    private String customerId;
    private String orderId;
    private String status;
    private String productId;
    private Integer qty;
    private String address;
}
