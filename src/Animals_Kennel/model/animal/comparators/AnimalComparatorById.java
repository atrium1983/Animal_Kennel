package Animals_Kennel.model.animal.comparators;

import Animals_Kennel.model.animal.Animal;

import java.util.Comparator;

public class AnimalComparatorById implements Comparator<Animal>{
    @Override
    public int compare(Animal o1, Animal o2) {
        return Integer.compare(o1.getId(), o2.getId());
    }
}
