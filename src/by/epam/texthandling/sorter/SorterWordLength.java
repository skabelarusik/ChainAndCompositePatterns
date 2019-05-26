package by.epam.texthandling.sorter;

import by.epam.texthandling.composite.Component;
import by.epam.texthandling.composite.Symbol;
import by.epam.texthandling.composite.TextComposite;
import by.epam.texthandling.composite.TypeComponent;
import by.epam.texthandling.exception.WrongDataComponentException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SorterWordLength extends SorterComposit {

    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public void sort(Component component) throws WrongDataComponentException {
        if(component == null){
            throw new WrongDataComponentException("Component for sort sentences by words is null");
        }

        sortHelper(component, TypeComponent.LEXEM);
        LOGGER.debug(((TextComposite)component).getTypeComponent() + " was sorted");
    }

    @Override
    protected void sortHelper(Component component, TypeComponent typeComponent){
        for(Component part : ((TextComposite)component).getComponents()){

            if(((TextComposite)part).getTypeComponent() != typeComponent){
                sortHelper(part, typeComponent);
            } else{
                Component minComponent;
                Component currentComponent;
                Component temp;
                int minSize;
                int current;

                    for (int i = 0; i < ((TextComposite)part).getComponents().size(); i++){
                        minComponent = ((TextComposite)part).getComponents().get(i);
                        minSize =countLetter(minComponent);
                        for(int j = i + 1; j < ((TextComposite)part).getComponents().size(); j++){
                            currentComponent = ((TextComposite)part).getComponents().get(j);
                            current = countLetter(currentComponent);
                            temp = new TextComposite(TypeComponent.LEXEM);

                            if (current < minSize) {
                                ((TextComposite)temp).add(((TextComposite) part).getComponents().get(i));
                                ((TextComposite) part).getComponents().set(i, currentComponent);
                                minSize = current;
                                ((TextComposite) part).getComponents().set(j, ((TextComposite)temp).getComponents().get(0));
                            }
                        }
                    }
                }
            }
        }

    private int countLetter(Component component){
        int size = 0;
        for(Component component1 : ((TextComposite)component).getComponents()){
            if(Character.isLetter(((Symbol)component1).getSimbol())){
                size++;
            }
        }
        return size;
    }


}
