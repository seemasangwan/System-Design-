/**
 * Main class to demonstrate usage of Builder Design Pattern
 */
public class Main {

    public static void main(String[] args) {
        Payment payment= new Payment.PaymentBuilder(123, PaymentMethod.UPI)
                .upiId("12243")
                .description("testing")
                .build();
        payment.printPaymentInfo();

    }
}
