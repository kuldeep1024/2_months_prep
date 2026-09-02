package org.example.java21.day2.task_1_PaymentDomain;

public class PaymentDemo {
    static void main(String[] args) {
        PaymentMethod card = new Card("12345678901234",100);
        PaymentMethod wallet = new Wallet("123456789",100);
        PaymentMethod bank = new BankTransfer("12345",100);

        System.out.println(card);
        System.out.println(wallet);
        System.out.println(bank);
    }
}
