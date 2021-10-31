package work.hello;

import java.util.HashMap;

public class TestSingleton {

    private final HashMap<String, CustomMessage> response;
    private final static Object monitor = new Object();
    private static TestSingleton instance;

    public TestSingleton() {
        this.response = new HashMap<>();
    }

    public HashMap<String, CustomMessage> getResponse() {
        return response;
    }

    public static Object getMonitor() {
        return monitor;
    }

    public static TestSingleton getInstance(){
        if (instance == null){
            instance = new TestSingleton();
        }
        return instance;
    }
}
