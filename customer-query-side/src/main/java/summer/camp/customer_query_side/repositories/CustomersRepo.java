package summer.camp.customer_query_side.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import summer.camp.customer_query_side.entities.Customer;

public interface CustomersRepo extends JpaRepository<Customer,String> {
}
