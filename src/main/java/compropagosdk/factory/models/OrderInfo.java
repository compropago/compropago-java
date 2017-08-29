package compropagosdk.factory.models;


public class OrderInfo {

    public String order_id;
    public double order_price;
    public String order_name;
    public String payment_method;
    public String store;
    public String country;
    public String image_url;
    public String success_url;
    public String failure_url;
    public Exchange exchange;

    public OrderInfo(){
        this.exchange = new Exchange();
    }

}
