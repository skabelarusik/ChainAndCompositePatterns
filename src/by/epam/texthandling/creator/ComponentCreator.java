package by.epam.texthandling.creator;

import by.epam.texthandling.composite.Component;
import by.epam.texthandling.composite.Symbol;
import by.epam.texthandling.composite.TextComposite;
import by.epam.texthandling.composite.TypeComponent;
import by.epam.texthandling.exception.TextParcerException;
import by.epam.texthandling.resource.RegularExpression;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ComponentCreator {

    private static final Logger LOGGER = LogManager.getLogger();

    public static String recreateText(Component component) throws TextParcerException {

        if (component == null) {
            throw new TextParcerException("Wrong component for recreate text");
        }

        String text = ((TextComposite)component).toString();
        LOGGER.debug("Text was recreated");

        return text;

    }
}
