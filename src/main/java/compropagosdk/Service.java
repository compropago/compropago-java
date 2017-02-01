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

    private Map<String, String> getAuth() {
        Map<String, String> auth = new HashMap<String, String>();
        auth.put("user", this.client.getUser());
        auth.put("pass", this.client.getPass());

        return auth;
    }

    public Provider[] listProviders(double limit, String currency) throws Exception {
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

    public Provider[] listProviders(double limit) throws Exception {
        String url = this.client.deployUri + "providers/";

        if (limit > 0) {
            url += "?order_total="+limit;
        }

        String response = Request.get(url, getAuth());

        return Factory.listProviders(response);
    }

    public Provider[] listProviders() throws Exception {
        String response = Request.get(this.client.deployUri + "providers/", getAuth());
        return Factory.listProviders(response);
    }

    public NewOrderInfo placeOrder(PlaceOrderInfo order) throws Exception {
        Map<String, String> data = new HashMap<String, String>();
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

    public CpOrderInfo verifyOrder(String orderId) throws Exception {
       String response = Request.get(this.client.deployUri+"charges/"+orderId+"/", getAuth());
       return Factory.cpOrderInfo(response);
    }

    public SmsInfo sendSmsInstructions(String number, String orderId) throws Exception {
        Map<String,String> data = new HashMap<String, String>();
        data.put("customer_phone", number);

        String response = Request.post(this.client.deployUri+"charges/"+orderId+"/sms/", data, getAuth());

        return Factory.smsInfo(response);
    }

    public Webhook createWebhook(String url) throws Exception {
        Map<String,String> data = new HashMap<String, String>();
        data.put("url", url);

        String response = Request.post(this.client.deployUri+"webhooks/stores/", data, getAuth());

        return Factory.webhook(response);
    }

    public Webhook updateWebhook(String webhookId, String newUrl) throws Exception {
        Map<String,String> data = new HashMap<String, String>();
        data.put("url", newUrl);

        String response = Request.put(this.client.deployUri+"webhooks/stores/"+webhookId+"/", data, getAuth());

        return Factory.webhook(response);
    }

    public Webhook deleteWebhook(String webhookId) throws Exception {
        String response = Request.delete(this.client.deployUri+"webhooks/stores/"+webhookId+"/", null, getAuth());
        return Factory.webhook(response);
    }

    public Webhook[] listWebhooks() throws Exception {
        String response = Request.get(this.client.deployUri+"webhooks/stores/", getAuth());
        return Factory.listWebhooks(response);
    }

}
