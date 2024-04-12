package Animals_Kennel.model.service;

import Animals_Kennel.model.animal.*;
import Animals_Kennel.model.animalRegister.AnimalRegistry;
import Animals_Kennel.model.builder.RegistryBuilder;
import Animals_Kennel.model.writer.Writable;

import java.time.LocalDate;
import java.util.ArrayList;

public class Service {

    private AnimalRegistry registry;
    private RegistryBuilder builder;
    Writable writable;

    public Service() {
        registry = new AnimalRegistry();
        builder = new RegistryBuilder();
    }

    public void save(){
        writable.save(registry);
    }

    public void load(){
        registry = (AnimalRegistry) writable.read();
    }
    public void setWritable(Writable writable) {
        this.writable = writable;
    }

    public void sortById(){
        registry.sortById();
    }

    public void sortByType(){
        registry.sortByType();
    }

    public void sortByClass(){
        registry.sortByClass();
    }

    public void addAnimal(String name, LocalDate dateOfBirth, Gender gender, AnimalClass animalClass, AnimalType animalType, String breed){
        Animal animal = builder.addAnimal(name, dateOfBirth, gender, animalClass, animalType, breed);
        registry.addAnimal(animal);
    }

    public void generateRegistry(){
        registry = builder.generateRegistry();
    }

    public String printFullInfo() {
        return registry.getInfo();
    }

    public String printAnimalInfo(int id) {
        return registry.getAnimalInfo(id);
    }

    public boolean findById(int id){
        return registry.getById(id) != null;
    }

    public boolean addCommand(int id, Commands command){
        Animal animal = registry.getById(id);
        return animal.addCommand(command);
    }

    public ArrayList printCommands(int id){
        Animal animal = registry.getById(id);
        return animal.getCommands();
    }
}
