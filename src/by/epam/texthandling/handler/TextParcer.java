package by.epam.texthandling.handler;

import by.epam.texthandling.composite.Component;
import by.epam.texthandling.composite.WordComposite;
import by.epam.texthandling.exception.TextParcerException;

public interface TextParcer {

    Component handleRequest(String text) throws TextParcerException;
}
