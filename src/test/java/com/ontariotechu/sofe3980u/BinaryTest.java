package com.ontariotechu.sofe3980U;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for Binary class.
 */
public class BinaryTest {

    /**
     * Test the constructor with a valid binary value.
     */
    @Test
    public void normalConstructor() {
        Binary binary = new Binary("1001001");
        assertTrue(binary.getValue().equals("1001001"));
    }

    /**
     * Test the constructor with an invalid binary value with out-of-range digits.
     */
    @Test
    public void constructorWithInvalidDigits() {
        Binary binary = new Binary("1001001211");
        assertTrue(binary.getValue().equals("0"));
    }

    /**
     * Test the constructor with an invalid binary value that has alphabetic characters.
     */
    @Test
    public void constructorWithInvalidChars() {
        Binary binary = new Binary("1001001A");
        assertTrue(binary.getValue().equals("0"));
    }

    /**
     * Test the constructor with an invalid binary value that has a sign.
     */
    @Test
    public void constructorWithNegativeSign() {
        Binary binary = new Binary("-1001001");
        assertTrue(binary.getValue().equals("0"));
    }

    /**
     * Test the constructor with a zero-leading valid binary value.
     */
    @Test
    public void constructorWithZeroTailing() {
        Binary binary = new Binary("00001001");
        assertTrue(binary.getValue().equals("1001"));
    }

    /**
     * Test the constructor with an empty string.
     */
    @Test
    public void constructorEmptyString() {
        Binary binary = new Binary("");
        assertTrue(binary.getValue().equals("0"));
    }

    /**
     * Test add with two numbers of the same length.
     */
    @Test
    public void add() {
        Binary binary1 = new Binary("1000");
        Binary binary2 = new Binary("1111");
        Binary binary3 = Binary.add(binary1, binary2);
        assertTrue(binary3.getValue().equals("10111"));
    }

    /**
     * Test add where first argument is longer.
     */
    @Test
    public void add2() {
        Binary binary1 = new Binary("1010");
        Binary binary2 = new Binary("11");
        Binary binary3 = Binary.add(binary1, binary2);
        assertTrue(binary3.getValue().equals("1101"));
    }

    /**
     * Test add where second argument is longer.
     */
    @Test
    public void add3() {
        Binary binary1 = new Binary("11");
        Binary binary2 = new Binary("1010");
        Binary binary3 = Binary.add(binary1, binary2);
        assertTrue(binary3.getValue().equals("1101"));
    }

    /**
     * Test add with zero.
     */
    @Test
    public void add4() {
        Binary binary1 = new Binary("0");
        Binary binary2 = new Binary("1010");
        Binary binary3 = Binary.add(binary1, binary2);
        assertTrue(binary3.getValue().equals("1010"));
    }

    /**
     * Test add with two zeros.
     */
    @Test
    public void add5() {
        Binary binary1 = new Binary("0");
        Binary binary2 = new Binary("0");
        Binary binary3 = Binary.add(binary1, binary2);
        assertTrue(binary3.getValue().equals("0"));
    }

    @Test
    public void testOrSimple() {
        Binary a = new Binary("1010");
        Binary b = new Binary("0011");
        Binary r = Binary.or(a, b);
        assertTrue(r.getValue().equals("1011"));
    }

    @Test
    public void testAndSimple() {
        Binary a = new Binary("1010");
        Binary b = new Binary("0011");
        Binary r = Binary.and(a, b);
        // result is logically 0010, but Binary trims leading zeros, so it stores "10"
        assertTrue(r.getValue().equals("10"));
    }

    @Test
    public void testMultiplySimple() {
        Binary a = new Binary("0010"); // 2
        Binary b = new Binary("0011"); // 3
        Binary r = Binary.multiply(a, b);
        assertTrue(r.getValue().equals("110")); // 6
    }

    @Test
    public void testOrWithZeros() {
        Binary a = new Binary("0");
        Binary b = new Binary("1111");
        Binary r = Binary.or(a, b);
        assertTrue(r.getValue().equals("1111"));
    }

    @Test
    public void testAndAllZeros() {
        Binary a = new Binary("0000");
        Binary b = new Binary("1111");
        Binary r = Binary.and(a, b);
        assertTrue(r.getValue().equals("0"));
    }

    @Test
    public void testMultiplyZero() {
        Binary a = new Binary("0");
        Binary b = new Binary("1101");
        Binary r = Binary.multiply(a, b);
        assertTrue(r.getValue().equals("0"));
    }
}