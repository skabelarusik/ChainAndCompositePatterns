package by.epam.texthandling.sorter;

import by.epam.texthandling.composite.Component;
import by.epam.texthandling.composite.WordComposite;
import by.epam.texthandling.exception.WrongDataComponentException;

public class SorterParagraphsSentenseCount implements SorterComposit {


    public Component sort(Component component) throws WrongDataComponentException {
        if (component == null || !(component instanceof Component)) {
            throw new WrongDataComponentException("Component for sort is null");
        }

        Component minComponent;
        Component currentComponent;
        int min;
        int current;
        for (Component textAll : ((WordComposite) component).getComponents()) {

            for (int i = 0; i < ((WordComposite) textAll).getComponents().size() - 1; i++) {
                minComponent = ((WordComposite) textAll).getComponents().get(i);
                min = ((WordComposite) minComponent).size();
                for (int j = i + 1; j < ((WordComposite) textAll).getComponents().size(); j++) {
                    currentComponent = ((WordComposite) textAll).getComponents().get(j);
                    current = (((WordComposite) currentComponent).size());
                    if (current < min) {
                        ((WordComposite) textAll).getComponents().set(i, currentComponent);
                        ((WordComposite) textAll).getComponents().set(j, minComponent);
                        min = current;
                    }
                }
            }
        }
        return component;
    }
}


