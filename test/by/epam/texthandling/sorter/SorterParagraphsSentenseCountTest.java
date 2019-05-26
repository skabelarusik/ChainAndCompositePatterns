package by.epam.texthandling.sorter;

import by.epam.texthandling.composite.Component;
import by.epam.texthandling.composite.Symbol;
import by.epam.texthandling.composite.TextComposite;
import by.epam.texthandling.composite.TypeComponent;
import by.epam.texthandling.exception.WrongDataComponentException;
import org.testng.Assert;
import org.testng.annotations.Test;
import resource.ParamForTest;

import java.awt.*;

public class SorterParagraphsSentenseCountTest{


    @Test
    public void testSort() throws WrongDataComponentException {
        Component symbol1 = new Symbol("a");
        Component symbol2 = new Symbol("b");
        Component symbol3 = new Symbol("c");
        Component word1 = new TextComposite(TypeComponent.LEXEM);
        word1.add(symbol1);
        word1.add(symbol2);
        word1.add(symbol3);

        Component symbol4 = new Symbol("d");
        Component symbol5 = new Symbol("e");
        Component word2 = new TextComposite(TypeComponent.LEXEM);
        word2.add(symbol4);
        word2.add(symbol5);

        Component sentence = new TextComposite(TypeComponent.SENTENCE);
        sentence.add(word1);
        sentence.add(word2);

        Component sentence1 = new TextComposite(TypeComponent.SENTENCE);

        Component paragraph1 = new TextComposite(TypeComponent.PARAGRAPH);
        paragraph1.add(sentence);
        paragraph1.add(sentence1);

        Component paragraph2 = new TextComposite(TypeComponent.PARAGRAPH);
        paragraph2.add(sentence);

        Component text = new TextComposite(TypeComponent.TEXT);
        text.add(paragraph1);
        text.add(paragraph2);

        Component expectedText = new TextComposite(TypeComponent.TEXT);
        expectedText.add(paragraph2);
        expectedText.add(paragraph1);


        SorterParagraphsSentenseCount sort = new SorterParagraphsSentenseCount();
        sort.sort(text);
        Assert.assertEquals(text, expectedText);
    }

    @Test(expectedExceptions = WrongDataComponentException.class)
    public void testSortNullComponent() throws WrongDataComponentException {
        SorterParagraphsSentenseCount sort = new SorterParagraphsSentenseCount();
        sort.sort(ParamForTest.NULL_COMPONENT);
    }


}


