package Animals_Kennel.model.builder;

public class Counter {
    private int currentId;

    public Counter(){
        this.currentId = 1;
    }

    public int addCurrentId(){
        return currentId++;
    }
}
