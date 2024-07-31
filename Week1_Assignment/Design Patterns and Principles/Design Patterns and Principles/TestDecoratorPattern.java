public class TestDecoratorPattern { 
    public static void main(String[] args) { 
        Notifier emailNotifier = new EmailNotifier(); 
        Notifier smsNotifier = new SMSNotifierDecorator(emailNotifier); 
        Notifier slackNotifier = new SlackNotifierDecorator(smsNotifier); 
 
        // Send notification via Email, SMS, and Slack 
        slackNotifier.send("Hello, this is a test notification."); 
    } 
} 
