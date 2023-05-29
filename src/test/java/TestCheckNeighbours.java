import org.example.beHappy.BeHappy;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class TestCheckNeighbours {
    @Test
    public void TestCase1() throws Exception {
        int i = -1;
        List<Integer> feelings = Arrays.asList(0, 1);
        try {
            BeHappy.checkNeighbours(i, feelings);
        } catch (Exception e) {
            assertTrue(e.getMessage().contains("Invalid parameter"));
        }
    }

    @Test
    public void TestCase2() throws Exception {
        int i = 0;
        List<Integer> feelings = Arrays.asList(1);
        assertTrue(BeHappy.checkNeighbours(i, feelings));
    }

    @Test
    public void TestCase3() throws Exception {
        int i = 0;
        List<Integer> feelings = Arrays.asList(-1,0,-1,0);
        assertFalse(BeHappy.checkNeighbours(i, feelings));
    }

    @Test
    public void TestCase4() throws Exception {
        int i = 2;
        List<Integer> feelings = Arrays.asList(0,1,-1,0);
        assertFalse(BeHappy.checkNeighbours(i, feelings));
    }

    @Test
    public void TestCase5() throws Exception {
        int i = 2;
        List<Integer> feelings = Arrays.asList(0,1,-1,1);
        assertTrue(BeHappy.checkNeighbours(i, feelings));
    }
}
