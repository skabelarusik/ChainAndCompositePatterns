package by.epam.texthandling.composite;

import java.util.Objects;

public class Symbol implements Component {

    private char simbol;
    private TypeComponent typeComponent = TypeComponent.SYMBOL;

    public Symbol(String space){}

    public Symbol(char simbol){
        this.simbol = simbol;
    }

    @Override
    public boolean add(Component component) {
        return false;
    }

    @Override
    public boolean remove(Component component) {
        return false;
    }

    public char getSimbol() {
        return simbol;
    }

    public void setSimbol(char simbol) {
        this.simbol = simbol;
    }

    public TypeComponent getTypeComponent() {
        return typeComponent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Symbol symbol = (Symbol) o;
        return simbol == symbol.simbol;
    }

    @Override
    public int hashCode() {
        return Objects.hash(simbol);
    }

    @Override
    public String toString() {
        String res = String.valueOf(simbol);
        return res;
    }
}
