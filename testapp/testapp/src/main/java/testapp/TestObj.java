package testapp;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import testapp.Testapp;
 
public class TestObj {
 
    @Test
    public void testEvenOddNumber(){
        Testapp meo = new Testapp();
        assertEquals("10 is a even number", true, meo.isEvenNumber(10));
    }
}