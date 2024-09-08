package summer.camp.customer_command_side.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.web.bind.annotation.*;
import summer.camp.commands.CreateCustomerCommand;
import summer.camp.dtos.CustomerRequestDTO;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping(path = "/customers/commands")
public class CustomerCommandRestController {

    CommandGateway commandGateway;
    EventStore eventStore;
    @PostMapping("/create")
    public CompletableFuture<String> createCustomer(@RequestBody CustomerRequestDTO request)
    {
        return commandGateway.send(
                new CreateCustomerCommand(
                        UUID.randomUUID().toString(),
                        request.getName(),
                        request.getEmail()
                )
        );
    }
    @GetMapping("/eventStore/{customerId}")
    public Stream eventStore(@PathVariable String customerId){
        return eventStore.readEvents(customerId).asStream();
    }
}
