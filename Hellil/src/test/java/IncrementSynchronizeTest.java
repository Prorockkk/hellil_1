import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IncrementSynchronizeTest {

    IncrementSynchronize s;
    @Test
    void testGetNextValue1() {
        Runnable r1 = () -> {
            for (int i = 0; i < 1000; i++)
            {
                s.getNextValue1();
            }
            System.out.println("Test1 " + s.getValue());
        };
        Thread tr1 = new Thread(r1);
        tr1.start();
    }

    @Test
    void testGetNextValue2() {
        Runnable r2 = () -> {
            for (int i = 0; i < 1000; i++)
            {
                s.getNextValue2();
            }
            System.out.println("Test2 " + s.getValue());
        };
        Thread tr2 = new Thread(r2);
        tr2.start();
    }

    @Test
    void testGetNextValue3() {
        Runnable r3 = () -> {
            for (int i = 0; i < 1000; i++)
            {
                s.getNextValue3();
            }
            System.out.println("Test3 " + s.getValue());
        };
        Thread tr3 = new Thread(r3);
        tr3.start();
    }
    @After
    public void afterTest() {
        System.out.println("final " + s.getValue());
    }
    @Before
    public void beforeTest() {
        s = new IncrementSynchronize();
    }

    @BeforeEach
    void setUp() {
        s = new IncrementSynchronize();
    }

    @AfterEach
    public void tearDown() {
        s = new IncrementSynchronize();
        Runnable r1 = () -> {
            for (int i = 0; i < 1000; i++)
            {
                s.getNextValue1();
            }
            System.out.println(s.getValue());
        };
        Runnable r2 = () -> {
            for (int i = 0; i < 1000; i++)
            {
                s.getNextValue2();
            }
            System.out.println(s.getValue());
        };
        Runnable r3 = () -> {
            for (int i = 0; i < 1000; i++)
            {
                s.getNextValue3();
            }
            System.out.println(s.getValue());
        };
        Thread tr1 = new Thread(r1);
        tr1.start();
        Thread tr2 = new Thread(r2);
        tr2.start();
        Thread tr3 = new Thread(r3);
        tr3.start();
        try {
            tr1.join();
            tr2.join();
            tr3.join();
            System.out.println(s.getValue());
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}