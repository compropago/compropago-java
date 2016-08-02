package compropagosdk.Models;

/**
 * @author Eduardo Aguilar <eduardo.aguilar@compropago.com>
 */
public class PlaceOrderInfo {

    public String order_id;
    public String order_name;
    public double order_price;
    public String customer_name;
    public String customer_email;
    public String payment_type;
    public String image_url;
    public String app_client_name;
    public String app_client_version;

    private static String DEFAULT_CLIENT_VERSION = "1.0.0";

    public PlaceOrderInfo(
        String order_id,
        String order_name,
        double  order_price,
        String customer_name,
        String customer_email,
        String payment_type,
        String image_url,
        String app_client_name,
        String app_client_version
    ){
        this.order_id = order_id;
        this.order_name = order_name;
        this.order_price = order_price;
        this.customer_name = customer_name;
        this.customer_email = customer_email;
        this.payment_type = payment_type;
        this.image_url = image_url;
        this.app_client_name = app_client_name;
        this.app_client_version = app_client_version;
    }


    public PlaceOrderInfo(
        String order_id,
        String order_name,
        double  order_price,
        String customer_name,
        String customer_email,
        String payment_type,
        String image_url,
        String app_client_name
    ){
        this.order_id = order_id;
        this.order_name = order_name;
        this.order_price = order_price;
        this.customer_name = customer_name;
        this.customer_email = customer_email;
        this.payment_type = payment_type;
        this.image_url = image_url;
        this.app_client_name = app_client_name;
        this.app_client_version = DEFAULT_CLIENT_VERSION;
    }



    public PlaceOrderInfo(
        String order_id,
        String order_name,
        double  order_price,
        String customer_name,
        String customer_email,
        String payment_type,
        String image_url
    ){
        this.order_id = order_id;
        this.order_name = order_name;
        this.order_price = order_price;
        this.customer_name = customer_name;
        this.customer_email = customer_email;
        this.payment_type = payment_type;
        this.image_url = image_url;
        this.app_client_name = "javasdk";
        this.app_client_version = DEFAULT_CLIENT_VERSION;
    }


    public PlaceOrderInfo(
        String order_id,
        String order_name,
        double  order_price,
        String customer_name,
        String customer_email,
        String payment_type
    ){
        this.order_id = order_id;
        this.order_name = order_name;
        this.order_price = order_price;
        this.customer_name = customer_name;
        this.customer_email = customer_email;
        this.payment_type = payment_type;
        this.image_url = null;
        this.app_client_name = "javasdk";
        this.app_client_version = DEFAULT_CLIENT_VERSION;
    }


    public PlaceOrderInfo(
        String order_id,
        String order_name,
        double  order_price,
        String customer_name,
        String customer_email
    ){
        this.order_id = order_id;
        this.order_name = order_name;
        this.order_price = order_price;
        this.customer_name = customer_name;
        this.customer_email = customer_email;
        this.payment_type = "OXXO";
        this.image_url = null;
        this.app_client_name = "javasdk";
        this.app_client_version = DEFAULT_CLIENT_VERSION;
    }

}
