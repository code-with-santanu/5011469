import org.example.Customer;
import org.example.CustomerRepository;
import org.example.CustomerRepositoryImpl;
import org.example.CustomerService;

public class DependencyInjectionTest {
    public static void main(String[] args) {
        // Create the repository
        CustomerRepository customerRepository = new CustomerRepositoryImpl();

        // Inject the repository into the service
        CustomerService customerService = new CustomerService(customerRepository);

        // Use the service to find a customer
        Customer customer = customerService.getCustomerById("123");
        System.out.println(customer);
    }
}

