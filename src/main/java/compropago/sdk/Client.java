/**
 * @author Eduardo Aguilar <eduardo.aguilar@compropago.com>
 */

package compropago.sdk;



public class Client {

    private static String VERSION = "2.0.0";

    private static String API_LIVE_URI = "http://api.compropago.com/v1/";
    private static String API_SANDBOX_URI = "http://api.compropago.com/v1/";

    private String publickey;
    private String privatekey;
    private boolean live;
    private String contained;

    private String deployUri;

    public Service api;


    public Client(String publickey, String privatekey, boolean live, String contained){
        this.publickey = publickey;
        this.privatekey = privatekey;
        this.live = live;
        this.contained = contained;

        this.deployUri = live ? API_LIVE_URI : API_SANDBOX_URI;

        this.api = new Service(this);
    }



    public Client(String publickey, String privatekey, boolean live){
        this.publickey = publickey;
        this.privatekey = privatekey;
        this.live = live;
        this.contained = "SDK; java " + VERSION;

        this.deployUri = live ? API_LIVE_URI : API_SANDBOX_URI;

        this.api = new Service(this);
    }


    public String getAuth(){
        return this.privatekey + ":";
    }

    public String getFullAuth(){
        return this.privatekey + ":" + this.publickey;
    }

    public boolean getMode(){
        return this.live;
    }

    public String getUri(){
        return this.deployUri;
    }

    public String getContained(){
        return this.contained;
    }

}
