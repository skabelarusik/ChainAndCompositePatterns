package by.epam.texthandling.composite;

import java.util.ArrayList;

public class WordComposite implements Component {

    private ArrayList<Component> components;

    public WordComposite(){
        components = new ArrayList<>();
    }

//    @Override
//    public void operation() {
//        components.removeIf(o -> o == null);
//        components.forEach(Component::operation);
//    }

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

    public ArrayList<Component> getComponents() {
        return components;
    }

    public void setComponents(ArrayList<Component> components) {
        this.components = components;
    }

    @Override
    public String toString() {
        String res = components.toString();
        return res;
    }


}
