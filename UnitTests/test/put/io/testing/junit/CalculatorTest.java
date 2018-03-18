package put.io.testing.junit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {
    private Calculator calculator = null;
    @Before
    public void setUp(){
        calculator = new Calculator();
    }

    @After
    public void tearDown(){
        calculator = null;
    }

    @Test
    public  void testAdd(){
        assertEquals("błąd dodawania", 6, calculator.add(2, 4));

    }
    @Test
    public  void testAddNegative(){
        assertEquals("błąd dodawania liczb ujemnych", -8, calculator.add(-6, -2));

    }
    @Test
    public void testAddMaxValue(){

        long maxValue =  2147483647;
        maxValue = maxValue+3;
        assertEquals("błąd dodawania overflow dodatnie", maxValue, calculator.add(3, 2147483647));
    }
    @Test
    public void testAddMinValue(){

        long minValue =  -2147483648;
        minValue = minValue + (-3);
        assertEquals("błąd dodawania overflow ujemne", minValue, calculator.add(-3, -2147483648));
    }
    @Test
    public  void testMultiply(){
        assertEquals("błąd mnożenia", 12, calculator.multiply(3, 4));

    }
    @Test
    public  void testMultiplyMaxValue(){
        long maxValue =  2147483647;
        maxValue = maxValue * 2;

        assertEquals("błąd mnożenia overflow dodatnie", maxValue, calculator.multiply(2, 2147483647));

    }
    @Test
    public  void testMultiplyMinValue(){
        long maxValue =  -2147483648;
        maxValue = maxValue * 2;

        assertEquals("błąd mnożenia overflow dodatnie", maxValue, calculator.multiply(2, 2147483647));

    }

    @Test
    public  void testMultiplyNegative(){
        assertEquals("błąd mnożenia liczb ujemnych", 12, calculator.multiply(-3, -4));

    }
    @Test(expected = IllegalArgumentException.class)
    public void testAddPositiveNumbers(){
        calculator.addPositiveNumbers(-3, 4);

    }


}