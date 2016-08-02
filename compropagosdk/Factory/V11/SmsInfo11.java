package compropagosdk.Factory.V11;

import compropagosdk.Factory.Abs.SmsInfo;

/**
 * @author Eduardo Aguilar <eduardo.aguilar@compropago.com>
 */
public class SmsInfo11 extends SmsInfo {

    public String type;
    public String object;
    public SmsData data;

    public SmsInfo11(){
        data = new SmsData();
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getObject() {
        return data.object.object;
    }

    @Override
    public String getId() {
        return data.object.id;
    }

    @Override
    public String getShortId() {
        return data.object.short_id;
    }
}
