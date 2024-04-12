package Animals_Kennel.model.animal;

import java.time.LocalDate;

public class Donkey extends PackAnimal{
    public Donkey(int id, String name, LocalDate dateOfBirth, Gender gender, String breed) {
        super(id, name, dateOfBirth, gender, AnimalType.Donkey, breed);
    }

    public void bray(){
        System.out.println("Иа-Иа-Иа!!!");
    }
}
