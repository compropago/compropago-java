package compropagosdk.Factory;

import compropagosdk.Factory.Abs.CpOrderInfo;
import compropagosdk.Factory.Abs.NewOrderInfo;
import compropagosdk.Json.SerializeObject;
import compropagosdk.Models.EvalAuthInfo;
import compropagosdk.Models.Provider;
import compropagosdk.Models.Webhook;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;

/**
 * @author Eduardo Aguilar <eduardo.aguilar@compropago.com>
 */
public class Factory {
    
    /**
     * Verify the version of source json object to convert
     * @param source
     * @return
     * @throws ParseException 
     */
    public static boolean verifyVersion(String source) throws ParseException{
        JSONParser parse = new JSONParser();
        JSONObject obj = (JSONObject) parse.parse(source);
        
        return obj.get("api_version") == null;
    }
    

    /**
     * Convert a String json object to an a ComproPago EvalAuthInfo object
     * @param source
     * @return
     * @throws ParseException 
     */
    public static EvalAuthInfo evalAuthInfo(String source) throws ParseException{
        JSONParser parse = new JSONParser();
        JSONObject obj = (JSONObject) parse.parse(source);

        EvalAuthInfo info = new EvalAuthInfo();

        info.type = (String) obj.get("type");
        info.livemode = (boolean) obj.get("livemode");
        info.mode_key = (boolean) obj.get("mode_key");
        info.message = (String) obj.get("message");
        info.code = (long) obj.get("code");

        return info;
    }

    
    /**
     * Convert a String json object to an a ArrayList of Provider objects
     * @param source
     * @return
     * @throws ParseException 
     */
    public static ArrayList<Provider> listProviders(String source) throws ParseException {
        JSONParser parse = new JSONParser();
        JSONArray obj = (JSONArray) parse.parse(source);

        ArrayList<Provider> list = new ArrayList<>();

        for (int x = 0; x < obj.size(); x++) {
            Provider prov = new Provider();
            JSONObject aux = (JSONObject) obj.get(x);

            prov.name = (String) aux.get("name");
            prov.store_image = (String) aux.get("store_image");
            prov.is_active = (boolean) aux.get("is_active");
            prov.internal_name = (String) aux.get("internal_name");
            prov.image_small = (String) aux.get("image_small");
            prov.image_medium = (String) aux.get("image_medium");
            prov.image_large = (String) aux.get("image_large");
            
            Object l = aux.get("transaction_limit");
            prov.transaction_limit = Double.parseDouble(l.toString());
            
            prov.rank = (long) aux.get("rank");

            list.add(prov);
        }

        return list;
    }
    
    
    /**
     * Convert a String json object to an a ComproPago NewOrderInfo object
     * @param source
     * @return
     * @throws ParseException 
     */
    public static NewOrderInfo newOrderInfo(String source) throws ParseException{
        
        NewOrderInfo obj;
        
        if(Factory.verifyVersion(source)){
            obj = SerializeObject.newOrderInfo10(source);
        }else{
            obj = SerializeObject.neworderInfo11(source);
        }
        
        return obj;
    }
    
    
    /**
     * Convert a String json object to an a ComproPago CpOrderInfo object
     * @param source
     * @return
     * @throws ParseException 
     */
    public static CpOrderInfo cpOrderInfo(String source) throws ParseException{
        
        CpOrderInfo obj;
        
        if(Factory.verifyVersion(source)){
            obj = SerializeObject.cpOrderInfo10(source);
        }else{
            obj = SerializeObject.cpOrderInfo11(source);
        }
        
        return obj;
    }
    
    
    /**
     * @param source
     * @return
     * @throws ParseException 
     */
    public static Webhook webhook(String source) throws ParseException{
        Webhook web = new Webhook();
        
        JSONParser parse = new JSONParser();
        JSONObject obj = (JSONObject) parse.parse(source);
        
        web.id = (String) obj.get("id");
        web.url = obj.get("url") == null ? null : (String) obj.get("url");
        web.mode = obj.get("mode") == null ? null : (String) obj.get("mode");
        web.status = obj.get("status") == null ? null : (String) obj.get("status");
        
        return web;
    }
    
    
    /**
     * @param source
     * @return
     * @throws ParseException 
     */
    public static ArrayList<Webhook> listWebhooks(String source) throws ParseException{
        ArrayList<Webhook> list = new ArrayList<>();
        
        JSONParser parse = new JSONParser();
        JSONArray obj = (JSONArray) parse.parse(source);
        
        for(int x = 0; x < obj.size(); x++){
            Webhook web = new Webhook();
            JSONObject aux = (JSONObject) obj.get(x);
            
            web.id = (String) aux.get("id");
            web.url = aux.get("url") == null ? null : (String) aux.get("url");
            web.mode = aux.get("mode") == null ? null : (String) aux.get("mode");
            web.status = aux.get("status") == null ? null : (String) aux.get("status");
            
            list.add(web);
        }
        
        return list;
    }
}
