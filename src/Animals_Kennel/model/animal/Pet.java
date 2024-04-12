package Animals_Kennel.model.animal;

import java.time.LocalDate;

public class Pet extends Animal{
    public Pet(int id, String name, LocalDate dateOfBirth, Gender gender, AnimalType animalType, String breed) {
        super(id, name, dateOfBirth, gender, AnimalClass.Pet, animalType, breed);
    }

    public void beNice(){
        System.out.println("I'm so cute! Love me, love me!");
    }
}
