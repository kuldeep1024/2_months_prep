package org.example.java21.day3.record_patterns;

public class NestedRecordPattern {
    static void main(String[] args) {

        Order2 order = null;

        //we can destructure everything directly
        if (order instanceof Order2(Student(var name,
                                            Address(var city, var country)),
                                    var total)) {
            System.out.println(name);
            System.out.println(city);
            System.out.println(country);
            System.out.println(total);
        }

        //Instead of:
        //order.customer().name()
        //order.customer().address().city()
        //order.customer().address().country()
        //order.total()
    }
}

record Address(String city, String country) {
}

record Student(String name, Address address) {
}

record Order2(Student customer, double total) {
}
