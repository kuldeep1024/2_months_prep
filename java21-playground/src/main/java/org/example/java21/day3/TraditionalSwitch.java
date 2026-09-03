package org.example.java21.day3;

public class TraditionalSwitch {

    public static void main(String[] args) {
        System.out.println(switchTraditional("SUCCESS"));
    }

    //There are two problems:
    //We need a separate variable.
    //We need break, otherwise fall-through can happen.
    public static String switchTraditional(String status) {

        String result = "";

        switch (status) {
            case "SUCCESS":
                result = "Completed";
                break;

            case "FAILED":
                result = "Failed";
                break;

            default:
                result = "Unknown";
        }

        return result;
    }
}
