package Animals_Kennel.model.animalRegister;

import Animals_Kennel.model.animal.Animal;

import java.util.Iterator;
import java.util.List;

public class AnimalIterator implements Iterator{
    public int index;
    public List<Animal> animalList;

    public AnimalIterator(List<Animal> animalList) {
        this.animalList = animalList;
    }

    @Override
    public boolean hasNext() {
        return index < animalList.size();
    }

    @Override
    public Animal next() {
        return animalList.get(index);
    }

    @Override
    public void remove() {
        Iterator.super.remove();
    }
}
