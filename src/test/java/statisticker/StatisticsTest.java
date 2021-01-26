package statisticker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.*;

public class StatisticsTest {

    @Test
    public void reportsAverageMinMaxx()
    {
        // ARRANGE
        // NOTE: considering non null elements inside the array
        Float[] numbers = {1.5f, 8.9f, 3.2f, 4.5f};
        List<Float> numberList = Arrays.asList(numbers);

        // ACT
        Statistics.Stats s = Statistics.getStatistics(numberList);

        float epsilon = 0.001f;
        // ASSERT
        assertEquals(4.525f, s.getAverage(), epsilon);
        assertEquals(1.5f, s.getMin(), epsilon);
        assertEquals(8.9f, s.getMax(), epsilon);
    }

    @Test
    public void reportsNaNForEmptyInput()
    {
        // ARRANGE
        List<Float> emptyList = new ArrayList<>();
        // ACT
        Statistics.Stats s = Statistics.getStatistics(emptyList);

        //All fields of computedStats (average, max, min) must be
        //Float.NaN (not-a-number), as described in
        //https://www.geeksforgeeks.org/nan-not-number-java/
        //Design the asserts here and implement accordingly.
        // ASSERT
        assertTrue(Float.isNaN(s.getAverage()));
        assertTrue(Float.isNaN(s.getMin()));
        assertTrue(Float.isNaN(s.getMax()));
    }

    @Test
    public void reportsAlertsIfMaxIsMoreThanThreshold()
    {
        // ARRANGE
        EmailAlert emailAlerter = new EmailAlert();
        LEDAlert ledAlerter = new LEDAlert();
        IAlerter[] alerter = {emailAlerter, ledAlerter};
        float maxThreshold = 10.2f;
        StatsChecker checker = new StatsChecker(maxThreshold, alerter);
        Float[] numbers = {11.5f, 6.9f, 7.5f, 6.6f};
        List<Float> numberList = Arrays.asList(numbers);
        // ACT
        checker.checkAndAlert(numberList);
        // ASSERT
        assertTrue(emailAlerter.isEmailSent());
        assertTrue(ledAlerter.isLedGlows());
    }
}
