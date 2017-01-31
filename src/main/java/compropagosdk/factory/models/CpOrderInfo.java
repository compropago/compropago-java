package compropagosdk.factory.models;


public class CpOrderInfo {

    public String id;
    public String type;
    public String object;
    public int created;
    public boolean paid;
    public String amount;
    public boolean livemode;
    public String currency;
    public boolean refunded;
    public String fee;
    public FeeDetails fee_details;
    public OrderInfo order_info;
    public Customer customer;
    public boolean captured;
    public String failure_message;
    public String failure_code;
    public double amount_refunded;
    public String description;
    public String dispute;

    public CpOrderInfo() {
        fee_details = new FeeDetails();
        order_info = new OrderInfo();
        customer = new Customer();
    }

}
