package Animals_Kennel.model.animal;

import java.time.LocalDate;

public class Dog extends Pet {
    public Dog(int id, String name, LocalDate dateOfBirth, Gender gender, String breed) {
        super(id, name, dateOfBirth, gender, AnimalType.Dog, breed);
    }

    public void bark(){
        System.out.println("Гав-гав!!!");
    }
}
