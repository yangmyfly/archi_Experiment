/**
 * Created by joe on 16/4/7.
 */
public class Testreader {
    public static void main(String[] args) {
        int i = 0;
        while (true) {
            if(i > 15)
                break;
            Helper.readerResponse();
            try {
                Thread.sleep(800);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;
        }

        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Helper.readerResponse();
    }
}
