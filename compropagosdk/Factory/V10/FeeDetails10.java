package compropagosdk.Factory.V10;

import compropagosdk.Factory.Abs.FeeDetails;

/**
 * @author Eduardo Aguilar <eduardo.aguilar@compropago.com>
 */
public class FeeDetails10 extends FeeDetails {

    public String amount;
    public String currency;
    public String type;
    public String description;
    public String application;
    public double amount_refunded;

    @Override
    public String getAmount() {
        return amount;
    }

    @Override
    public String getCurrency() {
        return currency;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getApplication() {
        return application;
    }

    @Override
    public double getAmountRefunded() {
        return amount_refunded;
    }

    @Override
    public String getTax() {
        return null;
    }
}
