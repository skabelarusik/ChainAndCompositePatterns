package by.epam.texthandling.sorter;

import by.epam.texthandling.composite.Component;
import by.epam.texthandling.composite.TextComposite;
import by.epam.texthandling.composite.TypeComponent;
import by.epam.texthandling.exception.WrongDataComponentException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SorterSentenceWordCount extends SorterComposit {

    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public void sort(Component component) throws WrongDataComponentException {
       if(component == null){
           throw new WrongDataComponentException("Component for sort sentences by words is null");
       }
        sortHelper(component, TypeComponent.SENTENCE);
        LOGGER.debug(((TextComposite)component).getTypeComponent() + " was sorted");

    }
}
