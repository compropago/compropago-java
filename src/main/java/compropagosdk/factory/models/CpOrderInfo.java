package compropagosdk.factory.models;


public class CpOrderInfo {

    public String id;
    public String short_id;
    public String type;
    public String object;
    public boolean livemode;
    public long created_at;
    public long accepted_at;
    public long expires_at;
    public boolean paid;
    public double amount;
    public String currency;
    public boolean refunded;
    public double fee;
    public FeeDetails fee_details;
    public OrderInfo order_info;
    public Customer customer;
    public String api_version;

    public CpOrderInfo() {
        fee_details = new FeeDetails();
        order_info = new OrderInfo();
        customer = new Customer();
    }

}
