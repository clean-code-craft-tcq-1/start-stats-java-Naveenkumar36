package statisticker;

/**
 * @author {@literal Jayaram Naveenkumar (jayaram.naveenkumar@in.bosch.com)}
 */
public class LEDAlert implements IAlerter {

    private boolean ledGlows;

    public boolean isLedGlows() {
        return ledGlows;
    }

    @Override
    public void alert() {
        this.ledGlows = true;
    }
}
