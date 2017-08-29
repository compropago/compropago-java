package compropagosdk.factory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import compropagosdk.factory.models.*;
import java.util.Map;

public class Factory {

    public static CpOrderInfo cpOrderInfo(String source) {
        Gson gson = new GsonBuilder().serializeNulls().create();
        return gson.fromJson(source, CpOrderInfo.class);
    }

    public static Customer customer(String source) {
        Gson gson = new GsonBuilder().serializeNulls().create();
        return gson.fromJson(source, Customer.class);
    }

    public static EvalAuthInfo evalAuthInfo(String source) {
        Gson gson = new GsonBuilder().serializeNulls().create();
        return gson.fromJson(source, EvalAuthInfo.class);
    }

    public static FeeDetails feeDetails(String source) {
        Gson gson = new GsonBuilder().serializeNulls().create();
        return gson.fromJson(source, FeeDetails.class);
    }

    public static InstructionDetails instructionDetails(String source) {
        Gson gson = new GsonBuilder().serializeNulls().create();
        return gson.fromJson(source, InstructionDetails.class);
    }

    public static Instructions instructions(String source) {
        Gson gson = new GsonBuilder().serializeNulls().create();
        return gson.fromJson(source, Instructions.class);
    }

    public static NewOrderInfo newOrderInfo(String source) {
        Gson gson = new GsonBuilder().serializeNulls().create();
        return gson.fromJson(source, NewOrderInfo.class);
    }

    public static OrderInfo orderInfo(String source) {
        Gson gson = new GsonBuilder().serializeNulls().create();
        return gson.fromJson(source, OrderInfo.class);
    }

    public static PlaceOrderInfo placeOrderInfo(Map<String, String> source) {
        Gson parser = new Gson();
        String json = parser.toJson(source);
        Gson gson = new GsonBuilder().serializeNulls().create();
        return gson.fromJson(json, PlaceOrderInfo.class);
    }

    public static Provider provider(String source) {
        Gson gson = new GsonBuilder().serializeNulls().create();
        return gson.fromJson(source, Provider.class);
    }

    public static Provider[] listProviders(String source) {
        Gson gson = new GsonBuilder().serializeNulls().create();
        return gson.fromJson(source, Provider[].class);
    }

    public static SmsData smsData(String source) {
        Gson gson = new GsonBuilder().serializeNulls().create();
        return gson.fromJson(source, SmsData.class);
    }

    public static SmsInfo smsInfo(String source) {
        Gson gson = new GsonBuilder().serializeNulls().create();
        return gson.fromJson(source, SmsInfo.class);
    }

    public static SmsObject smsObject(String source) {
        Gson gson = new GsonBuilder().serializeNulls().create();
        return gson.fromJson(source, SmsObject.class);
    }

    /**
     * Generates webhook object
     *
     * @param source String
     * @return Webhook
     *
     * @author Eduardo Aguilar (dante.aguilar41@gmail.com)
     */
    public static Webhook webhook(String source) {
        Gson gson = new GsonBuilder().serializeNulls().create();
        return gson.fromJson(source, Webhook.class);
    }

    /**
     * Get webhook list array
     *
     * @param source String
     * @return Webhook[]
     *
     * @author Eduardo Aguilar (dante.aguilar41@gmail.com)
     */
    public static Webhook[] listWebhooks(String source) {
        Gson gson = new GsonBuilder().serializeNulls().create();
        return gson.fromJson(source, Webhook[].class);
    }

    /**
     * Generates Exchange object
     *
     * @param source String
     * @return Exchange
     *
     * @author Eduardo Aguilar (dante.aguilar41@gmail.com)
     */
    public static Exchange exchange(String source) {
        Gson gson = new GsonBuilder().serializeNulls().create();
        return gson.fromJson(source, Exchange.class);
    }
}
