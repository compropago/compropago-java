package compropagosdk.Factory.V10;

import compropagosdk.Factory.Abs.CpOrderInfo;
import compropagosdk.Factory.Abs.FeeDetails;
import compropagosdk.Models.Customer;
import compropagosdk.Models.OrderInfo;

/**
 * @author Eduardo Aguilar <eduardo.aguilar@compropago.com>
 */
public class CpOrderInfo10 extends CpOrderInfo {

    public String type;
    public String object;
    public Data data;


    public CpOrderInfo10(){
        this.data = new Data();
    }


    @Override
    public String getId() {
        return data.object.id;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getCreated() {
        return data.object.created_at;
    }

    @Override
    public boolean getPaid() {
        return data.object.paid;
    }

    @Override
    public String getAmount() {
        return data.object.amount;
    }

    @Override
    public String getCurrency() {
        return data.object.currency;
    }

    @Override
    public boolean getRefunded() {
        return data.object.refunded;
    }

    @Override
    public String getFee() {
        return data.object.fee;
    }

    @Override
    public FeeDetails getFeeDetails() {
        return data.object.fee_details;
    }

    @Override
    public OrderInfo getOrderInfo() {
        OrderInfo info = new OrderInfo();

        info.order_id = data.object.payment_details.product_id;
        info.order_price = data.object.payment_details.product_price;
        info.order_name = data.object.payment_details.product_name;
        info.payment_method = data.object.payment_details.object;
        info.store = data.object.payment_details.store;
        info.country = data.object.payment_details.country;
        info.image_url = data.object.payment_details.image_url;
        info.success_url = data.object.payment_details.success_url;

        return info;
    }

    @Override
    public Customer getCustomer() {
        Customer customer = new Customer();

        customer.customer_email = data.object.payment_details.customer_email;
        customer.customer_name = data.object.payment_details.customer_name;
        customer.customer_phone = data.object.payment_details.customer_phone;

        return customer;
    }

    @Override
    public boolean getCaptured() {
        return data.object.captured;
    }

    @Override
    public String getFailureMessage() {
        return data.object.failure_message;
    }

    @Override
    public String getFailureCode() {
        return data.object.failure_code;
    }

    @Override
    public double getAmountRefunded() {
        return data.object.amount_refunded;
    }

    @Override
    public String getDescription() {
        return data.object.description;
    }

    @Override
    public String getDispute() {
        return data.object.dispute;
    }
}
