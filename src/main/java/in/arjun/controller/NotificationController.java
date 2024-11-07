package in.arjun.controller;

import in.arjun.client.CustomerClient;
import in.arjun.client.OrderClient;
import in.arjun.request.Customer;
import in.arjun.request.NotificationRequest;
import in.arjun.service.EmailService;
import in.arjun.service.PDFGenarationService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;
import java.util.List;

@Component
public class NotificationController {

    @Autowired
    private OrderClient orderClient;

    @Autowired
    private PDFGenarationService pdfGeneratorService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private CustomerClient customerClient;

    @Scheduled(cron = "0 0 7 * * *")
    public  void getOrderDataByDate() throws MessagingException {
        List<NotificationRequest> ordersByDeliveryDate = orderClient.getOrdersByDeliveryDate();
        for (NotificationRequest notificationRequest: ordersByDeliveryDate) {
            ByteArrayInputStream bis = pdfGeneratorService.generateOrderInvoicePdf(notificationRequest);


            Long customerId = notificationRequest.getOrderData().getCustomerId();

            Customer customerById = customerClient.findCustomerById(customerId);


            String message = "Dear " + customerById.getName()+ ",\n\n" +
                    "Your order with tracking ID  :" + notificationRequest.getOrderData().getOrderTrackingNumber() + "\n has been delivering today.\n" +
                    "Please collect your order.\n\nThank you!";
            emailService.sendOrderDeliveryEmail(customerById.getEmail(),
                    "Order Delivering today",
                    message,
                    bis);
        }
    }
}
