package com.cognizant.decorator;

public class DecoratorTest {

    public static void main(String[] args) {

        // Base notification
        Notifier notifier = new EmailNotifier();

        System.out.println("---- Basic Email ----");
        notifier.send("Hello User");

        System.out.println();

        // Add SMS feature
        notifier = new SMSNotifierDecorator(new EmailNotifier());

        System.out.println("---- Email + SMS ----");
        notifier.send("Hello User");

        System.out.println();

        // Add SMS + Slack
        notifier = new SlackNotifierDecorator(
                        new SMSNotifierDecorator(
                            new EmailNotifier()
                        )
                    );

        System.out.println("---- Email + SMS + Slack ----");
        notifier.send("Hello User");

    }

}