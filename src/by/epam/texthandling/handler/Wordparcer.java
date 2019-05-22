package by.epam.texthandling.handler;


import by.epam.texthandling.composite.Component;
import by.epam.texthandling.composite.WordComposite;
import by.epam.texthandling.exception.TextParcerException;
import by.epam.texthandling.resources.RegularExpression;

public class Wordparcer implements TextParcer {

    private TextParcer nextParcer;
    private Component wordComposite;

    @Override
    public Component handleRequest(String text) throws TextParcerException {
        if(text == null){
            throw new TextParcerException("Text for parce is null");
        }

        nextParcer = new LetterPunktParcer();
        wordComposite = new WordComposite();
        String [] words = text.split(RegularExpression.WORD_SPLIT_REG_EX);

        for(String x : words){
            wordComposite.add(nextParcer.handleRequest(x));
        }
        return wordComposite;
    }
}
