package by.epam.texthandling.sorter;

import by.epam.texthandling.composite.Component;
import by.epam.texthandling.composite.TextComposite;
import by.epam.texthandling.composite.TypeComponent;
import by.epam.texthandling.exception.WrongDataComponentException;

public abstract class SorterComposit {

    public abstract void sort(Component component) throws WrongDataComponentException;

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

                for(Component currentParagr : ((TextComposite)part).getComponents()){
                    for (int i = 0; i < ((TextComposite)part).size(); i++){
                        minComponent = ((TextComposite)part).getComponents().get(i);;
                        minSize = ((TextComposite)minComponent).size();

                        for(int j = i + 1; j < ((TextComposite)part).size(); j++){
                            currentComponent = ((TextComposite)part).getComponents().get(j);
                            current = ((TextComposite)currentComponent).size();
                            temp = new TextComposite(typeComponent);
                            if (current < minSize) {
                                ((TextComposite)temp).add(((TextComposite) part).getComponents().get(i));
                                ((TextComposite) part).getComponents().set(i, currentComponent);
                                minSize = current;
                                ((TextComposite) part).getComponents().set(j, ((TextComposite) temp).getComponents().get(0));
                            }
                        }
                    }
                }
            }

        }


    }
}
