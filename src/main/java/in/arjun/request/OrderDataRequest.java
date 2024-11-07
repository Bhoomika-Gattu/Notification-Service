package in.arjun.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDataRequest {

    private Long id;
    private String orderTrackingNumber;
    private String totalQuantity;
    private Double totalPrice;
    private String orderStatus;
    private String razorPayPaymentId;

    private LocalDate deliveryDate;

    private Long customerId;

    private Long addressId;

}
