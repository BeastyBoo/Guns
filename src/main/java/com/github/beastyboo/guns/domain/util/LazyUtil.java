package com.github.beastyboo.guns.domain.util;

import java.io.*;

/**
 * Created by Torbie on 19.11.2020.
 */
public class LazyUtil {

    /**
     * Saves a file with the json string.
     */
    public void saveFile(File file, String json) {
        final FileWriter fw;
        try {
            file.createNewFile();
            fw = new FileWriter(file);
            fw.write(json);
            fw.flush();
            fw.close();
        } catch (IOException e) {
            throw new UncheckedIOException(e);

        }
    }

    /**
     * Loads the json string from a file.
     */
    public String loadContent(File file) {
        if(file.exists()) {
            try {
                final BufferedReader reader = new BufferedReader(new FileReader(file));
                final  StringBuilder text = new StringBuilder();

                String line;

                while ((line = reader.readLine()) != null) {
                    text.append(line);
                }
                reader.close();
                return text.toString();
            } catch (IOException ex) {
                throw new UncheckedIOException(ex);
            }
        }
        return "";
    }


}
