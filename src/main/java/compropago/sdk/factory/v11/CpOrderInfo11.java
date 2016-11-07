package compropago.sdk.factory.v11;

import compropago.sdk.factory.abs.CpOrderInfo;
import compropago.sdk.factory.abs.FeeDetails;
import compropago.sdk.models.Customer;
import compropago.sdk.models.OrderInfo;

/**
 * @author Eduardo Aguilar <eduardo.aguilar@compropago.com>
 */
public class CpOrderInfo11 extends CpOrderInfo{

    public String id;
    public String type;
    public String object;
    public String created;
    public boolean paid;
    public String amount;
    public boolean livemode;
    public String currency;
    public boolean refunded;
    public String fee;
    public FeeDetails11 fee_details;
    public OrderInfo order_info;
    public Customer customer;
    public boolean captured;
    public String failure_message;
    public String failure_code;
    public double amount_refunded;
    public String description;
    public String dispute;


    public CpOrderInfo11(){
        fee_details = new FeeDetails11();
        order_info = new OrderInfo();
        customer = new Customer();
    }


    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getCreated() {
        return created;
    }

    @Override
    public boolean getPaid() {
        return paid;
    }

    @Override
    public String getAmount() {
        return amount;
    }

    @Override
    public String getCurrency() {
        return currency;
    }

    @Override
    public boolean getRefunded() {
        return refunded;
    }

    @Override
    public String getFee() {
        return fee;
    }

    @Override
    public FeeDetails getFeeDetails() {
        return fee_details;
    }

    @Override
    public OrderInfo getOrderInfo() {
        return order_info;
    }

    @Override
    public Customer getCustomer() {
        return customer;
    }

    @Override
    public boolean getCaptured() {
        return captured;
    }

    @Override
    public String getFailureMessage() {
        return failure_message;
    }

    @Override
    public String getFailureCode() {
        return failure_code;
    }

    @Override
    public double getAmountRefunded() {
        return amount_refunded;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getDispute() {
        return dispute;
    }
}
