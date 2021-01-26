package statisticker;

/**
 * @author {@literal Jayaram Naveenkumar (jayaram.naveenkumar@in.bosch.com)}
 */
public class EmailAlert implements IAlerter {

    private boolean emailSent;

    public boolean isEmailSent() {
        return emailSent;
    }

    @Override
    public void alert() {
        emailSent = true;
    }
}
