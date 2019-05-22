package by.epam.texthandling.composite;

public class Simbol implements Component {

    private char simbol;

    public Simbol(){}

    public Simbol(char simbol){
        this.simbol = simbol;
    }

 //   @Override
 //   public void operation() {
 //   }

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

    @Override
    public String toString() {
        String res = String.valueOf(simbol);
        return res;
    }
}
