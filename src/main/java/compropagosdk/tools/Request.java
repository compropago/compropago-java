package compropagosdk.tools;


import com.google.gson.Gson;
import compropagosdk.factory.models.GenericError;

import java.util.Map;

public class Request {

    private static boolean validateResponse(String response) throws Exception {
        if (response == null || response.equals("")) {
            throw new Exception("Empty response");
        }

        try {
            Gson parser = new Gson();
            GenericError error = parser.fromJson(response, GenericError.class);

            if (error.type.equals("error")) {
                throw new  Exception("Error: "+error.message);
            }

            return true;
        } catch(Exception e) {
            return true;
        }
    }

    public static String get(String url, Map<String, String> auth, Map<String, String> headers) throws Exception {
        Http http = new Http(url);
        http.setMethod("GET");
        http.setAuth(auth);
        http.setHeaders(headers);
        String response = http.executeRequest();

        validateResponse(response);

        return response;
    }

    public static String get(String url, Map<String, String> auth) throws Exception {
        Http http = new Http(url);
        http.setMethod("GET");
        http.setAuth(auth);
        http.setHeaders(null);
        String response = http.executeRequest();

        validateResponse(response);

        return response;
    }

    public static String get(String url) throws Exception {
        Http http = new Http(url);
        http.setMethod("GET");
        http.setAuth(null);
        http.setHeaders(null);
        String response = http.executeRequest();

        validateResponse(response);

        return response;
    }

    public static String post(String url, Map<String, String> data, Map<String, String> auth, Map<String, String> headers) throws Exception {
        Http http = new Http(url);
        http.setMethod("POST");
        http.setData(data);
        http.setAuth(auth);
        http.setHeaders(headers);
        String response = http.executeRequest();

        validateResponse(response);

        return response;
    }

    public static String post(String url, Map<String, String> data, Map<String, String> auth) throws Exception {
        Http http = new Http(url);
        http.setMethod("POST");
        http.setData(data);
        http.setAuth(auth);
        http.setHeaders(null);
        String response = http.executeRequest();

        validateResponse(response);

        return response;
    }

    public static String post(String url, Map<String, String> data) throws Exception {
        Http http = new Http(url);
        http.setMethod("POST");
        http.setData(data);
        http.setAuth(null);
        http.setHeaders(null);
        String response = http.executeRequest();

        validateResponse(response);

        return response;
    }

    public static String post(String url) throws Exception {
        Http http = new Http(url);
        http.setMethod("POST");
        http.setData(null);
        http.setAuth(null);
        http.setHeaders(null);
        String response = http.executeRequest();

        validateResponse(response);

        return response;
    }

    public static String put(String url, Map<String, String> data, Map<String, String> auth, Map<String, String> headers) throws Exception {
        Http http = new Http(url);
        http.setMethod("PUT");
        http.setData(data);
        http.setAuth(auth);
        http.setHeaders(headers);
        String response = http.executeRequest();

        validateResponse(response);

        return response;
    }

    public static String put(String url, Map<String, String> data, Map<String, String> auth) throws Exception {
        Http http = new Http(url);
        http.setMethod("PUT");
        http.setData(data);
        http.setAuth(auth);
        http.setHeaders(null);
        String response = http.executeRequest();

        validateResponse(response);

        return response;
    }

    public static String put(String url, Map<String, String> data) throws Exception {
        Http http = new Http(url);
        http.setMethod("PUT");
        http.setData(data);
        http.setAuth(null);
        http.setHeaders(null);
        String response = http.executeRequest();

        validateResponse(response);

        return response;
    }

    public static String put(String url) throws Exception {
        Http http = new Http(url);
        http.setMethod("PUT");
        http.setData(null);
        http.setAuth(null);
        http.setHeaders(null);
        String response = http.executeRequest();

        validateResponse(response);

        return response;
    }

    public static String delete(String url, Map<String, String> data, Map<String, String> auth, Map<String, String> headers) throws Exception {
        Http http = new Http(url);
        http.setMethod("DELETE");
        http.setData(data);
        http.setAuth(auth);
        http.setHeaders(headers);
        String response = http.executeRequest();

        validateResponse(response);

        return response;
    }

    public static String delete(String url, Map<String, String> data, Map<String, String> auth) throws Exception {
        Http http = new Http(url);
        http.setMethod("DELETE");
        http.setData(data);
        http.setAuth(auth);
        http.setHeaders(null);
        String response = http.executeRequest();

        validateResponse(response);

        return response;
    }

    public static String delete(String url, Map<String, String> data) throws Exception {
        Http http = new Http(url);
        http.setMethod("DELETE");
        http.setData(data);
        http.setAuth(null);
        http.setHeaders(null);
        String response = http.executeRequest();

        validateResponse(response);

        return response;
    }

    public static String delete(String url) throws Exception {
        Http http = new Http(url);
        http.setMethod("DELETE");
        http.setData(null);
        http.setAuth(null);
        http.setHeaders(null);
        String response = http.executeRequest();

        validateResponse(response);

        return response;
    }
}
