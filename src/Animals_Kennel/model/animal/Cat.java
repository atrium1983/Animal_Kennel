package Animals_Kennel.model.animal;

import java.time.LocalDate;

public class Cat extends Pet{
    public Cat(int id, String name, LocalDate dateOfBirth, Gender gender, String breed) {
        super(id, name, dateOfBirth, gender, AnimalType.Cat, breed);
    }

    public void meow(){
        System.out.println("Мяу-Мяу!!!");
    }
}
