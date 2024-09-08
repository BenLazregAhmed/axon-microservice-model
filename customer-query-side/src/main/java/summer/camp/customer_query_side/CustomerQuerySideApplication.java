package summer.camp.customer_query_side;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.NoTypePermission;
import com.thoughtworks.xstream.security.NullPermission;
import com.thoughtworks.xstream.security.PrimitiveTypePermission;
import org.axonframework.commandhandling.CommandBus;
import org.axonframework.commandhandling.SimpleCommandBus;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerQuerySideApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerQuerySideApplication.class, args);
	}

	@Bean
	public CommandBus commandBus(){
		return SimpleCommandBus.builder().build();
	}
	@Bean
	public XStream xStream() {
		XStream xStream = new XStream();

		xStream.allowTypesByWildcard(new String[] { "summer.camp.**" });
		return xStream;
	}
}
