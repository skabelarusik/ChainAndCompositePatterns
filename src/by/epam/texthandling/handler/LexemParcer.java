package by.epam.texthandling.handler;


import by.epam.texthandling.composite.Component;
import by.epam.texthandling.composite.TextComposite;
import by.epam.texthandling.composite.TypeComponent;
import by.epam.texthandling.exception.TextParcerException;
import by.epam.texthandling.resource.RegularExpression;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LexemParcer implements TextParcer {

    private TextParcer nextParcer;
    private Component lexemComposite;
    private static final Logger LOGGER = LogManager.getLogger();


    @Override
    public Component handleRequest(String text) throws TextParcerException {
        if(text == null){
            throw new TextParcerException("Text for parce is null");
        }

        nextParcer = new LetterPunktParcer();
        lexemComposite = new TextComposite(TypeComponent.LEXEM);
        String [] lexems = text.split(RegularExpression.WORD_SPLIT_REG_EX);

        for(String element : lexems){
            LOGGER.debug("{ " + element + " } was added to" + ((TextComposite)lexemComposite).getTypeComponent());
            lexemComposite.add(nextParcer.handleRequest(element));
        }
        return lexemComposite;
    }
}
