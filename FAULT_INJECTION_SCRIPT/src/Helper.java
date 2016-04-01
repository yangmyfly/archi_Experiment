import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 * Created by joe on 16/3/31.
 */
public class Helper {
    static void writeSuccessResponse() {
        try {
            File file = new File("response");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file, false); //not append
            BufferedWriter w = new BufferedWriter(fileWriter);
            w.write("success");
            w.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void writeSuccessResponse(String message) {
        try {
            File file = new File("response");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file, false); //not append
            BufferedWriter w = new BufferedWriter(fileWriter);
            w.write("success" + "\n" + message);
            w.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void writeFailResponse(Exception message) {
        try {
            File file = new File("response");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file, false); //not append
            BufferedWriter w = new BufferedWriter(fileWriter);
            w.write("failure" + "\n" + message);
            w.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void writeFailResponse(String message) {
        try {
            File file = new File("response");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file, false); //not append
            BufferedWriter w = new BufferedWriter(fileWriter);
            w.write("failure" + "\n" + message);
            w.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
