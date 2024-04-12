package Animals_Kennel.model.animal;

import java.time.LocalDate;

public class PackAnimal extends Animal{
    public PackAnimal(int id, String name, LocalDate dateOfBirth, Gender gender, AnimalType animalType, String breed) {
        super(id, name, dateOfBirth, gender, AnimalClass.PackAnimal, animalType, breed);
    }

    public void work(){
        System.out.println("I'm working!");
    }
}
