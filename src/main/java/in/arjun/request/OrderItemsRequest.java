package in.arjun.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderItemsRequest {


    private Long id;
    private String imageUrl;
    private String name;
    private Double price;
    private Long quantity;

    private Long productId;
}
