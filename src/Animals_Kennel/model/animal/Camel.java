package Animals_Kennel.model.animal;

import java.time.LocalDate;

public class Camel extends PackAnimal{
    public Camel(int id, String name, LocalDate dateOfBirth, Gender gender, String breed) {
        super(id, name, dateOfBirth, gender, AnimalType.Camel, breed);
    }
    public void grunt(){
        System.out.println("Ыу-Ыу-Ыу!!!");
    }
}
