package by.epam.texthandling.handler;

import by.epam.texthandling.composite.Component;
import by.epam.texthandling.composite.WordComposite;
import by.epam.texthandling.exception.TextParcerException;
import by.epam.texthandling.resources.RegularExpression;

import java.sql.SQLOutput;

public class SentenceParcer implements TextParcer {

    private TextParcer nextParcer = new Wordparcer();
    private Component sentenceComposite;

    @Override
    public Component handleRequest(String paragraphs) throws TextParcerException {
        if(paragraphs == null){
            throw new TextParcerException("Text for parce is null");
        }

        nextParcer = new Wordparcer();
        sentenceComposite = new WordComposite();
        String [] sentence = paragraphs.split(RegularExpression.SENTENCE_SPLIT_REG_EX);

        for(String x : sentence){
            sentenceComposite.add(nextParcer.handleRequest(x.trim()));
        }

        return sentenceComposite;
    }

}
