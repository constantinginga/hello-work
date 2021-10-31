package work.hello;

import java.util.HashMap;

public class ResponsesSinglton {

    private final HashMap<String, CustomMessage> response;
    private final static Object monitor = new Object();
    private static ResponsesSinglton instance;

    public ResponsesSinglton() {
        this.response = new HashMap<>();
    }

    public HashMap<String, CustomMessage> getResponse() {
        return response;
    }

    public static Object getMonitor() {
        return monitor;
    }

    public static ResponsesSinglton getInstance(){
        if (instance == null){
            instance = new ResponsesSinglton();
        }
        return instance;
    }
}
