package org.fluentlenium.examples.cucumber;

import java.io.*;
import java.util.List;
import java.util.Vector;

public class PropertiesReader {

    public String readProperty(String key) {
        try {
            var pwd = System.getProperty("user.dir") + "\\examples\\cucumber\\target\\test-classes\\org\\fluentlenium\\examples\\cucumber\\";
            return readFromInputStream(new FileInputStream(pwd + "settings.properties"))
                    .stream()
                    .filter(line -> line.startsWith(key))
                    .map(line -> line.substring(line.indexOf('=') + 1))
                    .findFirst()
                    .orElse("");

        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }

    }

    private List<String> readFromInputStream(InputStream inputStream) throws IOException {
        var result = new Vector<String>();
        try (var bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                result.add(line);
            }
        }
        return result;
    }

}
