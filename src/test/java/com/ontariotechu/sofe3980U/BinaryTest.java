package com.ontariotechu.sofe3980U;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for Binary class.
 */
public class BinaryTest 
{
    /**
     * Test The constructor with a valid binary vallue
     */
    @Test
    public void normalConstructor()
    {
		Binary binary=new Binary("1001001");
        assertTrue( binary.getValue().equals("1001001"));
    }
    /**
     * Test The constructor with an invalid binary value of out-of-range digits
     */
    @Test
    public void constructorWithInvalidDigits()
    {
		Binary binary=new Binary("1001001211");
        assertTrue( binary.getValue().equals("0"));
    }
    /**
     * Test The constructor with an invalid binary value of alphabetic characters
     */
    @Test
    public void constructorWithInvalidChars()
    {
		Binary binary=new Binary("1001001A");
        assertTrue( binary.getValue().equals("0"));
    }
    /**
     * Test The constructor with an invalid binary value that has a sign
     */
    @Test
    public void constructorWithNegativeSign()
    {
		Binary binary=new Binary("-1001001");
        assertTrue( binary.getValue().equals("0"));
    }
    /**
     * T	est The constructor with a zero tailing valid binary value
     */
    @Test
    public void constructorWithZeroTailing()
    {
		Binary binary=new Binary("00001001");
        assertTrue( binary.getValue().equals("1001"));
    }
    /**
     * Test The constructor with an empty string
     */
    @Test
    public void constructorEmptyString()
    {
		Binary binary=new Binary("");
        assertTrue( binary.getValue().equals("0"));
    }
	/**
     * Test The add functions with two binary numbers of the same length
     */
    @Test
    public void add()
    {
		Binary binary1=new Binary("1000");
		Binary binary2=new Binary("1111");
		Binary binary3=Binary.add(binary1,binary2);
        assertTrue( binary3.getValue().equals("10111"));
    }
	/**
     * Test The add functions with two binary numbers, the length of the first argument is less than the second
     */
    @Test
    public void add2()
    {
		Binary binary1=new Binary("1010");
		Binary binary2=new Binary("11");
		Binary binary3=Binary.add(binary1,binary2);
        assertTrue( binary3.getValue().equals("1101"));
    }
	/**
     * Test The add functions with two binary numbers, the length of the first argument is greater than the second
     */
    @Test
    public void add3()
    {
		Binary binary1=new Binary("11");
		Binary binary2=new Binary("1010");
		Binary binary3=Binary.add(binary1,binary2);
        assertTrue( binary3.getValue().equals("1101"));
    }
	/**
     * Test The add functions with a binary numbers with zero
     */
    @Test
    public void add4()
    {
		Binary binary1=new Binary("0");
		Binary binary2=new Binary("1010");
		Binary binary3=Binary.add(binary1,binary2);
        assertTrue( binary3.getValue().equals("1010"));
    }
	/**
     * Test The add functions with two zeros
     */
    @Test
    public void add5()
    {
		Binary binary1=new Binary("0");
		Binary binary2=new Binary("0");
		Binary binary3=Binary.add(binary1,binary2);
        assertTrue( binary3.getValue().equals("0"));
    }

/**
 * Test the OR operation for two binary numbers.
 */
@Test
public void or() {
    Binary binary1 = new Binary("10001000"); // Binary representation of 136
    Binary binary2 = new Binary("111000");   // Binary representation of 56

    Binary binary3 = Binary.or(binary1, binary2);
    assertTrue(binary3.getValue().equals("10111000")); // OR result of 10001000 and 111000
}

/**
 * Test the OR operation when one binary number is zero.
 */
@Test
public void or2() {
    Binary binary1 = new Binary("0");        // Binary representation of 0
    Binary binary2 = new Binary("11111111"); // Binary representation of 255

    Binary binary3 = Binary.or(binary1, binary2);
    assertTrue(binary3.getValue().equals("11111111")); // OR result of 0 and 11111111
}

/**
 * Test the OR operation with alternating bits in two binary numbers.
 */
@Test
public void or3() {
    Binary binary1 = new Binary("10101010"); // Binary representation of 170
    Binary binary2 = new Binary("01010101"); // Binary representation of 85

    Binary binary3 = Binary.or(binary1, binary2);
    assertTrue(binary3.getValue().equals("11111111")); // OR result of 10101010 and 01010101
}

/**
 * Test the AND operation for two binary numbers.
 */
@Test
public void and() {
    Binary binary1 = new Binary("10001000"); // Binary representation of 136
    Binary binary2 = new Binary("111000");   // Binary representation of 56

    Binary binary3 = Binary.and(binary1, binary2);
    assertTrue(binary3.getValue().equals("1000")); // AND result of 10001000 and 111000
}

/**
 * Test the AND operation when one binary number is zero.
 */
@Test
public void and2() {
    Binary binary1 = new Binary("11111111"); // Binary representation of 255
    Binary binary2 = new Binary("0");        // Binary representation of 0

    Binary binary3 = Binary.and(binary1, binary2);
    assertTrue(binary3.getValue().equals("0")); // AND result of 11111111 and 0
}

/**
 * Test the AND operation with overlapping bits in two binary numbers.
 */
@Test
public void and3() {
    Binary binary1 = new Binary("10101010"); // Binary representation of 170
    Binary binary2 = new Binary("11110000"); // Binary representation of 240

    Binary binary3 = Binary.and(binary1, binary2);
    assertTrue(binary3.getValue().equals("10100000")); // AND result of 10101010 and 11110000
}

/**
 * Test the multiplication operation for two binary numbers.
 */
@Test
public void multiply() {
    Binary binary1 = new Binary("1010"); // Binary representation of 10
    Binary binary2 = new Binary("11");   // Binary representation of 3

    Binary binary3 = Binary.multiply(binary1, binary2);
    assertTrue(binary3.getValue().equals("11110")); // Multiplication result of 1010 (10) and 11 (3)
}

/**
 * Test the multiplication operation when one binary number is zero.
 */
@Test
public void multiply2() {
    Binary binary1 = new Binary("0");       // Binary representation of 0
    Binary binary2 = new Binary("1111111"); // Binary representation of 127

    Binary binary3 = Binary.multiply(binary1, binary2);
    assertTrue(binary3.getValue().equals("0")); // Multiplication result of 0 and 1111111
}

/**
 * Test the multiplication operation for two binary numbers with different lengths.
 */
@Test
public void multiply3() {
    Binary binary1 = new Binary("1101");   // Binary representation of 13
    Binary binary2 = new Binary("1010");   // Binary representation of 10

    Binary binary3 = Binary.multiply(binary1, binary2);
    assertTrue(binary3.getValue().equals("10000010")); // Multiplication result of 13 * 10
}

}