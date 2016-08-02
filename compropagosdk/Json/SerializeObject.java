/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compropagosdk.Json;

import compropagosdk.Factory.V10.CpOrderInfo10;
import compropagosdk.Factory.V10.NewOrderInfo10;
import compropagosdk.Factory.V10.SmsInfo10;
import compropagosdk.Factory.V11.CpOrderInfo11;
import compropagosdk.Factory.V11.NewOrderInfo11;
import compropagosdk.Factory.V11.SmsInfo11;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Arthur
 */
public class SerializeObject {
    
    
    /***************************************************************************
     * CpOrderInfo 
     **************************************************************************/
    
    
    
    /**
     * @param source
     * @return 
     * @throws org.json.simple.parser.ParseException 
     */
    public static CpOrderInfo11 cpOrderInfo11(String source) throws ParseException{
        CpOrderInfo11 info = new CpOrderInfo11();
        
        JSONParser parse = new JSONParser();
        JSONObject obj = (JSONObject) parse.parse(source);
        
        info.id = (String) obj.get("id");
        info.type = (String) obj.get("type");
        info.object = (String) obj.get("object");
        info.created = (String) obj.get("created");
        info.paid = (boolean) obj.get("paid");
        info.amount = (String) obj.get("amount");
        info.livemode = (boolean) obj.get("livemode");
        info.currency = (String) obj.get("currency");
        info.refunded = (boolean) obj.get("refunded");
        info.fee = (String) obj.get("fee");
        
        JSONObject auxfee = (JSONObject) obj.get("fee_details");
        info.fee_details.amount = (String) auxfee.get("amount");
        info.fee_details.currency = (String) auxfee.get("currency");
        info.fee_details.type = (String) auxfee.get("type");
        info.fee_details.description = (String) auxfee.get("description");
        info.fee_details.application = (String) auxfee.get("application");
        Object amr = auxfee.get("amount_refunded");
        info.fee_details.amount_refunded = Double.parseDouble(amr.toString());
        info.fee_details.tax = (String) auxfee.get("tax");
        
        JSONObject auxorder = (JSONObject) obj.get("order_info");
        info.order_info.order_id = (String) auxorder.get("order_id");
        Object d = auxorder.get("order_price");
        info.order_info.order_price = Double.parseDouble(d.toString());
        info.order_info.order_name = (String) auxorder.get("order_name");
        info.order_info.payment_method = (String) auxorder.get("payment_method");
        info.order_info.store = (String) auxorder.get("store");
        info.order_info.country = (String) auxorder.get("country");
        info.order_info.image_url = (String) auxorder.get("image_url");
        info.order_info.success_url = (String) auxorder.get("success_url");
        
        JSONObject auxcust = (JSONObject) obj.get("customer");
        info.customer.customer_name = (String) auxcust.get("customer_name");
        info.customer.customer_email = (String) auxcust.get("customer_email");
        info.customer.customer_phone = (String) auxcust.get("customer_phone");
        
        info.captured = (boolean) obj.get("captured");
        info.failure_message = (String) obj.get("failure_message");
        info.failure_code = (String) obj.get("failure_code");
        Object l = obj.get("amount_refunded");
        info.amount_refunded = Double.parseDouble(l.toString());
        info.description = (String) obj.get("description");
        info.dispute = (String) obj.get("dispute");
        
        return info;
    }
    
   /**
    * @param source
    * @return
    * @throws org.json.simple.parser.ParseException 
    */
    public static CpOrderInfo10 cpOrderInfo10(String source) throws ParseException{
        CpOrderInfo10 info = new CpOrderInfo10();
        
        JSONParser parse = new JSONParser();
        JSONObject obj = (JSONObject) parse.parse(source);
        
        info.type = (String) obj.get("type");
        info.object = (String) obj.get("object");
        
        JSONObject auxdata = (JSONObject) obj.get("data");
        
        JSONObject auxobject = (JSONObject) auxdata.get("object");
        info.data.object.id = (String) auxobject.get("id");
        info.data.object.object = (String) auxobject.get("object");
        info.data.object.created_at = (String) auxobject.get("created_at");
        info.data.object.paid = (boolean) auxobject.get("paid");
        info.data.object.amount = (String) auxobject.get("amount");
        info.data.object.currency = (String) auxobject.get("currency");
        info.data.object.refunded = (boolean) auxobject.get("refunded");
        info.data.object.fee = (String) auxobject.get("fee");
        
        JSONObject auxfee = (JSONObject) auxobject.get("fee_details");
        info.data.object.fee_details.amount = (String) auxfee.get("amount");
        info.data.object.fee_details.currency = (String) auxfee.get("currency");
        info.data.object.fee_details.type = (String) auxfee.get("type");
        info.data.object.fee_details.description = (String) auxfee.get("description");
        info.data.object.fee_details.application = (String) auxfee.get("application");
        Object amr = auxfee.get("amount_refunded");
        info.data.object.fee_details.amount_refunded = Double.parseDouble(amr.toString());
        
        JSONObject auxpay = (JSONObject) auxobject.get("paymente_details");
        info.data.object.payment_details.object = (String) auxpay.get("object");
        info.data.object.payment_details.store = (String) auxpay.get("store");
        info.data.object.payment_details.country = (String) auxpay.get("country");
        info.data.object.payment_details.product_id = (String) auxpay.get("product_id");
        Object d = auxpay.get("product_price");
        info.data.object.payment_details.product_price = Double.parseDouble(d.toString());
        info.data.object.payment_details.product_name = (String) auxpay.get("object");
        info.data.object.payment_details.image_url = (String) auxpay.get("image_url");
        info.data.object.payment_details.success_url = (String) auxpay.get("success_url");
        info.data.object.payment_details.customer_name = (String) auxpay.get("customer_name");
        info.data.object.payment_details.customer_email = (String) auxpay.get("customer_email");
        info.data.object.payment_details.customer_phone = (String) auxpay.get("customer_phone");
        
        info.data.object.captured = (boolean) auxobject.get("captured");
        info.data.object.failure_message = (String) auxobject.get("failure_message");
        info.data.object.failure_code = (String) auxobject.get("failure_code");
        Object l = auxobject.get("amount_refunded");
        info.data.object.amount_refunded = Double.parseDouble(l.toString());
        info.data.object.description = (String) auxobject.get("description");
        info.data.object.dispute = (String) auxobject.get("dispute");
        
        return info;
    }
    
    
    
    /***************************************************************************
     * NewOrderInfo 
     **************************************************************************/
    
    
    
    /**
     * @param source
     * @return 
     * @throws org.json.simple.parser.ParseException 
     */
    public static NewOrderInfo10 newOrderInfo10(String source) throws ParseException{
        NewOrderInfo10 info = new NewOrderInfo10();
        
        JSONParser parse = new JSONParser();
        JSONObject obj = (JSONObject) parse.parse(source);
        
        info.payment_id = (String) obj.get("payment_id");
        info.short_payment_id = (String) obj.get("short_payment_id");
        info.payment_status = (String) obj.get("payment_status");
        info.creation_date = (String) obj.get("creation_date");
        info.expiration_date = (String) obj.get("expiration_date");
        
        JSONObject auxprod = (JSONObject) obj.get("product_information");
        info.product_information.product_id = (String) auxprod.get("product_id");
        info.product_information.product_name = (String) auxprod.get("product_name");
        Object d = auxprod.get("product_price");
        info.product_information.product_price = Double.parseDouble(d.toString());
        info.product_information.image_url = (String) auxprod.get("image_url");
        
        JSONObject auxpay = (JSONObject) obj.get("payment_instructions");
        info.payment_instructions.description = (String) auxpay.get("description");
        info.payment_instructions.step1 = (String) auxpay.get("step_1");
        info.payment_instructions.step2 = (String) auxpay.get("step_2");
        info.payment_instructions.step3 = (String) auxpay.get("step_3");
        info.payment_instructions.note_extra_comition = (String) auxpay.get("note_extra_comition");
        info.payment_instructions.note_expiration_date = (String) auxpay.get("note_expiration_date");
        info.payment_instructions.note_confirmation = (String) auxpay.get("note_confirmation");
        
        JSONObject auxdet = (JSONObject) auxpay.get("details");
        info.payment_instructions.details.payment_amount = (String) auxdet.get("payment_amount");
        info.payment_instructions.details.payment_store = (String) auxdet.get("payment_store");
        info.payment_instructions.details.bank_account_number = (String) auxdet.get("bank_account_number");
        info.payment_instructions.details.bank_name = (String) auxdet.get("bank_name");
        
        return info;
    }
    
    /**
     * @param source
     * @return
     * @throws org.json.simple.parser.ParseException 
     */
    public static NewOrderInfo11 neworderInfo11(String source) throws ParseException{
        NewOrderInfo11 info = new NewOrderInfo11();
        
        JSONParser parse = new JSONParser();
        JSONObject obj = (JSONObject) parse.parse(source);
        
        info.id = (String) obj.get("id");
        info.short_id = (String) obj.get("short_id");
        info.object = (String) obj.get("object");
        info.status = (String) obj.get("status");
        Object c = obj.get("created");
        info.created = c.toString();
        Object ex = obj.get("exp_date");
        info.exp_date = ex.toString();
        info.live_mode = (boolean) obj.get("live_mode"); 
        
        JSONObject auxorder = (JSONObject) obj.get("order_info");
        info.order_info.order_id = (String) auxorder.get("order_id");
        info.order_info.order_name = (String) auxorder.get("order_name");
        Object d = auxorder.get("order_price");
        info.order_info.order_price = Double.parseDouble(d.toString());
        info.order_info.image_url = (String) auxorder.get("image_url");
        
        JSONObject auxfee = (JSONObject) obj.get("fee_details");
        info.fee_details.amount = (String) auxfee.get("amount");
        info.fee_details.tax = (String) auxfee.get("tax");
        info.fee_details.currency = (String) auxfee.get("currency");
        info.fee_details.type = (String) auxfee.get("type");
        info.fee_details.description = (String) auxfee.get("description");
        Object amr = auxfee.get("amount_refunded");
        info.fee_details.amount_refunded = Double.parseDouble(amr.toString());
        
        JSONObject auxins = (JSONObject) obj.get("instructions");
        info.instructions.description = (String) auxins.get("description");
        info.instructions.step1 = (String) auxins.get("step_1");
        info.instructions.step2 = (String) auxins.get("step_2");
        info.instructions.step3 = (String) auxins.get("step_3");
        info.instructions.note_extra_comition = (String) auxins.get("note_extra_comition");
        info.instructions.note_expiration_date = (String) auxins.get("note_expiration_date");
        info.instructions.note_confirmation = (String) auxins.get("note_confirmation");
        
        JSONObject auxdet = (JSONObject) auxins.get("details");
        Object a = auxdet.get("amount");
        System.out.println(a.toString());
        //info.instructions.details.amount = a.toString();
        //info.instructions.details.store = (String) auxdet.get("store");
        //info.instructions.details.bank_account_number = (String) auxdet.get("bank_account_number");
        //info.instructions.details.bank_name = (String) auxdet.get("bank_name");
        
        return info;
    }
    
    
    
    /***************************************************************************
     * SmsInfo 
     **************************************************************************/
    
    
    /**
     * @param source
     * @return 
     * @throws org.json.simple.parser.ParseException 
     */
    public static SmsInfo10 smsInfo10(String source) throws ParseException{
        SmsInfo10 info = new SmsInfo10();
        
        JSONParser parse = new JSONParser();
        JSONObject obj = (JSONObject) parse.parse(source);
        
        info.type = (String) obj.get("type");
        info.object = (String) obj.get("object");
        
        JSONObject auxpay = (JSONObject) obj.get("payment");
        info.payment.id = (String) auxpay.get("id");
        info.payment.short_id = (String) auxpay.get("short_id");
        
        return null;
    }
    
    /**
     * @param source
     * @return
     * @throws org.json.simple.parser.ParseException  
     */
    public static SmsInfo11 smsInfo11(String source) throws ParseException{
        SmsInfo11 info = new SmsInfo11();
        
        JSONParser parse = new JSONParser();
        JSONObject obj = (JSONObject) parse.parse(source);
        
        info.type = (String) obj.get("type");
        info.object = (String) obj.get("object");
        
        JSONObject auxdata = (JSONObject) obj.get("data");
        
        JSONObject auxobj = (JSONObject) auxdata.get("object");
        info.data.object.id = (String) auxobj.get("id");
        info.data.object.short_id = (String) auxobj.get("short_id");
        
        return info;
    }
    
}
