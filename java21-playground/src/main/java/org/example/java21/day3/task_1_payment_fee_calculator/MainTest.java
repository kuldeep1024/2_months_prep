package org.example.java21.day3.task_1_payment_fee_calculator;

public class MainTest {
    static void main(String[] args) {
        System.out.println(calculateFee(new Card("12345", 100)));
        System.out.println(calculateFee(new Wallet("12345", 100)));
    }


    //Notice something important: there is no default.
    //Why?
    //Because Java knows that PaymentMethod can only be: Card, BankTransfer, Wallet
    public static int calculateFee(PaymentMethod paymentMethod) {

        return switch (paymentMethod) {
            case Card card -> 20;
            case BankTransfer transfer -> 10;
            case Wallet wallet -> 5;
        };
    }

    //Then remove Wallet from the switch:
    //like this
    /*return switch (paymentMethod) {
        case Card card -> 20;
        case BankTransfer transfer -> 10;
    };*/

    //The switch is not exhaustive.
    //The compiler will complain because:
    //When the set of possible types is known, the compiler can detect missing cases for us.
}
