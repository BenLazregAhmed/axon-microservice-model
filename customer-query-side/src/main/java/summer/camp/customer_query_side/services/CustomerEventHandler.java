package summer.camp.customer_query_side.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.springframework.stereotype.Service;
import summer.camp.customer_query_side.entities.Customer;
import summer.camp.customer_query_side.repositories.CustomersRepo;
import summer.camp.events.CustomerCreatedEvent;

import java.time.temporal.ChronoUnit;

@Service
@AllArgsConstructor
@Slf4j
public class CustomerEventHandler {
    private CustomersRepo customersRepo;

    @EventHandler
    public void on(CustomerCreatedEvent event){
        log.info("************************************");
        log.info("CustomerCreatedEvent received");
        customersRepo.save(
                Customer.builder()
                        .id(event.getId())
                        .email(event.getEmail())
                        .name(event.getName())
                        .build()
        );
    }
}
