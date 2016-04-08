/**
 * Created by joe on 16/4/7.
 */
public class Testwriter {
    public static void main(String[] args) {
        int i = 0;
        while (true) {
            if(i > 30)
                break;
            Helper.writeResponse(String.valueOf(i));
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;
        }
    }
}
