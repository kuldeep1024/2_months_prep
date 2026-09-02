package org.example.java21.day2.algebraic_data_modelling;

public sealed interface Result<T> permits Success, Failure {
}


//Result<User> result = findUser(id);

//The result can explicitly represent:
//Success<User>
//Failure<User>

// public Result<Payment> processPayment(...) {
//    if (balance < amount) {
//        return new Failure<>("Insufficient balance");
//    }
//
//    return new Success<>(payment);
// }
