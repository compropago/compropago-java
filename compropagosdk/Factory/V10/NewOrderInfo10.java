package compropagosdk.Factory.V10;

import compropagosdk.Factory.Abs.FeeDetails;
import compropagosdk.Factory.Abs.Instructions;
import compropagosdk.Factory.Abs.NewOrderInfo;
import compropagosdk.Models.OrderInfo;

/**
 * @author Eduardo Aguilar <eduardo.aguilar@compropago.com>
 */
public class NewOrderInfo10 extends NewOrderInfo {

    public String payment_id;
    public String short_payment_id;
    public String payment_status;
    public String creation_date;
    public String expiration_date;
    public ProductInformation product_information;
    public Instructions10 payment_instructions;


    public NewOrderInfo10(){
        product_information = new ProductInformation();
        payment_instructions = new Instructions10();
    }


    @Override
    public String getId() {
        return payment_id;
    }

    @Override
    public String getShortId() {
        return short_payment_id;
    }

    @Override
    public String getStatus() {
        return payment_status;
    }

    @Override
    public String getCreated() {
        return creation_date;
    }

    @Override
    public String getExpirationDate() {
        return expiration_date;
    }

    @Override
    public OrderInfo getOrderInfo() {
        OrderInfo info = new OrderInfo();

        info.order_id = product_information.product_id;
        info.order_name = product_information.product_name;
        info.order_price = product_information.product_price;
        info.image_url = product_information.image_url;

        return info;
    }

    @Override
    public FeeDetails getFeeDetails() {
        return null;
    }

    @Override
    public Instructions getInstructions() {
        return payment_instructions;
    }
}
