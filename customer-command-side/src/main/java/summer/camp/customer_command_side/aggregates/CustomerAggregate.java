package summer.camp.customer_command_side.aggregates;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import summer.camp.commands.CreateCustomerCommand;
import summer.camp.events.CustomerCreatedEvent;

@Aggregate
@NoArgsConstructor
@Slf4j
public class CustomerAggregate {
    @AggregateIdentifier
    private String id;
    private String name;
    private String email;
    @CommandHandler
    public CustomerAggregate(CreateCustomerCommand command)
    {
        log.info("CreateCustomerCommand received");
        AggregateLifecycle.apply(
                new CustomerCreatedEvent(
                        command.getId(),
                        command.getName(),
                        command.getEmail()
                )
        );
    }
    @EventHandler
    public void on(CustomerCreatedEvent createdEvent)
    {
        log.info("CustomerCreatedEvent occurred");
        this.id=createdEvent.getId();
        this.name= createdEvent.getName();
        this.email= createdEvent.getEmail();
    }
}
