package compropagosdk;

import compropagosdk.factory.Factory;
import compropagosdk.factory.models.*;
import compropagosdk.tools.Validations;
import junit.framework.Assert;
import junit.framework.TestCase;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class UnitTest extends TestCase {

    protected String publicKey;
    protected String privateKey;
    protected boolean mode;

    protected String number;
    protected Map<String, String> order;
    protected double limit;
    protected String currency;

    protected String webhook1;
    protected String webhook2;

    protected void setUp() {
        this.publicKey = "pk_test_638e8b14112423a086";
        this.privateKey = "sk_test_9c95e149614142822f";
        this.mode = false;
        this.number = "5561463627";
        this.limit = 15000;
        this.currency = "USD";

        this.webhook1 = "https://misitio.com/webhook/";
        this.webhook2 = "https://misitio.com/webhook/dos/";

        this.order = new HashMap<String, String>();
        this.order.put("order_id", "123");
        this.order.put("order_name", "M4 SDK Java");
        this.order.put("order_price", "123.45");
        this.order.put("customer_name", "Eduardo Aguilar");
        this.order.put("customer_email", "eduardo.aguilar@compropago.com");
        this.order.put("payment_type", "OXXO");
    }

    public void testCreateClient() {
        boolean res = false;
        try {
            Client client = new Client(this.publicKey, this.privateKey, this.mode);
            res = client instanceof Client;
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertTrue(res);
    }

    public void testEvalAuth() {
        boolean res = false;
        try {
            Client client = new Client(this.publicKey, this.privateKey, this.mode);

            EvalAuthInfo evl = Validations.evalAuth(client);

            res = (evl instanceof EvalAuthInfo && evl != null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertTrue(res);
    }

    public void testProviders() {
        boolean res = false;
        try {
            Client client = new Client(this.publicKey, this.privateKey, this.mode);

            Provider[] list = client.api.listProviders();

            res = list[0] instanceof Provider;
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertTrue(res);
    }

    public void testProvidersLimit() {
        boolean res = true;
        try {
            Client client = new Client(this.publicKey, this.privateKey, this.mode);

            Provider[] list = client.api.listProviders(this.limit);

            for (int x = 0; x <= list.length; x++) {
                if (list[x].transaction_limit < this.limit) {
                    res = false;
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertTrue(res);
    }

    public void testProvidersCurrency() {
        boolean res = true;
        try {
            Client client = new Client(this.publicKey, this.privateKey, this.mode);

            Provider[] list = client.api.listProviders(700, this.currency);

            for (int x = 0; x <= list.length; x++) {
                if (list[x].transaction_limit < this.limit) {
                    res = false;
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertTrue(res);
    }

    public void testPlaceOrder() {
        boolean res = false;
        try {
            Client client = new Client(this.publicKey, this.privateKey, this.mode);

            PlaceOrderInfo order = Factory.placeOrderInfo(this.order);
            NewOrderInfo newOrder = client.api.placeOrder(order);

            res = !newOrder.id.equals("");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertTrue(res);
    }

    public void testPlaceOrderExpdate() {
        boolean res = false;
        try {
            Client client = new Client(this.publicKey, this.privateKey, this.mode);

            long epoch = Instant.now().toEpochMilli();
            this.order.put("expiration_time", String.valueOf(epoch));

            PlaceOrderInfo order = Factory.placeOrderInfo(this.order);
            NewOrderInfo newOrder = client.api.placeOrder(order);

            res = !newOrder.id.equals("") && newOrder.exp_date.equals(String.valueOf(epoch));
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertTrue(res);
    }

    public void testVerifyOrder() {
        boolean res = false;
        try {
            Client client = new Client(this.publicKey, this.privateKey, this.mode);

            PlaceOrderInfo order = Factory.placeOrderInfo(this.order);
            NewOrderInfo newOrder = client.api.placeOrder(order);

            CpOrderInfo verified = client.api.verifyOrder(newOrder.id);

            res = !verified.id.equals("");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertTrue(res);
    }

    public void testSendSmsInstructions() {
        boolean res = false;
        try {
            Client client = new Client(this.publicKey, this.privateKey, this.mode);

            PlaceOrderInfo order = Factory.placeOrderInfo(this.order);
            NewOrderInfo newOrder = client.api.placeOrder(order);

            SmsInfo sms = client.api.sendSmsInstructions(this.number, newOrder.id);

            res = !sms.type.equals("");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertTrue(res);
    }

    public void testListWebhooks() {
        boolean res = false;
        try {
            Client client = new Client(this.publicKey, this.privateKey, this.mode);

            Webhook[] list = client.api.listWebhooks();

            res = !list[0].id.equals("");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertTrue(res);
    }

    public void testCreateWebhook() {
        boolean res = false;
        try {
            Client client = new Client(this.publicKey, this.privateKey, this.mode);

            Webhook webhook = client.api.createWebhook(this.webhook1);

            res = !webhook.id.equals("");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertTrue(res);
    }

    public void testUpdateWebhook() {
        boolean res = false;
        try {
            Client client = new Client(this.publicKey, this.privateKey, this.mode);

            Webhook webhook = client.api.createWebhook(this.webhook1);
            Webhook updated = client.api.updateWebhook(webhook.id, this.webhook2);

            res = !updated.id.equals("");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertTrue(res);
    }

    public void testDeleteWebhook() {
        boolean res = false;
        try {
            Client client = new Client(this.publicKey, this.privateKey, this.mode);

            Webhook webhook = client.api.createWebhook(this.webhook2);
            Webhook deleted = client.api.deleteWebhook(webhook.id);

            res = !deleted.id.equals("");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertTrue(res);
    }
}
