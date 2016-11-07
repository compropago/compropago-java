/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compropago.sdk;


import compropago.sdk.factory.abs.CpOrderInfo;
import compropago.sdk.factory.abs.NewOrderInfo;
import compropago.sdk.factory.abs.SmsInfo;
import compropago.sdk.models.EvalAuthInfo;
import compropago.sdk.models.PlaceOrderInfo;
import compropago.sdk.models.Provider;
import compropago.sdk.models.Webhook;
import compropago.sdk.tools.Validations;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;



/**
 *
 * @author Arthur
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UnitTest {
    
    private String publickey = "pk_test_638e8b14112423a086";
    private String privatekey = "sk_test_9c95e149614142822f";
    private boolean mode = false;
    
    private String phoneNumber = "5561463627";
    
    @Test
    public void testCreateClient(){
        boolean flag = true;
        try{
            Client client = new Client(publickey, privatekey, mode);
            flag = !(client == null);
            System.out.println("===>> testCreateClient: "+flag);
        }catch(Exception e){
            System.out.println("===>> testCreateClient: " + e.getMessage());
            flag = false;
        }
        assertTrue(flag);
    }
    
    @Test
    public void testEvalAuth(){
        boolean flag = true;
        try{
            Client client = new Client(publickey, privatekey, mode);
            EvalAuthInfo response = Validations.evalAuth(client);
            flag = !(response == null);
            System.out.println("===>> testEvalAuth: "+flag);
        }catch(Exception e){
            System.out.println("===>> testEvalAuth: " + e.getMessage());
            flag = false;
        }
        assertTrue(flag);
    }
    
    @Test
    public void testServiceProviders(){
        boolean flag = true;
        try{
            Client client = new Client(publickey, privatekey, mode);
            ArrayList<Provider> list = client.api.listProviders();
            
            flag = (list.size() > 0);
            System.out.println("===>> testServiceProviders: "+flag);
        }catch(Exception e){
            System.out.println("===>> testServiceProviders: " + e.getMessage());
            flag = false;
        }
        assertTrue(flag);
    }
    
    @Test
    public void testServiceProvidersLimit(){
        boolean flag = true;
        try{
            Client client = new Client(publickey, privatekey, mode);
            ArrayList<Provider> list = client.api.listProviders(false, 15000);
            
            for(Provider provider : list){
                if(provider.transaction_limit < 15000){
                    System.out.println("==> Limit: "+provider.transaction_limit);
                    flag = false;
                    break;
                }
            }
            System.out.println("===>> testServiceProvidersLimit: "+flag);
        }catch(Exception e){
            System.out.println("===>> testServiceProvidersLimit: "+e.getMessage());
            flag = false;
        }
        assertTrue(flag);
    }
    
    @Test
    public void testServiceProvidersAuth(){
        boolean flag = true;
        try{
            Client client = new Client(publickey, privatekey, mode);
            ArrayList<Provider> list = client.api.listProviders(true);
            
            flag = (list.size() > 0);
            System.out.println("===>> testServiceProvidersAuth: "+flag);
        }catch(Exception e){
            System.out.println("===>> testServiceProvidersAuth: "+e.getMessage());
            flag = false;
        }
        assertTrue(flag);
    }
    
    @Test
    public void testServiceProvidersAuthLimit(){
        boolean flag = true;
        try{
            Client client = new Client(publickey, privatekey, mode);
            ArrayList<Provider> list = client.api.listProviders(true, 15000);
            
            for(Provider provider : list){
                if(provider.transaction_limit < 15000){
                    System.out.println("===>> Limit: "+provider.transaction_limit);
                    flag = false;
                    break;
                }
            }
            System.out.println("===>> testServiceProvidersAuthLimit: "+flag);
        }catch(Exception e){
            System.out.println("===>> testServiceProvidersAuthLimit: "+e.getMessage());
            flag = false;
        }
        assertTrue(flag);
    }
    
    @Test
    public void testServiceProvidersAuthFetch(){
        boolean flag = true;
        try{
            Client client = new Client(publickey, privatekey, mode);
            ArrayList<Provider> list = client.api.listProviders(true, 15000, true);
            
            for(Provider provider : list){
                if(provider.transaction_limit < 15000){
                    System.out.println("===>> Limit: "+provider.transaction_limit);
                    flag = false;
                    break;
                }
            }
            System.out.println("===>> testServiceProvidersAuthFetch: "+flag);
        }catch(Exception e){
            System.out.println("===>> testServiceProvidersAuthFetch: "+e.getMessage());
            flag = false;
        }
        assertTrue(flag);
    }
    
    @Test
    public void testServicePlaceOrderDefault(){
        boolean flag = true;
        try{
            Client client = new Client(publickey, privatekey, mode);
            PlaceOrderInfo order = new PlaceOrderInfo(
                    "12",
                    "M4 Java SDK",
                    180,
                    "Eduardo Aguilar",
                    "eduardo.aguilar@compropago.com"
            );
            NewOrderInfo neworder = client.api.placeOrder(order);
            flag = !(neworder.getId() == null);
            System.out.println("===>> testServicePlaceOrderDefault: "+flag);
        }catch(Exception e){
            System.out.println("===>> testServicePlaceOrderDefault: "+e.getMessage());
            flag = false;
        }
        assertTrue(flag);
    }
    
    @Test
    public void testServicePlaceOrderOxxo(){
        boolean flag = true;
        try{
            Client client = new Client(publickey, privatekey, mode);
            PlaceOrderInfo order = new PlaceOrderInfo(
                    "12",
                    "M4 Java SDK",
                    180,
                    "Eduardo Aguilar",
                    "eduardo.aguilar@compropago.com",
                    "OXXO"
            );
            NewOrderInfo neworder = client.api.placeOrder(order);
            flag = !(neworder.getId() == null);
            System.out.println("===>> testServicePlaceOrderOxxo: "+flag);
        }catch(Exception e){
            System.out.println("===>> testServicePlaceOrderOxxo: "+e.getMessage());
            flag = false;
        }
        assertTrue(flag);
    }
    
    @Test
    public void testServicePlaceOrder7Eleven(){
        boolean flag = true;
        try{
            Client client = new Client(publickey, privatekey, mode);
            PlaceOrderInfo order = new PlaceOrderInfo(
                    "12",
                    "M4 Java SDK",
                    180,
                    "Eduardo Aguilar",
                    "eduardo.aguilar@compropago.com",
                    "SEVEN_ELEVEN"
            );
            NewOrderInfo neworder = client.api.placeOrder(order);
            flag = !(neworder.getId() == null);
            System.out.println("===>> testServicePlaceOrder7Eleven: "+flag);
        }catch(Exception e){
            System.out.println("===>> testServicePlaceOrder7Eleven: "+e.getMessage());
            flag = false;
        }
        assertTrue(flag);
    }
    
    @Test
    public void testServicePlaceOrderCoppel(){
        boolean flag = true;
        try{
            Client client = new Client(publickey, privatekey, mode);
            PlaceOrderInfo order = new PlaceOrderInfo(
                    "12",
                    "M4 Java SDK",
                    180,
                    "Eduardo Aguilar",
                    "eduardo.aguilar@compropago.com",
                    "COPPEL"
            );
            NewOrderInfo neworder = client.api.placeOrder(order);
            flag = !(neworder.getId() == null);
            System.out.println("===>> testServicePlaceOrderCoppel: "+flag);
        }catch(Exception e){
            System.out.println("===>> testServicePlaceOrderCoppel: "+e.getMessage());
            flag = false;
        }
        assertTrue(flag);
    }
    
    @Test
    public void testServicePlaceOrderExtra(){
        boolean flag = true;
        try{
            Client client = new Client(publickey, privatekey, mode);
            PlaceOrderInfo order = new PlaceOrderInfo(
                    "12",
                    "M4 Java SDK",
                    180,
                    "Eduardo Aguilar",
                    "eduardo.aguilar@compropago.com",
                    "EXTRA"
            );
            NewOrderInfo neworder = client.api.placeOrder(order);
            flag = !(neworder.getId() == null);
            System.out.println("===>> testServicePlaceOrderExtra: "+flag);
        }catch(Exception e){
            System.out.println("===>> testServicePlaceOrderExtra: "+e.getMessage());
            flag = false;
        }
        assertTrue(flag);
    }
    
    @Test
    public void testServicePlaceOrderFarmaciaEsquivar(){
        boolean flag = true;
        try{
            Client client = new Client(publickey, privatekey, mode);
            PlaceOrderInfo order = new PlaceOrderInfo(
                    "12",
                    "M4 Java SDK",
                    180,
                    "Eduardo Aguilar",
                    "eduardo.aguilar@compropago.com",
                    "FARMACIA_ESQUIVAR"
            );
            NewOrderInfo neworder = client.api.placeOrder(order);
            flag = !(neworder.getId() == null);
            System.out.println("===>> testServicePlaceOrderFarmaciaEsquivar: "+flag);
        }catch(Exception e){
            System.out.println("===>> testServicePlaceOrderFarmaciaEsquivar: "+e.getMessage());
            flag = false;
        }
        assertTrue(flag);
    }
    
    @Test
    public void testServicePlaceOrderElektra(){
        boolean flag = true;
        try{
            Client client = new Client(publickey, privatekey, mode);
            PlaceOrderInfo order = new PlaceOrderInfo(
                    "12",
                    "M4 Java SDK",
                    180,
                    "Eduardo Aguilar",
                    "eduardo.aguilar@compropago.com",
                    "ELEKTRA"
            );
            NewOrderInfo neworder = client.api.placeOrder(order);
            flag = !(neworder.getId() == null);
            System.out.println("===>> testServicePlaceOrderElektra: "+flag);
        }catch(Exception e){
            System.out.println("===>> testServicePlaceOrderElektra: "+e.getMessage());
            flag = false;
        }
        assertTrue(flag);
    }
    
    @Test
    public void testServicePlaceOrderCasaLey(){
        boolean flag = true;
        try{
            Client client = new Client(publickey, privatekey, mode);
            PlaceOrderInfo order = new PlaceOrderInfo(
                    "12",
                    "M4 Java SDK",
                    180,
                    "Eduardo Aguilar",
                    "eduardo.aguilar@compropago.com",
                    "CASA_LEY"
            );
            NewOrderInfo neworder = client.api.placeOrder(order);
            flag = !(neworder.getId() == null);
            System.out.println("===>> testServicePlaceOrderCasaLey: "+flag);
        }catch(Exception e){
            System.out.println("===>> testServicePlaceOrderCasaLey: "+e.getMessage());
            flag = false;
        }
        assertTrue(flag);
    }
    
    @Test
    public void testServicePlaceOrderPitico(){
        boolean flag = true;
        try{
            Client client = new Client(publickey, privatekey, mode);
            PlaceOrderInfo order = new PlaceOrderInfo(
                    "12",
                    "M4 Java SDK",
                    180,
                    "Eduardo Aguilar",
                    "eduardo.aguilar@compropago.com",
                    "PITICO"
            );
            NewOrderInfo neworder = client.api.placeOrder(order);
            flag = !(neworder.getId() == null);
            System.out.println("===>> testServicePlaceOrderPitico: "+flag);
        }catch(Exception e){
            System.out.println("===>> testServicePlaceOrderPitico: "+e.getMessage());
            flag = false;
        }
        assertTrue(flag);
    }
    
    @Test
    public void testServicePlaceOrderTelecomm(){
        boolean flag = true;
        try{
            Client client = new Client(publickey, privatekey, mode);
            PlaceOrderInfo order = new PlaceOrderInfo(
                    "12",
                    "M4 Java SDK",
                    180,
                    "Eduardo Aguilar",
                    "eduardo.aguilar@compropago.com",
                    "TELECOMM"
            );
            NewOrderInfo neworder = client.api.placeOrder(order);
            flag = !(neworder.getId() == null);
            System.out.println("===>> testServicePlaceOrderTelecomm: "+flag);
        }catch(Exception e){
            System.out.println("===>> testServicePlaceOrderTelecomm: "+e.getMessage());
            flag = false;
        }
        assertTrue(flag);
    }
    
    @Test
    public void testServicePlaceOrderFarmaciaABC(){
        boolean flag = true;
        try{
            Client client = new Client(publickey, privatekey, mode);
            PlaceOrderInfo order = new PlaceOrderInfo(
                    "12",
                    "M4 Java SDK",
                    180,
                    "Eduardo Aguilar",
                    "eduardo.aguilar@compropago.com",
                    "FARMACIA_ABC"
            );
            NewOrderInfo neworder = client.api.placeOrder(order);
            flag = !(neworder.getId() == null);
            System.out.println("===>> testServicePlaceOrderFarmaciaABC: "+flag);
        }catch(Exception e){
            System.out.println("===>> testServicePlaceOrderFarmaciaABC: "+e.getMessage());
            flag = false;
        }
        assertTrue(flag);
    }
    
    @Test
    public void testServiceVerifyOrder(){
        boolean flag = true;
        try{
            Client client = new Client(publickey, privatekey, mode);
            PlaceOrderInfo order = new PlaceOrderInfo(
                    "12",
                    "M4 Java SDK",
                    180,
                    "Eduardo Aguilar",
                    "eduardo.aguilar@compropago.com"
            );
            NewOrderInfo neworder = client.api.placeOrder(order);
            CpOrderInfo response = client.api.verifyOrder(neworder.getId());
            flag = !(response.getId() == null);
            System.out.println("===>> testServiceVerifyOrder: "+flag);
        }catch(Exception e){
            System.out.println("===>> testServiceVerifyOrder: "+e.getMessage());
            flag = false;
        }
        assertTrue(flag);
    }
    
    @Test
    public void testServiceSms(){
        boolean flag = true;
        try{
            Client client = new Client(publickey, privatekey, mode);
            PlaceOrderInfo order = new PlaceOrderInfo(
                    "12",
                    "M4 Java SDK",
                    180,
                    "Eduardo Aguilar",
                    "eduardo.aguilar@compropago.com"
            );
            NewOrderInfo neworder = client.api.placeOrder(order);
            SmsInfo response = client.api.sendSmsInstructions(phoneNumber, neworder.getId());
            flag = !(response.getType() == null);
            System.out.println("===>> testServiceSms: "+flag);
        }catch(Exception e){
            System.out.println("===>> testServiceSms: "+e.getMessage());
            flag = false;
        }
        assertTrue(flag);
    }
    
    @Test 
    public void testServiceListWebhooks(){
        boolean flag = true;
        try{
            Client client = new Client(publickey, privatekey, mode);
            ArrayList<Webhook> response = client.api.listWebhooks();
            flag = response.size() > 0;
            System.out.println("===>> testServiceListWebhooks: "+flag); 
        }catch(Exception e){
            System.out.println("===>> testServiceListWebhooks: "+ e.getMessage()); 
            flag = false;
        }
        assertTrue(flag);
    }
    
    @Test
    public void testServiceCreateWebhook(){
        boolean flag = true;
        try{
            Client client = new Client(publickey, privatekey, mode);
            Webhook response = client.api.createWebhook("http://prueba.com");
            flag = (response.status.equals("new") || response.status.equals("exist"));
            System.out.println("===>> testServiceCreateWebhook: "+flag); 
        }catch(Exception e){
            System.out.println("===>> testServiceCreateWebhook: "+ e.getMessage());
            flag = false;
        }
        assertTrue(flag);
    }
    
    @Test
    public void testServiceUpdateWebhook(){
        boolean flag = true;
        try{
            Client client = new Client(publickey, privatekey, mode);
            Webhook response = client.api.createWebhook("http://prueba.com");
            response = client.api.updateWebhook(response.id, "prueba2.com");
            
            flag = response.status.equals("updated");
            System.out.println("===>> testServiceUpdateWebhook: "+flag); 
        }catch(Exception e){
            System.out.println("===>> testServiceUpdateWebhook: "+ e.getMessage());
            flag = false;
        }
        assertTrue(flag);
    }
    
    @Test
    public void testServiceDeleteWebhook(){
        boolean flag = true;
        try{
            Client client = new Client(publickey, privatekey, mode);
            Webhook response = client.api.createWebhook("prueba2.com");
            response = client.api.deleteWebhook(response.id);
            
            flag = response.status.equals("deleted");
            System.out.println("===>> testServiceDeleteWebhook: "+flag); 
        }catch(Exception e){
            System.out.println("===>> testServiceDeleteWebhook: "+ e.getMessage());
            flag = false;
        }
        assertTrue(flag);
    }
}
