package Animals_Kennel.model.animalRegister;

import Animals_Kennel.model.animal.Animal;
import Animals_Kennel.model.animal.comparators.AnimalComparatorByClass;
import Animals_Kennel.model.animal.comparators.AnimalComparatorById;
import Animals_Kennel.model.animal.comparators.AnimalComparatorByType;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AnimalRegistry implements Serializable, Iterable{
    private List<Animal> animalList;
    public AnimalRegistry(){
        animalList = new ArrayList<>();
    }
    public void addAnimal(Animal animal){
        animalList.add(animal);
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Животных в питомнике => ");
        sb.append((animalList.size()));
        sb.append(" \n");
        for (Animal animal: animalList) {
            sb.append(animal);
            sb.append("\n");
        }
        return sb.toString();
    }

    public String getAnimalInfo(int id) {
        StringBuilder sb = new StringBuilder();
        sb.append(getById(id));
        sb.append("\n");
        return sb.toString();
    }

    public Animal getById (int id) {
        for (Animal animal : animalList) {
            if (animal.getId() == id) {
                return animal;
            }
        }
        return null;
    }

    @Override
    public String toString(){
        return getInfo();
    }

    public void sortById(){
        animalList.sort(new AnimalComparatorById());
    }

    public void sortByType(){
        animalList.sort(new AnimalComparatorByType());
    }

    public void sortByClass(){
        animalList.sort(new AnimalComparatorByClass());
    }

    @Override
    public Iterator<Animal> iterator() {
        return new AnimalIterator(animalList);
    }
}