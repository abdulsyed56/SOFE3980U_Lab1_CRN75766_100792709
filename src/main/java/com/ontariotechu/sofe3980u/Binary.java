package com.ontariotechu.sofe3980U;

/**
 * Unsigned integer Binary variable
 */
public class Binary {
    // string containing the binary value
    private String number = "0";

    /**
     * A constructor that generates a binary object.
     *
     * @param number a string of binary values.
     */
    public Binary(String number) {
        // handle null or empty
        if (number == null || number.isEmpty()) {
            this.number = "0";
            return;
        }

        // validate each character
        for (int i = 0; i < number.length(); i++) {
            char ch = number.charAt(i);
            if (ch != '0' && ch != '1') {
                this.number = "0";
                return;
            }
        }

        // remove leading zeros
        int beg;
        for (beg = 0; beg < number.length(); beg++) {
            if (number.charAt(beg) != '0') {
                break;
            }
        }

        // if all digits are zero
        if (beg == number.length()) {
            this.number = "0";
        } else {
            this.number = number.substring(beg);
        }

        // lab step: previously commented, now enabled
        if (this.number.isEmpty()) {
            this.number = "0";
        }
    }

    /**
     * Return the binary value of the variable.
     *
     * @return the binary value in a string format.
     */
    public String getValue() {
        return this.number;
    }

    /**
     * Adding two binary variables.
     *
     * @param num1 first addend
     * @param num2 second addend
     * @return a binary variable with a value of num1 + num2
     */
    public static Binary add(Binary num1, Binary num2) {
        int ind1 = num1.number.length() - 1;
        int ind2 = num2.number.length() - 1;

        int carry = 0;
        String num3 = "";

        // loop until all digits and carry are processed
        while (ind1 >= 0 || ind2 >= 0 || carry != 0) {
            int sum = carry;

            if (ind1 >= 0) {
                sum += (num1.number.charAt(ind1) == '1') ? 1 : 0;
                ind1--;
            }

            if (ind2 >= 0) {
                sum += (num2.number.charAt(ind2) == '1') ? 1 : 0;
                ind2--;
            }

            carry = sum / 2;
            sum = sum % 2;

            num3 = ((sum == 0) ? "0" : "1") + num3;
        }

        Binary result = new Binary(num3);
        return result;
    }

    // ----------------------------
    // Bitwise OR
    // ----------------------------
    public static Binary or(Binary num1, Binary num2) {
        String x = num1.number;
        String y = num2.number;

        // pad shorter with zeros on the left
        while (x.length() < y.length()) x = "0" + x;
        while (y.length() < x.length()) y = "0" + y;

        String result = "";
        for (int i = 0; i < x.length(); i++) {
            char cx = x.charAt(i);
            char cy = y.charAt(i);

            if (cx == '1' || cy == '1') {
                result += "1";
            } else {
                result += "0";
            }
        }

        return new Binary(result);
    }

    // ----------------------------
    // Bitwise AND
    // ----------------------------
    public static Binary and(Binary num1, Binary num2) {
        String x = num1.number;
        String y = num2.number;

        // pad shorter with zeros on the left
        while (x.length() < y.length()) x = "0" + x;
        while (y.length() < x.length()) y = "0" + y;

        String result = "";
        for (int i = 0; i < x.length(); i++) {
            char cx = x.charAt(i);
            char cy = y.charAt(i);

            if (cx == '1' && cy == '1') {
                result += "1";
            } else {
                result += "0";
            }
        }

        return new Binary(result);
    }

    // ----------------------------
    // Multiply using shift + add
    // ----------------------------
    public static Binary multiply(Binary num1, Binary num2) {
        // if either is zero, result is zero
        if (num1.number.equals("0") || num2.number.equals("0")) {
            return new Binary("0");
        }

        String multiplier = num2.number;
        Binary total = new Binary("0");
        int shift = 0;

        // go from right to left through multiplier
        for (int i = multiplier.length() - 1; i >= 0; i--) {
            if (multiplier.charAt(i) == '1') {
                String shifted = num1.number;
                for (int k = 0; k < shift; k++) {
                    shifted += "0";
                }
                total = Binary.add(total, new Binary(shifted));
            }
            shift++;
        }

        return total;
    }
}