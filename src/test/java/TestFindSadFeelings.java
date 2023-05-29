import org.example.beHappy.BeHappy;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestFindSadFeelings {

    @Test
    public void TestCase1() throws Exception {
        int i = 0;
        List<Integer> feelings = Arrays.asList(-1, 1, 0);
        assertEquals(0, BeHappy.findSadFeeling(i, feelings));
    }

    @Test
    public void TestCase2() {
        int i = -1;
        List<Integer> feelings = Arrays.asList(-1, 1, 0);
        try {
            BeHappy.findSadFeeling(i, feelings);
        } catch (Exception e) {
            assertTrue(e.getMessage().contains("Invalid parameter"));
        }
    }

    @Test
    public void TestCase3() {
        int i = 10;
        List<Integer> feelings = Arrays.asList(-1, 1, 0);
        try {
            BeHappy.findSadFeeling(i, feelings);
        } catch (Exception e) {
            assertTrue(e.getMessage().contains("Invalid parameter"));
        }
    }

    @Test
    public void TestCase4() {
        int i = 0;
        List<Integer> feelings = Arrays.asList(7, -1, 1);
        try {
            BeHappy.findSadFeeling(i, feelings);
        } catch (Exception e) {
            assertTrue(e.getMessage().contains("Invalid parameter"));
        }
    }

    @Test
    public void TestCaseBVA5() throws Exception {
        int i = 1;
        List<Integer> feelings = Arrays.asList(1, -1, 0);
        assertEquals(1, BeHappy.findSadFeeling(i, feelings));
    }

    @Test
    public void TestCaseBVA6() throws Exception {
        int i = 2;
        List<Integer> feelings = Arrays.asList(1, -1, 0);
        try {
            BeHappy.findSadFeeling(i, feelings);
        } catch (Exception e) {
            assertTrue(e.getMessage().contains("Invalid parameter"));
        }
    }
}
