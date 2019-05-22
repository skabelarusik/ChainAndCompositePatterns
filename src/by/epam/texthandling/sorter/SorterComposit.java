package by.epam.texthandling.sorter;

import by.epam.texthandling.composite.Component;
import by.epam.texthandling.exception.WrongDataComponentException;

public interface SorterComposit {

    Component sort(Component component) throws WrongDataComponentException;
}
