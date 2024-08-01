package org.example.test;

import org.example.PayPal;
import org.example.PaymentProcessor;
import org.example.Square;
import org.example.Stripe;
import org.example.adapter.PayPalAdapter;
import org.example.adapter.SquareAdapter;
import org.example.adapter.StripeAdapter;

public class AdapterPatternTest {
    public static void main(String[] args) {
        // Using PayPal through the adapter
        PayPal payPal = new PayPal();
        PaymentProcessor payPalAdapter = new PayPalAdapter(payPal);
        payPalAdapter.processPayment(100.0);

        // Using Stripe through the adapter
        Stripe stripe = new Stripe();
        PaymentProcessor stripeAdapter = new StripeAdapter(stripe);
        stripeAdapter.processPayment(200.0);

        // Using Square through the adapter
        Square square = new Square();
        PaymentProcessor squareAdapter = new SquareAdapter(square);
        squareAdapter.processPayment(300.0);
    }
}
