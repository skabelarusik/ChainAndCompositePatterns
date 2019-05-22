package by.epam.texthandling.sorter;

import by.epam.texthandling.composite.Component;
import by.epam.texthandling.composite.WordComposite;
import by.epam.texthandling.exception.WrongDataComponentException;

public class SorterParagraphsSentenseCount {

    public Component sortByCountSentence(Component component) throws WrongDataComponentException {
        if(component == null || !(component instanceof Component)){
            throw new WrongDataComponentException("Component for sort is null");
        }

        Component component1 = new WordComposite();
        for(Component text : ((WordComposite)component).getComponents()){
            for(int i = 1; i < ((WordComposite)text).getComponents().size(); i++){
           //     if(((WordComposite)text).getComponents().get(i) <
            }
        }
        return component1;
        }
        }


