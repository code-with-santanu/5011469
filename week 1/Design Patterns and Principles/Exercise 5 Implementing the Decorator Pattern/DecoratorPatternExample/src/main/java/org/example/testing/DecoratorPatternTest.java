package org.example.testing;

import org.example.EmailNotifier;
import org.example.Notifier;
import org.example.SMSNotifierDecorator;
import org.example.SlackNotifierDecorator;

public class DecoratorPatternTest {
    public static void main(String[] args) {
        // Base notifier
        Notifier emailNotifier = new EmailNotifier();

        // Decorate with SMS
        Notifier smsNotifier = new SMSNotifierDecorator(emailNotifier);

        // Decorate with Slack
        Notifier slackNotifier = new SlackNotifierDecorator(smsNotifier);

        // Send notification using all notifiers
        slackNotifier.send("This is a test notification.");

        // Output will be:
        // Sending Email: This is a test notification.
        // Sending SMS: This is a test notification.
        // Sending Slack message: This is a test notification.
    }
}

