package put.io.testing.junit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FailureOrErrorTest {

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
    // tutaj failure
    public void test1(){
        assertEquals("spodziewane: failure", 10, calculator.add(3, 9));
    }
    @Test
    // a tutaj error
    public void test2(){
        calculator.addPositiveNumbers(-3, 4);
    }
    @Test
    // asercja niepoprawna, ukryte failure
    public void test3(){
        try{
            assertTrue(false);
        } catch (Throwable throwable){
            throwable.printStackTrace();
        }
    }
    @Test
    // asercja poprawna, wymuszone failure
    public void test4(){
        assertTrue(true);
        throw new AssertionError();
    }


}