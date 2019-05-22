package by.epam.texthandling.creator;

import by.epam.texthandling.composite.Component;
import by.epam.texthandling.composite.WordComposite;
import by.epam.texthandling.exception.TextParcerException;
import by.epam.texthandling.resources.RegularExpression;

public class ComponentCreator {

    public static String recreateText(Component component) throws TextParcerException {

        StringBuilder stringBuilder;

        if(component == null){
            throw new TextParcerException("Wrong component for recreate text");
        }

            stringBuilder = new StringBuilder();

            for (Component text : ((WordComposite) component).getComponents()) {
                for (Component paragr : ((WordComposite) text).getComponents()) {
                    for (Component sentence : ((WordComposite) paragr).getComponents()) {
                        for (Component word : ((WordComposite) sentence).getComponents()) {
                            for (Component letter : ((WordComposite) word).getComponents()) {
                                stringBuilder.append(letter.toString());
                            }
                            stringBuilder.append(RegularExpression.PUNKT_SPLIT_REG_EX);
                        }
                    }
                    stringBuilder.append("\n");
                }
            }
        return stringBuilder.toString();
    }
}
