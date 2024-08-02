package org.example;

public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public Customer findCustomerById(String id) {
        // For demonstration purposes, we return a dummy customer
        return new Customer(id, "John Doe", "john.doe@example.com");
    }
}
