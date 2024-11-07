package in.arjun.client;

import in.arjun.request.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "http://localhost:9091/",name = "CUSTOMER-CLIENT")
public interface CustomerClient {

    @GetMapping("/customer/{id}")
    public Customer findCustomerById(@PathVariable("id") Long id);
}
