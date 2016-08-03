package compropagosdk.Factory;

import com.google.gson.Gson;

import compropagosdk.Factory.Abs.CpOrderInfo;
import compropagosdk.Factory.Abs.NewOrderInfo;
import compropagosdk.Factory.Abs.SmsInfo;
import compropagosdk.Factory.V10.CpOrderInfo10;
import compropagosdk.Factory.V10.NewOrderInfo10;
import compropagosdk.Factory.V10.SmsInfo10;
import compropagosdk.Factory.V11.CpOrderInfo11;
import compropagosdk.Factory.V11.NewOrderInfo11;
import compropagosdk.Factory.V11.SmsInfo11;
import compropagosdk.Models.EvalAuthInfo;
import compropagosdk.Models.Provider;
import compropagosdk.Models.VerifierObject;
import compropagosdk.Models.VerifierSmsObject;
import compropagosdk.Models.Webhook;


import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Eduardo Aguilar <eduardo.aguilar@compropago.com>
 */
public class Factory {
    
    /**
     * Verify the version of source json object to convert
     * @param source
     * @return
     */
    public static boolean verifyVersion(String source){
        Gson parse = new Gson();
        VerifierObject res = parse.fromJson(source, VerifierObject.class);
        return res.api_version.equals("1.1");
    }
    

    /**
     * Convert a String json object to an a ComproPago EvalAuthInfo object
     * @param source
     * @return
     */
    public static EvalAuthInfo evalAuthInfo(String source){
        EvalAuthInfo info = new Gson().fromJson(source, EvalAuthInfo.class);
        return info;
    }

    
    /**
     * Convert a String json object to an a ArrayList of Provider objects
     * @param source
     * @return
     */
    public static ArrayList<Provider> listProviders(String source){
        Provider[] array = new Gson().fromJson(source, Provider[].class);

        ArrayList<Provider> list = new ArrayList<>();
        list.addAll(Arrays.asList(array));

        return list;
    }
    
    
    /**
     * Convert a String json object to an a ComproPago NewOrderInfo object
     * @param source
     * @return
     */
    public static NewOrderInfo newOrderInfo(String source){
        
        NewOrderInfo obj;
        
        if(Factory.verifyVersion(source)){
            obj = new Gson().fromJson(source, NewOrderInfo11.class);
        }else{
            obj = new Gson().fromJson(source, NewOrderInfo10.class);
        }
        
        return obj;
    }
    
    
    /**
     * Convert a String json object to an a ComproPago CpOrderInfo object
     * @param source
     * @return
     */
    public static CpOrderInfo cpOrderInfo(String source){
        
        CpOrderInfo obj;
        
        if(Factory.verifyVersion(source)){
            obj = new Gson().fromJson(source, CpOrderInfo11.class);
        }else{
            obj = new Gson().fromJson(source, CpOrderInfo10.class);
        }
        
        return obj;
    }
    
    
    /**
     * @param source
     * @return
     */
    public static Webhook webhook(String source){
        Webhook web = new Gson().fromJson(source, Webhook.class);
        return web;
    }
    
    
    /**
     * @param source
     * @return
     */
    public static ArrayList<Webhook> listWebhooks(String source){
        Webhook[] array = new Gson().fromJson(source, Webhook[].class);
        
        ArrayList<Webhook> list = new ArrayList<>();
        list.addAll(Arrays.asList(array));
        
        return list;
    }
    
    
    public static SmsInfo smsInfo(String source){
        SmsInfo obj;
        
        VerifierSmsObject aux = new Gson().fromJson(source, VerifierSmsObject.class);
        
        if(aux.payment != null){
            obj = new Gson().fromJson(source, SmsInfo10.class);
        }else{
            obj = new Gson().fromJson(source, SmsInfo11.class);
        }
        
        return obj;
    }
}
