package by.epam.texthandling.reader;

import org.testng.Assert;
import org.testng.annotations.Test;
import resource.ParamForTest;

import java.io.FileNotFoundException;


public class FileDataReadTest {

    @Test
    public static void testFileRead () throws FileNotFoundException {
        String expectedText = ParamForTest.HELLO_WORLD;
        String text = FileDataRead.fileRead(ParamForTest.PUTH);
        Assert.assertEquals(text,expectedText);
    }

    @Test(expectedExceptions = FileNotFoundException.class)
    public static void testFileReadWrongPuth () throws FileNotFoundException {
        String text;
        text = FileDataRead.fileRead(ParamForTest.WRONG_FILE_PUTH);
    }

    @Test(expectedExceptions = FileNotFoundException.class)
    public static void testFileReadNullPuth () throws FileNotFoundException {
        String text;
        text = FileDataRead.fileRead(ParamForTest.NULL);
    }
}
