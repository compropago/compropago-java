package compropagosdk.tools;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Map;

import com.google.gson.Gson;

public class Http {

    private String url;
    private String method;
    private String data;
    private Map<String, String> auth;
    private Map<String, String> headers;

    public Http(String url) {
        this.url = url;
    }

    public void setMethod(String method) throws Exception {
        if (method.equals("GET") || method.equals("POST") || method.equals("PUT") || method.equals("DELETE")) {
            this.method = method;
        } else {
            throw new Exception("Not supported request Method");
        }
    }

    public void setAuth(Map<String, String> auth) throws Exception {
        if (auth != null) {
            if (auth.containsKey("user") && auth.containsKey("pass")) {
                this.auth = auth;
            }else{
                throw new Exception("Auth data is not valid");
            }
        }
    }

    public void setData(Map<String, String> data) {
        if (data != null) {
            this.data = new Gson().toJson(data);
        } else {
            this.data = null;
        }
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public String executeRequest() throws IOException {
        URL uri = new URL(this.url);
        HttpURLConnection con = (HttpURLConnection) uri.openConnection();

        con.setRequestMethod(this.method);
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Cache-Control", "no-cache");
        con.setDoOutput(true);

        if (this.auth != null) {
            String fullauth = this.auth.get("user") + ':' + this.auth.get("pass");

            Base64.Encoder encoder = Base64.getEncoder();
            String authToken = encoder.encodeToString(fullauth.getBytes(StandardCharsets.UTF_8));

            con.setRequestProperty("Authorization", "Basic " + authToken);
        }

        if (this.headers != null) {
            for(Map.Entry<String, String> entry : this.headers.entrySet()) {
                con.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }

        if (this.data != null) {
            OutputStream os = con.getOutputStream();
            os.write(this.data.getBytes());
            os.flush();
        }

        InputStream is = con.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));

        StringBuilder res = new StringBuilder();
        String line;
        while((line = reader.readLine()) != null){
            res.append(line);
        }

        reader.close();

        return res.toString();
    }
}
