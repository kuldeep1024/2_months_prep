package org.example.java21.day3;

public class NewSwitch {

    public String switchTest(String status) {
        String result = switch (status) {
            //case "SUCCESS": result = "Completed"; break;
            case "SUCCESS" -> "SUCCESS";

            //case "FAILED": result = "Failed"; break;
            case "FAILED" -> "FAILED";

            //default: result = "Unknown";
            default -> "SUCCESS";
        };
        return result;
    }

    public void test(String status) {
        String result = "";
        switch (status) {
            case "SUCCESS":
                result = "SUCCESS";
                break;
            case "FAILED":
                result = "FAILED";
                break;
            default:
                result = "UNKNOWN";
        }

        String result2 = switch (status) {
            case "SUCCESS" -> "SUCCESS";
            case "FAILED" -> "FAILED";
            default -> "UNKNOWN";
        };
    }


    public void test2(String method) {
        int fee = switch (method) {
            case "CARD" -> 20;
            case "WALLET" -> 10;
            case "BANK" -> {
                int baseFee = 5;
                int tax = 1;
                yield baseFee + tax;
            }
            default -> 0;
        };

        //We can still use traditional syntax
        //When using a block inside a switch expression, use yield to return the value.

        int fee2 = switch (method) {
            case "CARD":
                yield 20;
            case "WALLET":
                yield 10;
            case "BANK": {
                int baseFee = 5;
                int tax = 1;
                yield baseFee + tax;
            }
            default:
                yield 0;
        };
    }
}



