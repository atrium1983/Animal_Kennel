package Animals_Kennel.model.builder;

import Animals_Kennel.model.animal.*;
import Animals_Kennel.model.animalRegister.AnimalRegistry;

import java.time.LocalDate;

public class RegistryBuilder {
    Counter counter = new Counter();

    public Animal addAnimal(String name, LocalDate dateOfBirth, Gender gender, AnimalClass animalClass, AnimalType animalType, String breed){
        switch (animalType){
            case AnimalType.Dog -> {
                return new Dog(counter.addCurrentId(), name, dateOfBirth, gender, breed);
            }
            case AnimalType.Cat -> {
                return new Cat(counter.addCurrentId(), name, dateOfBirth, gender, breed);
            }
            case AnimalType.Hamster -> {
                return new Hamster(counter.addCurrentId(), name, dateOfBirth, gender, breed);
            }
            case AnimalType.Horse -> {
                return new Horse(counter.addCurrentId(), name, dateOfBirth, gender, breed);
            }
            case AnimalType.Camel -> {
                return new Camel(counter.addCurrentId(), name, dateOfBirth, gender, breed);
            }
            case AnimalType.Donkey -> {
                return new Donkey(counter.addCurrentId(), name, dateOfBirth, gender, breed);
            }
        }
        return null;
    }

    public AnimalRegistry generateRegistry() {
        AnimalRegistry reg = new AnimalRegistry();

        Dog dog1 = new Dog(counter.addCurrentId(), "Canela", LocalDate.of(2018, 11, 5), Gender.Female, "pudel");
        reg.addAnimal(dog1);

        Donkey donkey1 = new Donkey(counter.addCurrentId(),"Beauty", LocalDate.of(2020, 5, 18), Gender.Female, "hardworker");
        reg.addAnimal(donkey1);

        Camel camel1 = new Camel(counter.addCurrentId(),"Mehmed", LocalDate.of(2014, 2, 18), Gender.Male, "nearestern");
        reg.addAnimal(camel1);

        Camel camel2 = new Camel(counter.addCurrentId(),"Ahmed", LocalDate.of(2022, 1, 10), Gender.Male, "persian");
        reg.addAnimal(camel2);

        Cat cat1 = new Cat(counter.addCurrentId(),"Teo", LocalDate.of(2021, 1, 16), Gender.Male, "european");
        reg.addAnimal(cat1);

        Hamster hamster1 = new Hamster(counter.addCurrentId(),"Pepe", LocalDate.of(2023, 10, 11), Gender.Female, "eastern_piggy");
        reg.addAnimal(hamster1);

        Horse horse1 = new Horse(counter.addCurrentId(),"Halk", LocalDate.of(2019, 5, 27), Gender.Male, "strongest");
        reg.addAnimal(horse1);

        Dog dog2 = new Dog(counter.addCurrentId(),"Charli", LocalDate.of(2019, 7, 1), Gender.Male, "rotweiler");
        reg.addAnimal(dog2);

        Horse horse2 = new Horse(counter.addCurrentId(),"Juanita", LocalDate.of(2022, 12, 25), Gender.Female, "spanish");
        reg.addAnimal(horse2);

        Cat cat2 = new Cat(counter.addCurrentId(),"Markiz", LocalDate.of(2015, 8, 25), Gender.Male, "siam");
        reg.addAnimal(cat2);

        Hamster hamster2 = new Hamster(counter.addCurrentId(),"Chichi", LocalDate.of(2022, 12, 25), Gender.Male, "western_piggy");
        reg.addAnimal(hamster2);

        Donkey donkey2 = new Donkey(counter.addCurrentId(),"Armagedon", LocalDate.of(2020, 3, 3), Gender.Male, "hardworker");
        reg.addAnimal(donkey2);

        Cat cat3 = new Cat(counter.addCurrentId(),"Philip", LocalDate.of(2013, 7, 10), Gender.Male, "maykun");
        reg.addAnimal(cat3);

        Camel camel3 = new Camel(counter.addCurrentId(),"Sultan", LocalDate.of(2017, 4, 1), Gender.Male, "african");
        reg.addAnimal(camel3);

        Camel camel4 = new Camel(counter.addCurrentId(),"Kebaba", LocalDate.of(2019, 6, 30), Gender.Female, "african");
        reg.addAnimal(camel4);

        Dog dog3 = new Dog(counter.addCurrentId(),"Hatiko", LocalDate.of(2021, 3, 7), Gender.Male, "haski");
        reg.addAnimal(dog3);

        return reg;
    }
}