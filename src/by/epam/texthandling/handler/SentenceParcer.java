package by.epam.texthandling.handler;

import by.epam.texthandling.composite.Component;
import by.epam.texthandling.composite.TextComposite;
import by.epam.texthandling.composite.TypeComponent;
import by.epam.texthandling.exception.TextParcerException;
import by.epam.texthandling.resource.RegularExpression;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SentenceParcer implements TextParcer {

    private TextParcer nextParcer = new LexemParcer();
    private Component sentenceComposite;
    private static final Logger LOGGER = LogManager.getLogger();


    @Override
    public Component handleRequest(String paragraphs) throws TextParcerException {
        if(paragraphs == null){
            throw new TextParcerException("Text for parce is null");
        }

        nextParcer = new LexemParcer();
        sentenceComposite = new TextComposite(TypeComponent.SENTENCE);
        String [] sentence = paragraphs.split(RegularExpression.SENTENCE_SPLIT_REG_EX);

        for(String sent : sentence){
            LOGGER.debug("{ " + sent + " } was added to" + ((TextComposite)sentenceComposite).getTypeComponent());

            sentenceComposite.add(nextParcer.handleRequest(sent.trim()));
        }

        return sentenceComposite;
    }

}
