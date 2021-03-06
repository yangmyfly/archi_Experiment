import com.amazonaws.AmazonServiceException;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

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
