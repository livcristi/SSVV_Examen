import org.example.beHappy.BeHappy;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestBeHappy {
    @Test
    public void testBeHappyWithMultipleSadFeelings() throws Exception {
        List<Integer> testList = new ArrayList<>(List.of(-1, -1, -1, -1, -1));
        List<Integer> expectedOutput = new ArrayList<>(List.of(1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1));

        List<Integer> actualOutput = BeHappy.BeHappy(testList);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testBeHappyWithNoSadFeelings() throws Exception {
        List<Integer> testList = new ArrayList<>(List.of(1, 0, 1, 0, 1));
        List<Integer> expectedOutput = new ArrayList<>(List.of(1, 0, 1, 0, 1));

        List<Integer> actualOutput = BeHappy.BeHappy(testList);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testBeHappyWithMixedFeelings() throws Exception {
        List<Integer> testList = new ArrayList<>(List.of(-1, 1, -1, 0, 1, -1, 0, -1, 1));
        List<Integer> expectedOutput = new ArrayList<>(List.of(1, -1, 1, -1, 1, 0, 1, -1, 1, 0, 1, -1, 1));

        List<Integer> actualOutput = BeHappy.BeHappy(testList);

        assertEquals(expectedOutput, actualOutput);
    }
}
