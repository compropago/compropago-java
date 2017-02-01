package compropagosdk.tools;

import compropagosdk.Client;
import compropagosdk.factory.Factory;
import compropagosdk.factory.models.EvalAuthInfo;

import java.util.HashMap;
import java.util.Map;

public class Validations {

    public static EvalAuthInfo evalAuth(Client client) throws Exception {
        String response;

        if (client.getUser() != null && client.getPass() != null) {
            Map<String, String> auth = new HashMap<String, String>();
            auth.put("user", client.getUser());
            auth.put("pass", client.getPass());

            response = Request.get(
                client.deployUri + "users/auth/",
                auth
            );
        } else {
            throw new Exception("Error: Auth keys are empty");
        }

        EvalAuthInfo info = Factory.evalAuthInfo(response);

        if (info.code == 200) {
            return info;
        }

        throw new Exception("Error: "+info.message);
    }

    public static void validateGateway(Client client) throws Exception {
        if (client == null) {
            throw new Exception("Client object is not valid");
        }

        boolean clientMode = client.live;
        EvalAuthInfo authInfo = evalAuth(client);

        if (authInfo.mode_key != authInfo.livemode) {
            throw new Exception("Keys are diferent of store mode");
        }

        if (clientMode != authInfo.livemode) {
            throw new Exception("Client mode is diferent of store mode");
        }

        if (clientMode != authInfo.mode_key) {
            throw new Exception("Client mode is diferent of keys mode");
        }
    }

}
