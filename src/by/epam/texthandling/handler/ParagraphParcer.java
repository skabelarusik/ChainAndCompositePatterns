package by.epam.texthandling.handler;

import by.epam.texthandling.composite.Component;
import by.epam.texthandling.composite.WordComposite;
import by.epam.texthandling.exception.TextParcerException;
import by.epam.texthandling.resources.RegularExpression;

public class ParagraphParcer implements TextParcer {

    private TextParcer nextParcer;
    private Component paragraphsComposite;

    @Override
    public Component handleRequest(String text) throws TextParcerException {

        if(text == null){
            throw new TextParcerException("Text for parce is null");
        }

        paragraphsComposite = new WordComposite();

            nextParcer = new SentenceParcer();
            String[] paragraphs = text.split(RegularExpression.PARAGRAPH_SPLIT_REG_EX);

            for (String x : paragraphs) {
                paragraphsComposite.add(nextParcer.handleRequest(x.trim()));
            }

        return paragraphsComposite;
    }


}
