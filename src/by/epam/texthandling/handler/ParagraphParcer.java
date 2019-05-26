package by.epam.texthandling.handler;

import by.epam.texthandling.composite.Component;
import by.epam.texthandling.composite.TextComposite;
import by.epam.texthandling.composite.TypeComponent;
import by.epam.texthandling.exception.TextParcerException;
import by.epam.texthandling.resource.RegularExpression;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ParagraphParcer implements TextParcer {

    private TextParcer nextParcer;
    private Component paragraphsComposite;

    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public Component handleRequest(String text) throws TextParcerException {

        if(text == null){
            throw new TextParcerException("Text for parce is null");
        }

        paragraphsComposite = new TextComposite(TypeComponent.PARAGRAPH);

            nextParcer = new SentenceParcer();
            String[] paragraphs = text.split(RegularExpression.PARAGRAPH_SPLIT_REG_EX);

            for (String paragr : paragraphs) {
                LOGGER.debug("{ " + paragr + " } was added to" + ((TextComposite)paragraphsComposite).getTypeComponent());
                paragraphsComposite.add(nextParcer.handleRequest(paragr.trim()));
            }

        return paragraphsComposite;
    }


}
