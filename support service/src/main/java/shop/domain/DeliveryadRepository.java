package shop.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import shop.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "deliveryads",
    path = "deliveryads"
)
public interface DeliveryadRepository
    extends PagingAndSortingRepository<Deliveryad, Long> {}
