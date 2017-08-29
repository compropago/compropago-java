package compropagosdk;

import compropagosdk.factory.Factory;
import compropagosdk.factory.models.*;
import compropagosdk.tools.Request;

import java.util.HashMap;
import java.util.Map;

public class Service {

    private Client client;

    public Service(Client client) {
        this.client = client;
    }

    /**
     * Get Auth info
     *
     * @return Map
     *
     * @author Eduardo Aguilar (dante.aguilar41@gmail.com)
     */
    private Map<String, String> getAuth() {
        Map<String, String> auth = new HashMap<>();
        auth.put("user", this.client.getUser());
        auth.put("pass", this.client.getPass());

        return auth;
    }

    /**
     * Get list Providers
     *
     * @param limit float
     * @param currency String
     * @return Provider[]
     * @throws Exception Request exception
     *
     * @author Eduardo Aguilar (dante.aguilar41@gmail.com)
     */
    public Provider[] listProviders(float limit, String currency) throws Exception {
        String url = this.client.deployUri + "providers/";

        if (limit > 0) {
            url += "?order_total="+limit;
        }

        if (limit > 0 && currency != null && !currency.equals("MXN")) {
            url += "&currency="+currency;
        }

        String response = Request.get(url, getAuth());

        return Factory.listProviders(response);
    }

    /**
     * Get list Providers
     *
     * @param limit double
     * @return Provider[]
     * @throws Exception Request exception
     *
     * @author Eduardo Aguilar (dante.aguilar41@gmail.com)
     */
    public Provider[] listProviders(double limit) throws Exception {
        String url = this.client.deployUri + "providers/";

        if (limit > 0) {
            url += "?order_total="+limit;
        }

        String response = Request.get(url, getAuth());

        return Factory.listProviders(response);
    }

    /**
     * get list Providers
     *
     * @return Provider[]
     * @throws Exception Request exception
     *
     * @author Eduardo Aguilar (dante.aguilar41@gmail.com)
     */
    public Provider[] listProviders() throws Exception {
        String response = Request.get(this.client.deployUri + "providers/", getAuth());
        return Factory.listProviders(response);
    }

    /**
     * Create new order
     *
     * @param order PlaceOrderInfo
     * @return NewOrderInfo
     * @throws Exception Request exception
     *
     * @author Eduardo Aguilar (dante.aguilar41@gmail.com)
     */
    public NewOrderInfo placeOrder(PlaceOrderInfo order) throws Exception {
        Map<String, String> data = new HashMap<>();
        data.put("order_id", order.order_id);
        data.put("order_name", order.order_name);
        data.put("order_price", String.valueOf(order.order_price));
        data.put("customer_name", order.customer_name);
        data.put("customer_email", order.customer_email);
        data.put("payment_type", order.payment_type);
        data.put("currency", order.currency);
        data.put("expiration_time", order.expiration_time);
        data.put("image_url", order.image_url);
        data.put("app_client_name", order.app_client_name);
        data.put("app_client_version", order.app_client_version);

        String response = Request.post(this.client.deployUri+"charges/", data, getAuth());

        return Factory.newOrderInfo(response);
    }

    /**
     * Verify order information
     *
     * @param orderId String
     * @return CpOrderInfo
     * @throws Exception request exception
     *
     * @author Eduardo Aguilar (dante.aguilar41@gmail.com)
     */
    public CpOrderInfo verifyOrder(String orderId) throws Exception {
       String response = Request.get(this.client.deployUri+"charges/"+orderId+"/", getAuth());
       return Factory.cpOrderInfo(response);
    }

    /**
     * Send sms instructions for an order
     *
     * @param number String
     * @param orderId String
     * @return SmsInfo
     * @throws Exception Request exception
     *
     * @author Eduardo Aguilar (dante.aguilar41@gmail.com)
     */
    public SmsInfo sendSmsInstructions(String number, String orderId) throws Exception {
        Map<String,String> data = new HashMap<>();
        data.put("customer_phone", number);

        String response = Request.post(this.client.deployUri+"charges/"+orderId+"/sms/", data, getAuth());

        return Factory.smsInfo(response);
    }

    /**
     * Create new webhook URL
     *
     * @param url String
     * @return Webhook
     * @throws Exception Request exception
     *
     * @author Eduardo Aguilar (dante.aguilar41@gmail.com)
     */
    public Webhook createWebhook(String url) throws Exception {
        Map<String,String> data = new HashMap<>();
        data.put("url", url);

        String response = Request.post(this.client.deployUri+"webhooks/stores/", data, getAuth());

        return Factory.webhook(response);
    }

    /**
     * Update webhook URL
     *
     * @param webhookId String
     * @param newUrl String
     * @return Webhook
     * @throws Exception Request exception
     *
     * @author Eduardo Aguilar (dante.aguilar41@gmail.com)
     */
    public Webhook updateWebhook(String webhookId, String newUrl) throws Exception {
        Map<String,String> data = new HashMap<>();
        data.put("url", newUrl);

        String response = Request.put(this.client.deployUri+"webhooks/stores/"+webhookId+"/", data, getAuth());

        return Factory.webhook(response);
    }

    /**
     * Update webhook URL
     *
     * @param webhookId String
     * @param newUrl String
     * @param type String
     * @return Webhook
     * @throws Exception Request exception
     *
     * @author Eduardo Aguilar (dante.aguilar41@gmail.com)
     */
    public Webhook updateWebhook(String webhookId, String newUrl, String type) throws Exception {
        Map<String,String> data = new HashMap<>();
        data.put("url", newUrl);
        data.put("webhookType", type);

        String response = Request.put(this.client.deployUri+"webhooks/stores/"+webhookId+"/", data, getAuth());

        return Factory.webhook(response);
    }

    /**
     * Deactive a webhook URL
     *
     * @param webhookId String
     * @return Webhook
     * @throws Exception Request exception
     *
     * @author Eduardo Aguilar (dante.aguilar41@gmail.com)
     */
    public Webhook deactiveWebhook(String webhookId) throws Exception {
        String response = Request.delete(this.client.deployUri+"webhooks/stores/"+webhookId+"/deactive", null, getAuth());
        return Factory.webhook(response);
    }

    /**
     * Delete an URL
     *
     * @param webhookId Sgtring
     * @return Webhook
     * @throws Exception Request exception
     *
     * @author Eduardo Aguilar (dante.aguilar41@gmail.com)
     */
    public Webhook deleteWebhook(String webhookId) throws Exception {
        String response = Request.delete(this.client.deployUri+"webhooks/stores/"+webhookId+"/", null, getAuth());
        return Factory.webhook(response);
    }

    /**
     * Get List of webhooks
     *
     * @return Webhook[]
     * @throws Exception Request exception
     *
     * @author Eduardo Aguilar (dante.aguilar41@gmail.com)
     */
    public Webhook[] listWebhooks() throws Exception {
        String response = Request.get(this.client.deployUri+"webhooks/stores/", getAuth());
        return Factory.listWebhooks(response);
    }

}
