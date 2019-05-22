package by.epam.texthandling.sorter;

import by.epam.texthandling.composite.Component;
import by.epam.texthandling.composite.WordComposite;
import by.epam.texthandling.exception.WrongDataComponentException;

public class SorterSentenceWordCount implements SorterComposit {
    @Override
    public Component sort(Component component) throws WrongDataComponentException {
       if(component == null){
           throw new WrongDataComponentException("Component for sort sentences by words is null");
       }

        Component minComponent;
        Component currentComponent;
        int minSize;
        int current;
        for (Component textAll : ((WordComposite) component).getComponents()) {
            for(Component paragr : ((WordComposite)textAll).getComponents()){
                for (int i = 0; i < ((WordComposite) paragr).getComponents().size() - 1; i++) {
                minComponent = ((WordComposite) paragr).getComponents().get(i);
                minSize = ((WordComposite) minComponent).size();
                    for (int j = i + 1; j < ((WordComposite) paragr).getComponents().size(); j++) {
                        currentComponent = ((WordComposite) paragr).getComponents().get(j);
                        current = (((WordComposite) currentComponent).size());
                        if (current < minSize) {
                            ((WordComposite) paragr).getComponents().set(i, currentComponent);
                            minSize = current;
                            ((WordComposite) paragr).getComponents().set(j, minComponent);
                        }
                    }
                }
            }
        }

       return component;
    }
}
