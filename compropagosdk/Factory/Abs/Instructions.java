package compropagosdk.Factory.Abs;

/**
 * @author Eduardo Aguilar <eduardo.aguilar@compropago.com>
 */
public abstract class Instructions {

    public abstract String getDescription();
    public abstract String getStep1();
    public abstract String getStep2();
    public abstract String getStep3();
    public abstract String getNoteExtraComition();
    public abstract String getNoteExpirationDate();
    public abstract String getNoteConfirmation();
    public abstract InstructionDetails getDetails();

}
