package compropago.sdk.factory.v10;

import compropago.sdk.factory.abs.SmsInfo;

/**
 * @author Eduardo Aguilar <eduardo.aguilar@compropago.com>
 */
public class SmsInfo10 extends SmsInfo{

    public String type;
    public String object;
    public SmsPayment payment;

    public SmsInfo10(){
        payment = new SmsPayment();
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getObject() {
        return object;
    }

    @Override
    public String getId() {
        return payment.id;
    }

    @Override
    public String getShortId() {
        return payment.short_id;
    }
}
