package compropago.sdk.tools;

import compropago.sdk.Client;
import compropago.sdk.factory.Factory;
import compropago.sdk.models.EvalAuthInfo;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;


/**
 * @author Eduardo Aguilar <eduardo.aguilar@compropago.com>
 */

public class Validations {

    public static EvalAuthInfo evalAuth(Client client) throws Exception {
        URL uri = new URL(client.getUri() + "users/auth/");
        HttpURLConnection con = (HttpURLConnection) uri.openConnection();

        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");


        Base64.Encoder encoder = Base64.getEncoder();
        String auth = encoder.encodeToString(client.getFullAuth().getBytes(StandardCharsets.UTF_8));

        con.setRequestProperty("Authorization", "Basic " + auth);

        con.setUseCaches(false);
        con.setDoOutput(true);

        InputStream is = con.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));

        StringBuilder res = new StringBuilder();
        String line;
        while((line = reader.readLine()) != null){
            res.append(line);
            res.append('\r');
        }

        reader.close();

        return Factory.evalAuthInfo(res.toString());
    }


    public static boolean validateGateway(Client client) throws Exception {
        boolean clientMode = client.getMode();
        EvalAuthInfo authInfo = Validations.evalAuth(client);

        if (authInfo.mode_key != authInfo.livemode) {
            throw new Exception("Las llaves no corresponden al modo de la tienda");
        }

        if (clientMode != authInfo.livemode) {
            throw new Exception("El modo del clinete no corresponde al de la tienda");
        }

        if (clientMode != authInfo.mode_key) {
            throw new Exception("El modo del cliente no corresponde al de las llaves");
        }

        return true;
    }
}
