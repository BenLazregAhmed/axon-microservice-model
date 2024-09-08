package summer.camp.customer_query_side.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter@Setter
@Builder
@Entity
public class Customer {
    @Id
    private String id;
    private String name;
    private String email;
}
