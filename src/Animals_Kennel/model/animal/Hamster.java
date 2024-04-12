package Animals_Kennel.model.animal;

import java.time.LocalDate;

public class Hamster extends Pet{
    public Hamster(int id, String name, LocalDate dateOfBirth, Gender gender, String breed) {
        super(id, name, dateOfBirth, gender, AnimalType.Hamster, breed);
    }
    public void squeak(){
        System.out.println("Пи-Пи-Пи!!!");
    }
}
