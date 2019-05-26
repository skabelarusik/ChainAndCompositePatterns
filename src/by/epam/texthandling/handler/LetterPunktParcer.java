package by.epam.texthandling.handler;

import by.epam.texthandling.composite.Component;
import by.epam.texthandling.composite.Symbol;
import by.epam.texthandling.composite.TextComposite;
import by.epam.texthandling.composite.TypeComponent;
import by.epam.texthandling.exception.TextParcerException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LetterPunktParcer implements TextParcer {

    private Component symbol;
    private static final Logger LOGGER = LogManager.getLogger();


    @Override
    public Component handleRequest(String text) throws TextParcerException {
        if(text == null){
            throw new TextParcerException("Text for parce is null");
        }

        symbol = new TextComposite(TypeComponent.SYMBOL);
        char[] simbols = text.toCharArray();

        for(char element : simbols){
            LOGGER.debug("{ " + element + " } was added to" + ((TextComposite)symbol).getTypeComponent());
            symbol.add(new Symbol(element));
        }

        return symbol;
    }
}
