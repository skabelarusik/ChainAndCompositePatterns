package main;


import by.epam.texthandling.creator.ComponentCreator;
import by.epam.texthandling.composite.Component;
import by.epam.texthandling.composite.WordComposite;
import by.epam.texthandling.exception.TextParcerException;
import by.epam.texthandling.handler.ParagraphParcer;
import by.epam.texthandling.handler.TextParcer;
import by.epam.texthandling.reader.FileDataRead;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {

    public static String pathFile = "src/by/epam/texthandling/resources/input.txt";

    public static void main(String[] args) throws IOException, TextParcerException {

      String text = FileDataRead.fileRead(pathFile);
      TextParcer textParcer = new ParagraphParcer();
        Component textComposite = new WordComposite();
        textComposite.add(textParcer.handleRequest(text));

        for(Component x : ((WordComposite)textComposite).getComponents()){{{
            for (Component y : ((WordComposite) x).getComponents()){
                for(Component z : ((WordComposite)y).getComponents()){
                    System.out.println(((WordComposite)z).getComponents().size());
                }
            }
        }
        }}


        for(Component x : ((WordComposite)textComposite).getComponents()) {
            {
                ((WordComposite) x).getComponents().sort(Comparator.comparingInt(o ->
                        ((WordComposite) o).getComponents().size()));
            }

            for (Component text1 : ((WordComposite) textComposite).getComponents()) {
                for (Component paragr1 : ((WordComposite) text1).getComponents()) {
                    System.out.println(paragr1);
                }
            }


        }
    }
}



