package by.epam.texthandling.reader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileDataRead {

    public static String fileRead (String pathFile) throws FileNotFoundException {
        if(pathFile == null ){
            throw new FileNotFoundException("path is null");
        }

        String text;
        try {
            text = new String(Files.readAllBytes(Paths.get(pathFile)));
        } catch (IOException e) {
            throw new FileNotFoundException("Wrong path");
        }

        return text;
    }
}
