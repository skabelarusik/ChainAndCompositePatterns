package by.epam.texthandling.handler;

import by.epam.texthandling.composite.Component;
import by.epam.texthandling.composite.Simbol;
import by.epam.texthandling.composite.WordComposite;
import by.epam.texthandling.exception.TextParcerException;

public class LetterPunktParcer implements TextParcer {

    private Component letter;

    @Override
    public Component handleRequest(String text) throws TextParcerException {
        if(text == null){
            throw new TextParcerException("Text for parce is null");
        }

        letter = new WordComposite();
        char[] simbols = text.toCharArray();

        for(char x : simbols){
            letter.add(new Simbol(x));
        }

        return letter;
    }
}
