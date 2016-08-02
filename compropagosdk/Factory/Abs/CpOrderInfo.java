package compropagosdk.Factory.Abs;

import compropagosdk.Models.Customer;
import compropagosdk.Models.OrderInfo;

/**
 * @author Eduardo Aguilar <eduardo.aguilar@compropago.com>
 */
public abstract class CpOrderInfo {

    public abstract String getId();
    public abstract String getType();
    public abstract String getCreated();
    public abstract boolean getPaid();
    public abstract String getAmount();
    public abstract String getCurrency();
    public abstract boolean getRefunded();
    public abstract String getFee();
    public abstract FeeDetails getFeeDetails();
    public abstract OrderInfo getOrderInfo();
    public abstract Customer getCustomer();
    public abstract boolean getCaptured();
    public abstract String getFailureMessage();
    public abstract String getFailureCode();
    public abstract double getAmountRefunded();
    public abstract String getDescription();
    public abstract String getDispute();

}
