package compropago.sdk.factory.v10;

/**
 * @author Eduardo Aguilar <eduardo.aguilar@compropago.com>
 */
public class CpObject {

    public String id;
    public String object;
    public String created_at;
    public boolean paid;
    public String amount;
    public String currency;
    public boolean refunded;
    public String fee;
    public FeeDetails10 fee_details;
    public PaymentDetails payment_details;
    public boolean captured;
    public String failure_message;
    public String failure_code;
    public double amount_refunded;
    public String description;
    public String dispute;


    public CpObject(){
        this.fee_details = new FeeDetails10();
        this.payment_details = new PaymentDetails();
    }

}
