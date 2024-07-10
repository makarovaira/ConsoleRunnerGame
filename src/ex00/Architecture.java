package src.ex00;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Architecture {

    public Map<String, String> readPropertiesFile(String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.isFile()) {
            System.err.println("Not exists file!");
            System.exit(-1);
        }
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        Map<String, String> map = new HashMap<>();
        while ((line = br.readLine()) != null) {
            String [] parts = line.split(" ");
            if (parts.length == 3) {
                map.put(parts[0], parts[2]);
            } else {
                map.put(parts[0], " ");
            }
        }
        return map;
    }
}
