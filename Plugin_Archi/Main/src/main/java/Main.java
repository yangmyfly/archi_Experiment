/**
 * Created by wilsoncao on 4/30/16.
 */

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class Main {


    public static void main(String[] arguments) throws Throwable {
        new Main();
    }

    public Main() throws Throwable {

        File authorizedJarFile = new File("/Users/wilsoncao/Documents/workspace/Plugin/target/Plugin-1.0-SNAPSHOT.jar");
        ClassLoader authorizedLoader = URLClassLoader.newInstance(new URL[] { authorizedJarFile.toURI().toURL() });
        IPlugin authorizedPlugin = (IPlugin) authorizedLoader.loadClass("RealPlugin").newInstance();
        authorizedPlugin.run();

    }

}