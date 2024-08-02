import org.example.CreditCardPayment;
import org.example.PayPalPayment;
import org.example.PaymentContext;

public class StrategyPatternTest {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        // Pay using Credit Card
        context.setPaymentStrategy(new CreditCardPayment("1234-5678-9012-3456", "John Doe"));
        context.executePayment(250.0);

        // Pay using PayPal
        context.setPaymentStrategy(new PayPalPayment("john.doe@example.com"));
        context.executePayment(150.0);
    }
}

