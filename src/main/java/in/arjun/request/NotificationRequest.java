package in.arjun.request;

import jakarta.websocket.OnOpen;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NotificationRequest {

    private OrderDataRequest orderData;
    private List<OrderItemsRequest> orderItems;

}
