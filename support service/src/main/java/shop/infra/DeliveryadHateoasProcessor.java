package shop.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import shop.domain.*;

@Component
public class DeliveryadHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Deliveryad>> {

    @Override
    public EntityModel<Deliveryad> process(EntityModel<Deliveryad> model) {
        return model;
    }
}
