import org.junit.Test;
import static org.junit.Assert.*;
public class BaseTest {

    @Test
    public void test1(){
        int val = (int) ExpressionParser.parse("2/2").calc();
        assertEquals(1, val);
    }

    @Test
    public void test2(){
        int val = (int) ExpressionParser.parse("4/2").calc();
        assertEquals(2, val);
    }

    @Test
    public void test3(){
        int val = (int) ExpressionParser.parse("6/1").calc();
        assertEquals(6, val);
    }

    @Test
    public void test4(){
        String val = (String) ExpressionParser.parse("II+I").calc();
        assertEquals("III", val);
    }

    @Test
    public void test5(){
        String val = (String) ExpressionParser.parse("II*II").calc();
        assertEquals("IV", val);
    }

    @Test
    public void randomArabicTest(){
        String ops="+-/*";
        for(int i=0;i<300;i++) {
            int l = (int) (Math.random() * (9)) + 1;
            int r = (int) (Math.random() * (9)) + 1;
            int opIndex = (int) (Math.random() * (4));

            int val = (int) ExpressionParser.parse(String.valueOf(l)+ops.charAt(opIndex)+String.valueOf(r)).calc();
            //System.out.println(String.valueOf(l)+ops.charAt(opIndex)+String.valueOf(r));
            assertEquals(Expression.operations.get(ops.charAt(opIndex)).applyAsInt(l,r), val);
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testThrow1(){
        ExpressionParser.parse("II.+I").calc();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testThrow2(){
        ExpressionParser.parse(".II+I").calc();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testThrow3(){
        ExpressionParser.parse("II+I.").calc();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testThrow4(){
        ExpressionParser.parse("II-+I").calc();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testThrow5(){
        ExpressionParser.parse("II+2").calc();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testThrow6(){
        ExpressionParser.parse("2+X").calc();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testThrow7(){
        ExpressionParser.parse("11+1").calc();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testThrow8(){
        ExpressionParser.parse("1+11").calc();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testThrow9(){
        ExpressionParser.parse("XI+I").calc();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testThrow10(){
        ExpressionParser.parse("I+XI").calc();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testThrow11(){
        ExpressionParser.parse("-1+1").calc();
    }


    @Test(expected = IllegalArgumentException.class)
    public void testThrow12(){
        ExpressionParser.parse("X+2").calc();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testThrow13(){
        ExpressionParser.parse("X+").calc();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testThrow14(){
        ExpressionParser.parse("X").calc();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testThrow15(){
        ExpressionParser.parse("").calc();
    }

}
