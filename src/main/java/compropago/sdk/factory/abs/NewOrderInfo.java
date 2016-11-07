package compropago.sdk.factory.abs;

import compropago.sdk.models.OrderInfo;
import compropago.sdk.models.Instructions;

/**
 * @author Eduardo Aguilar <eduardo.aguilar@compropago.com>
 */
public abstract class NewOrderInfo {

    public abstract String getId();
    public abstract String getShortId();
    public abstract String getStatus();
    public abstract String getCreated();
    public abstract String getExpirationDate();
    public abstract OrderInfo getOrderInfo();
    public abstract FeeDetails getFeeDetails();
    public abstract Instructions getInstructions();

}
