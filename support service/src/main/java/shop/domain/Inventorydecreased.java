package shop.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import shop.domain.*;
import shop.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class Inventorydecreased extends AbstractEvent {

    private Long id;

    public Inventorydecreased(Inventory aggregate) {
        super(aggregate);
    }

    public Inventorydecreased() {
        super();
    }
}
//>>> DDD / Domain Event
