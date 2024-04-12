package Animals_Kennel.model.animal;

import java.time.LocalDate;

public class Horse extends PackAnimal{
    public Horse(int id, String name, LocalDate dateOfBirth, Gender gender, String breed) {
        super(id, name, dateOfBirth, gender, AnimalType.Horse, breed);
    }

    public void neigh(){
        System.out.println("Игого-Игого!!!");
    }
}
