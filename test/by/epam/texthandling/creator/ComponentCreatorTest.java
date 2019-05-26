package by.epam.texthandling.creator;

import by.epam.texthandling.composite.Component;
import by.epam.texthandling.composite.Symbol;
import by.epam.texthandling.composite.TextComposite;
import by.epam.texthandling.composite.TypeComponent;
import by.epam.texthandling.exception.TextParcerException;
import by.epam.texthandling.resource.RegularExpression;
import org.testng.Assert;
import org.testng.annotations.Test;
import resource.ParamForTest;

public class ComponentCreatorTest {

    @Test
    public static void testRecreateText() throws TextParcerException {
        Component word = new TextComposite(TypeComponent.SYMBOL);
        word.add(ParamForTest.SYMBOL_A);
        word.add(ParamForTest.SYMBOL_B);
        word.add(ParamForTest.SYMBOL_5);
        word.add(new Symbol(ParamForTest.SPACE));
        Component word2 = new TextComposite(TypeComponent.SYMBOL);
        word.add(ParamForTest.SYMBOL_H);
        word.add(ParamForTest.SYMBOL_E);
        word.add(ParamForTest.SYMBOL_Y);
        Component sentence = new TextComposite(TypeComponent.LEXEM);
        sentence.add(word);

        sentence.add(word2);

        String expected = ParamForTest.SENTENCE;

       Assert.assertEquals(ComponentCreator.recreateText(sentence), expected);

    }

    @Test(expectedExceptions = TextParcerException.class)
    public static void testRecreateTextNullComponent() throws TextParcerException {
        String text;
        text = ComponentCreator.recreateText(ParamForTest.NULL_COMPONENT);
    }
}
