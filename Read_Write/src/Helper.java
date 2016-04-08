import java.io.*;

/**
 * Created by joe on 16/3/31.
 */
public class Helper {
    static void writeResponse(String message) {
        try {
            File file = new File("response");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file, true); //append
            BufferedWriter w = new BufferedWriter(fileWriter);
            w.write(message + "\n");
            w.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void readerResponse() {
        try{
            File file = new File("response");
            if (!file.exists()) {
                System.out.println(" file not existed yet");
            } else {
                String  thisLine = null;
                // open input stream test.txt for reading purpose.
                FileReader fileReader = new FileReader(file);
                BufferedReader br = new BufferedReader(fileReader);
                while ((thisLine = br.readLine()) != null) {
                    System.out.println(thisLine);
                }
                br.close();
                System.out.println("---------------------------------------------------");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void writeResponse(Exception message) {
        try {
            File file = new File("response");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file, true); //append
            BufferedWriter w = new BufferedWriter(fileWriter);
            w.write(message + "\n");
            w.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void SuccessComplete() {
        try {
            File file = new File("success");
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void FailComplete() {
        try {
            File file = new File("failure");
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
