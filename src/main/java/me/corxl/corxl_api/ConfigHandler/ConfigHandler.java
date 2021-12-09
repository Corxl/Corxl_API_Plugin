package me.corxl.corxl_api.ConfigHandler;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ConfigHandler {

    public static void setLineInFile(File file, String path, String value) throws IOException {

        List<String> lines = new ArrayList<>();

        BufferedReader rd = new BufferedReader(new FileReader(file));

        String line = rd.readLine();
        while (line != null) {
            if (line.trim().split(":")[0].equalsIgnoreCase(path)) {
                String[] strs = line.split(":");
                if ((strs.length>1)&&(strs[1] != null)) {
                    strs[1] = value;
                    StringBuilder builder = new StringBuilder(strs[0]);
                    builder.append(": " + strs[1]);
                    lines.add(builder.toString());
                } else {
                    lines.add(line);
                }

            } else {
                lines.add(line);
            }
            line = rd.readLine();
        }
        rd.close();

        BufferedWriter wr = new BufferedWriter(new FileWriter(file));
        lines.forEach(lineValue-> {
            System.out.println(lineValue);
            try {
                wr.write(lineValue + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        wr.close();
    }
}
