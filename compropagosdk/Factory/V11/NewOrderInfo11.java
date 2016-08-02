package compropagosdk.Factory.V11;

import compropagosdk.Factory.Abs.FeeDetails;
import compropagosdk.Factory.Abs.Instructions;
import compropagosdk.Factory.Abs.NewOrderInfo;
import compropagosdk.Models.OrderInfo;

/**
 * @author Eduardo Aguilar <eduardo.aguilar@compropago.com>
 */
public class NewOrderInfo11 extends NewOrderInfo {

    public String id;
    public String short_id;
    public String object;
    public String status;
    public String created;
    public String exp_date;
    public boolean live_mode;
    public OrderInfo order_info;
    public FeeDetails11 fee_details;
    public Instructions11 instructions;

    public NewOrderInfo11(){
        order_info = new OrderInfo();
        fee_details = new FeeDetails11();
        instructions = new Instructions11();
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getShortId() {
        return short_id;
    }

    @Override
    public String getStatus() {
        return status;
    }

    @Override
    public String getCreated() {
        return created;
    }

    @Override
    public String getExpirationDate() {
        return exp_date;
    }

    @Override
    public OrderInfo getOrderInfo() {
        return order_info;
    }

    @Override
    public FeeDetails getFeeDetails() {
        return fee_details;
    }

    @Override
    public Instructions getInstructions() {
        return instructions;
    }
}
