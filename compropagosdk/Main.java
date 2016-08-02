package compropagosdk;

import compropagosdk.Client;
import compropagosdk.Factory.Abs.NewOrderInfo;
import compropagosdk.Models.EvalAuthInfo;
import compropagosdk.Models.PlaceOrderInfo;
import compropagosdk.Models.Provider;
import compropagosdk.Tools.Validations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Eduardo Aguilar <eduardo.aguilar@compropago.com>
 */



public class Main {

    public static void main (String args[]){
        try{

            Client client = new Client(
                    "pk_test_5989d8209974e2d62",
                    "sk_test_6ff4e982253c44c42",
                    false
            );

            PlaceOrderInfo order = new PlaceOrderInfo(
                "12", 
                "Prueba Java", 
                123.45, 
                "Eduardo Aguilar", 
                "eduardo.aguilar@compropago.com"
            );
            
            NewOrderInfo info = client.api.placeOrder(order);
            
            System.out.println(">> Orden creada: "+info.getId());

        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
