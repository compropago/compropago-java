package compropagosdk;

import compropagosdk.Factory.Abs.CpOrderInfo;
import compropagosdk.Factory.Abs.NewOrderInfo;
import compropagosdk.Factory.Factory;
import compropagosdk.Models.PlaceOrderInfo;
import compropagosdk.Models.Provider;
import compropagosdk.Tools.Validations;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class Service {

    private final Client client;
    private final Map<String, String> headers = new HashMap<>();

    public Service(Client client){
        this.client = client;
        headers.put("useragent", client.getContained());
    }

    /**
     * 
     * @param auth
     * @param limit
     * @param fetch
     * @return
     * @throws Exception 
     */
    public ArrayList<Provider> listProviders(boolean auth, float limit, boolean fetch) throws Exception {
        if(auth){
            Validations.validateGateway(this.client);
        }

        String uri = auth ? this.client.getUri() + "providers" : this.client.getUri() + "providers/true";

        uri = (limit > 0) ? uri + "?order_total=" + limit : uri;

        uri = fetch ? (
                (limit > 0) ? uri + "&fetch=true" : uri + "?fetch=true"
                ) : uri;


        URL finalUri = new URL(uri);
        HttpURLConnection con = (HttpURLConnection) finalUri.openConnection();

        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

        if(auth){
            Base64.Encoder encoder = Base64.getEncoder();
            String authToken = encoder.encodeToString(client.getFullAuth().getBytes(StandardCharsets.UTF_8));

            con.setRequestProperty("Authorization", "Basic " + authToken);
        }

        for (String key : this.headers.keySet()) {
            con.setRequestProperty(key, this.headers.get(key));
        }

        con.setUseCaches(false);
        con.setDoOutput(true);

        InputStream is = con.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));

        StringBuilder res = new StringBuilder();
        String line;
        while((line = reader.readLine()) != null){
            res.append(line);
            res.append('\r');
        }

        reader.close();

        return Factory.listProviders(res.toString());
    }
    
    /**
     * 
     * @param auth 
     * @param limit
     * @return
     * @throws Exception 
     */
    public ArrayList<Provider> listProviders(boolean auth, float limit) throws Exception {
        if(auth){
            Validations.validateGateway(this.client);
        }

        String uri = auth ? this.client.getUri() + "providers" : this.client.getUri() + "providers/true";

        uri = (limit > 0) ? uri + "?order_total=" + limit : uri;

        URL finalUri = new URL(uri);
        HttpURLConnection con = (HttpURLConnection) finalUri.openConnection();

        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

        if(auth){
            Base64.Encoder encoder = Base64.getEncoder();
            String authToken = encoder.encodeToString(client.getFullAuth().getBytes(StandardCharsets.UTF_8));

            con.setRequestProperty("Authorization", "Basic " + authToken);
        }

        for (String key : this.headers.keySet()) {
            con.setRequestProperty(key, this.headers.get(key));
        }

        con.setUseCaches(false);
        con.setDoOutput(true);

        InputStream is = con.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));

        StringBuilder res = new StringBuilder();
        String line;
        while((line = reader.readLine()) != null){
            res.append(line);
            res.append('\r');
        }

        reader.close();

        return Factory.listProviders(res.toString());
    }
    
    /**
     * 
     * @param auth
     * @return
     * @throws Exception 
     */
    public ArrayList<Provider> listProviders(boolean auth) throws Exception {
        if(auth){
            Validations.validateGateway(this.client);
        }

        String uri = auth ? this.client.getUri() + "providers" : this.client.getUri() + "providers/true";

        URL finalUri = new URL(uri);
        HttpURLConnection con = (HttpURLConnection) finalUri.openConnection();

        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

        if(auth){
            Base64.Encoder encoder = Base64.getEncoder();
            String authToken = encoder.encodeToString(client.getFullAuth().getBytes(StandardCharsets.UTF_8));

            con.setRequestProperty("Authorization", "Basic " + authToken);
        }

        for (String key : this.headers.keySet()) {
            con.setRequestProperty(key, this.headers.get(key));
        }

        con.setUseCaches(false);
        con.setDoOutput(true);

        InputStream is = con.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));

        StringBuilder res = new StringBuilder();
        String line;
        while((line = reader.readLine()) != null){
            res.append(line);
            res.append('\r');
        }

        reader.close();

        return Factory.listProviders(res.toString());
    }
    
    /**
    * 
    * @return
    * @throws Exception 
    */
    public ArrayList<Provider> listProviders() throws Exception {
        String uri = this.client.getUri() + "providers/true";

        URL finalUri = new URL(uri);
        HttpURLConnection con = (HttpURLConnection) finalUri.openConnection();

        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

        for (String key : this.headers.keySet()) {
            con.setRequestProperty(key, this.headers.get(key));
        }

        con.setUseCaches(false);
        con.setDoOutput(true);

        InputStream is = con.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));

        StringBuilder res = new StringBuilder();
        String line;
        while((line = reader.readLine()) != null){
            res.append(line);
            res.append('\r');
        }

        reader.close();

        return Factory.listProviders(res.toString());
    }
    
    /**
     * 
     * @param orderId
     * @return
     * @throws Exception 
     */
    public CpOrderInfo verifyOrder(String orderId) throws Exception{
        Validations.validateGateway(client);
        
        String uri = client.getUri() + "charges/" + orderId;
        
        URL finalUri = new URL(uri);
        HttpURLConnection con = (HttpURLConnection) finalUri.openConnection();
        con.setUseCaches(false);
        con.setDoOutput(true);
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

        
        Base64.Encoder encoder = Base64.getEncoder();
        String authToken = encoder.encodeToString(client.getFullAuth().getBytes(StandardCharsets.UTF_8));

        con.setRequestProperty("Authorization", "Basic " + authToken);
        

        for (String key : this.headers.keySet()) {
            con.setRequestProperty(key, this.headers.get(key));
        }

        InputStream is = con.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));

        StringBuilder res = new StringBuilder();
        String line;
        while((line = reader.readLine()) != null){
            res.append(line);
            res.append('\r');
        }

        reader.close();
        
        return Factory.cpOrderInfo(res.toString());
    }
    
    
    /**
     * @param info
     * @return
     * @throws Exception 
     */
    public NewOrderInfo placeOrder(PlaceOrderInfo info) throws Exception{
        Validations.validateGateway(client);
        
        String append = 
            "order_id=" + info.order_id +
            "&order_price=" + info.order_price +
            "&order_name=" + info.order_name +
            "&customer_name=" + info.customer_name +
            "&customer_email=" + info.customer_email +
            "&image_url=" + info.image_url +
            "&payment_type=" + info.payment_type +
            "&app_client_name" + info.app_client_name +
            "&app_client_version" + info.app_client_version ;
        
        String uri = client.getUri() + "charges/";
        
        URL finalUri = new URL(uri);
        HttpURLConnection con = (HttpURLConnection) finalUri.openConnection();
        con.setUseCaches(false);
        con.setDoOutput(true);
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        
        Base64.Encoder encoder = Base64.getEncoder();
        String authToken = encoder.encodeToString(client.getFullAuth().getBytes(StandardCharsets.UTF_8));

        con.setRequestProperty("Authorization", "Basic " + authToken);
        
        OutputStream os = con.getOutputStream();
        os.write(append.getBytes());
        os.flush();
        
        /*if (con.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
            throw new RuntimeException("Failed : HTTP error code : " + con.getResponseCode());
        }*/
        
        InputStream is = con.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));

        StringBuilder res = new StringBuilder();
        String line;
        while((line = reader.readLine()) != null){
            res.append(line);
            res.append('\r');
        }

        reader.close();
        
        System.out.println(res.toString());
        
        return Factory.newOrderInfo(res.toString());
    }

}
