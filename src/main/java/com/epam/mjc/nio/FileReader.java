package com.epam.mjc.nio;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileReader {

    public Profile getDataFromFile(File file) {

        InputStream inputStream = getFileFromResourceAsStream(String.valueOf(file));
        Profile profile = null;
        try ( InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
              BufferedReader reader = new BufferedReader(streamReader)) {
            String line;
            line = reader.readLine();
            profile = new Profile();
            while (line != null) {
                String key = line.split(":")[0];
                String str;
                switch (key) {
                    case "Name":
                        str = line.split(":")[1];
                        profile.setName(str.trim());
                        break;
                    case "Age":
                        str = line.split(":")[1];
                        Integer age = Integer.valueOf(str.trim());
                        profile.setAge(age);
                        break;
                    case "Email":
                        str = line.split(":")[1];
                        profile.setEmail(str.trim());
                        break;
                    case "Phone":
                        str = line.split(":")[1];
                        profile.setPhone(Long.valueOf(str.trim()));
                        break;
                    default:
                        break;
                }
                line = reader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return profile;
    }

    private InputStream getFileFromResourceAsStream(String fileName) {
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(fileName);
        } catch (FileNotFoundException e) {
            new IllegalArgumentException("file not found! " + fileName);;
        }
        return inputStream;
    }
}
