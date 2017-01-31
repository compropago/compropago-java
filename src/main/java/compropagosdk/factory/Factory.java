package compropagosdk.factory;

import com.google.gson.Gson;
import compropagosdk.factory.models.*;
import java.util.Map;

public class Factory {

    public static CpOrderInfo cpOrderInfo(String source) {
        return new Gson().fromJson(source, CpOrderInfo.class);
    }

    public static Customer customer(String source) {
        return new Gson().fromJson(source, Customer.class);
    }

    public static EvalAuthInfo evalAuthInfo(String source) {
        return new Gson().fromJson(source, EvalAuthInfo.class);
    }

    public static FeeDetails feeDetails(String source) {
        return new Gson().fromJson(source, FeeDetails.class);
    }

    public static InstructionDetails instructionDetails(String source) {
        return new Gson().fromJson(source, InstructionDetails.class);
    }

    public static Instructions instructions(String source) {
        return new Gson().fromJson(source, Instructions.class);
    }

    public static NewOrderInfo newOrderInfo(String source) {
        return new Gson().fromJson(source, NewOrderInfo.class);
    }

    public static OrderInfo orderInfo(String source) {
        return new Gson().fromJson(source, OrderInfo.class);
    }

    public static PlaceOrderInfo placeOrderInfo(Map<String, String> source) {
        Gson parser = new Gson();
        String json = parser.toJson(source);
        return parser.fromJson(json, PlaceOrderInfo.class);
    }

    public static Provider provider(String source) {
        return new Gson().fromJson(source, Provider.class);
    }

    public static Provider[] listProviders(String source) {
        return new Gson().fromJson(source, Provider[].class);
    }

    public static SmsData smsData(String source) {
        return new Gson().fromJson(source, SmsData.class);
    }

    public static SmsInfo smsInfo(String source) {
        return new Gson().fromJson(source, SmsInfo.class);
    }

    public static SmsObject smsObject(String source) {
        return new Gson().fromJson(source, SmsObject.class);
    }

    public static Webhook webhook(String source) {
        return new Gson().fromJson(source, Webhook.class);
    }

    public static Webhook[] listWebhooks(String source) {
        return new Gson().fromJson(source, Webhook[].class);
    }
}
