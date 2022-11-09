package com.livatek;

import java.util.Arrays;

public class TestMain {

    public static void main(String[] args) {
        test(new String[]{"12", "139.95", "book", "–-output-currency=SEK", "--vat=DK"}, "3122.60 SEK");
        test(new String[]{"12", "139.95", "book", "–-input-currency=DKK", "–-output-currency=SEK", "--vat=DK"},
                "3122.60 SEK");
        test(new String[]{"23", "199.95", "book"}, "4698.85 DKK");
        test(new String[]{"23", "199.95", "online"}, "4598.85 DKK");

    }

    private static void test(String[] testArgs, String expectedResult) {
        System.out.println("---------------------------------");
        System.out.println("Params: " + Arrays.toString(testArgs));
        System.out.println("Expected price: " + expectedResult);
        String totalPrice = Main.getTotalPrice(testArgs);
        System.out.println("Calculated price: " + totalPrice);

        if (!totalPrice.equals(expectedResult)) {
            System.out.println("Test failed");
        } else
            System.out.println("Test passed");
    }
}
