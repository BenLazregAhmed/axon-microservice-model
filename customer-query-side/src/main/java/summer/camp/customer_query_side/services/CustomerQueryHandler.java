package summer.camp.customer_query_side.services;

import lombok.AllArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;
import summer.camp.customer_query_side.entities.Customer;
import summer.camp.customer_query_side.repositories.CustomersRepo;
import summer.camp.query.GetAllCustomersQuery;
import summer.camp.query.GetCustomerByIdQuery;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerQueryHandler {
    private CustomersRepo customersRepo;
    @QueryHandler
    public List<Customer> customerList(GetAllCustomersQuery query){
        {
            return customersRepo.findAll();
        }}
    @QueryHandler
    public Customer customerList(GetCustomerByIdQuery query){
        return customersRepo.findById(query.getId())
                .orElseThrow(()->new RuntimeException("Customer not found !!!"));
    }
    }
