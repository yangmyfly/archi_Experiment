/**
 * Created by wilsoncao on 4/30/16.
 */

public class RealPlugin implements IPlugin{
    public void run() {
        System.out.println(getClass().getName() + ": user.home: " + System.getProperty("user.home"));
    }
}
