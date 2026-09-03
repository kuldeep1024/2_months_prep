package org.example.java21.day3.pattern_matching;

public class MainTest {
    static void main(String[] args) {




    }

    //Traditional code might be:
    public static void test(PaymentMethod paymentMethod) {
        int result = 0;
        if (paymentMethod instanceof Card) {
            Card card = (Card) paymentMethod;
            result = card.calculateCardFee();
        }
        //...


        if (paymentMethod instanceof Card card) {
            result = card.calculateCardFee();
        }else if (paymentMethod instanceof BankTransfer bank) {
            result = bank.calculateBankFee();
        } else if (paymentMethod instanceof Wallet wallet) {
            result = wallet.calculateWalletFee();
        }
    }

    //Pattern Matching for switch
    public static void test2(PaymentMethod paymentMethod) {
        int fee = switch ((paymentMethod)){
            case Card card -> card.calculateCardFee();
            case BankTransfer bank -> bank.calculateBankFee();
            case Wallet wallet -> wallet.calculateWalletFee();
        };
    }
}
