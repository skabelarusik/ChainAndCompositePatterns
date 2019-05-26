package by.epam.texthandling.composite;

import by.epam.texthandling.resource.RegularExpression;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TextComposite implements Component {

    private List<Component> components;
    private TypeComponent typeComponent;

    public TextComposite(TypeComponent typeComponent){
        this.typeComponent = typeComponent;
        components = new ArrayList<>();
    }

    public TextComposite(TypeComponent typeComponent, List<Component> component){
        this.components = component;
        this.typeComponent = typeComponent;
    }

    @Override
    public boolean add(Component component) {
        return components.add(component);
    }

    @Override
    public boolean remove(Component component) {
        return components.remove(component);
    }

    public int size(){
        int size = components.size();
        return size;
    }

    public TypeComponent getTypeComponent() {
        return typeComponent;
    }

    public List<Component> getComponents() {
        return components;
    }

    public void setComponents(ArrayList<Component> components) {
        this.components = components;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TextComposite that = (TextComposite) o;
        return Objects.equals(components, that.components);
    }

    @Override
    public int hashCode() {
        return Objects.hash(components);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for(Component textComponent : components){
            if(typeComponent != TypeComponent.SYMBOL){
            stringBuilder.append(textComponent.toString());
            }
            switch (typeComponent){
                case PARAGRAPH:
                   stringBuilder.append("\n");
                    break;
                case SENTENCE:
                    stringBuilder.append(RegularExpression.PUNСT_SPLIT_REG_EX);
                    break;
                case LEXEM:
                    stringBuilder.append(RegularExpression.PUNСT_SPLIT_REG_EX);
                    break;
                case SYMBOL:
                    stringBuilder.append(((Symbol)textComponent).toString());
                    break;

            }

        }
        return stringBuilder.toString();
    }


}
