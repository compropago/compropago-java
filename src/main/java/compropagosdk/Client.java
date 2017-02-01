package compropagosdk;


public class Client {

    public static String VERSION = "2.0.0";

    private static String API_LIVE_URI = "https://api.compropago.com/v1/";
    private static String API_SANDBOX_URI = "https://api.compropago.com/v1/";

    private String publicKey;
    private String privateKey;

    public boolean live;
    public String deployUri;

    public Service api;

    public Client(String publicKey, String privateKey, boolean live) {
        this.publicKey = publicKey;
        this.privateKey = privateKey;
        this.live = live;

        this.deployUri = live ? API_LIVE_URI : API_SANDBOX_URI;

        this.api = new Service(this);
    }

    public String getUser() {
        return this.privateKey;
    }

    public String getPass() {
        return this.publicKey;
    }

}
