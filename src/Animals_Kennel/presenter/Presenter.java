package Animals_Kennel.presenter;

import Animals_Kennel.model.animal.AnimalClass;
import Animals_Kennel.model.animal.AnimalType;
import Animals_Kennel.model.animal.Commands;
import Animals_Kennel.model.animal.Gender;
import Animals_Kennel.model.service.Service;
import Animals_Kennel.model.writer.Writable;
import Animals_Kennel.view.ConsoleUI;

import java.time.LocalDate;
import java.util.ArrayList;

public class Presenter {

    private final ConsoleUI view;
    private final Service service;
    private final String positive = "Успешно!\n";

    public Presenter (ConsoleUI view){
        this.view = view;
        service = new Service();
    }

    public void save(){
        service.save();
        view.answer(positive);
    }

    public void load(){
        service.load();
        view.answer(positive);
    }

    public void sortByClass(){
        service.sortByClass();
        print();
    }
    public void sortByType(){
        service.sortByType();
        print();
    }
    public void sortById(){
        service.sortById();
        print();
    }
    public void addAnimal(String name, LocalDate dateOfBirth, Gender gender, AnimalClass animalClass, AnimalType animalType, String breed){
        service.addAnimal(name, dateOfBirth, gender, animalClass, animalType, breed);
        view.answer(positive);
        print();
    }
    public void generateRegistry(){
        service.generateRegistry();
        print();
    }
    public void print(){
        view.answer(service.printFullInfo());
    }

    public void printById(int id){
        view.answer(service.printAnimalInfo(id));
    }

    public boolean findById(int id){
        return service.findById(id);
    }

    public boolean addCommand(int id, Commands command){
        return service.addCommand(id, command);
    }

    public ArrayList printCommands(int id){
        return service.printCommands(id);
    }

    public void setWritable(Writable writable) {
        service.setWritable(writable);
    }
}

