package compropagosdk.factory.models;


public class NewOrderInfo {

    public String id;
    public String short_id;
    public String Object;
    public String status;
    public String created;
    public String exp_date;
    public boolean live_mode;
    public OrderInfo order_info;
    public FeeDetails fee_details;
    public Instructions instructions;

    public NewOrderInfo() {
        order_info = new OrderInfo();
        fee_details = new FeeDetails();
        instructions = new Instructions();
    }

}
