package statisticker;

import java.util.Arrays;
import java.util.List;

/**
 * @author {@literal Jayaram Naveenkumar (jayaram.naveenkumar@in.bosch.com)}
 */
public class StatsChecker {

    private final float maxThreshold;
    private final IAlerter[] iAlerter;

    public StatsChecker(
        float maxThreshold,
        IAlerter[] iAlerter
    )
    {
        this.maxThreshold = maxThreshold;
        this.iAlerter = iAlerter.clone();
    }

    public void checkAndAlert(List<Float> numbers) {
        if (numbers.stream().anyMatch(aFloat -> aFloat > maxThreshold)) {
            Arrays.stream(iAlerter).forEachOrdered(IAlerter::alert);
        }
        //do Nothing
    }
}
