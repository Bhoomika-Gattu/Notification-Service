package in.arjun.client;


import in.arjun.request.NotificationRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(url = "http://localhost:9090/order/",name = "ORDER-CLIENT")
public interface OrderClient {

    @GetMapping("/orderData")
    public List<NotificationRequest> getOrdersByDeliveryDate();
}
