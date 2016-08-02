package compropagosdk.Factory.Abs;

/**
 * @author Eduardo Aguilar <eduardo.aguilar@compropago.com>
 */
public abstract class FeeDetails {

    public abstract String getAmount();
    public abstract String getCurrency();
    public abstract String getType();
    public abstract String getDescription();
    public abstract String getApplication();
    public abstract double getAmountRefunded();
    public abstract String getTax();

}
