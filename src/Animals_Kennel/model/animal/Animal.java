package Animals_Kennel.model.animal;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Animal implements Serializable {
    private int id;
    private String name;
    private LocalDate dateOfBirth;
    private Gender gender;
    private AnimalClass animalClass;
    private AnimalType animalType;
    private String breed;
    private ArrayList commands;

    public Animal(int id, String name, LocalDate dateOfBirth, Gender gender, AnimalClass animalClass, AnimalType animalType, String breed) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.animalClass = animalClass;
        this.animalType = animalType;
        this.breed = breed;
        commands = new ArrayList<>();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setAnimalClass(AnimalClass animalClass) {
        this.animalClass = animalClass;
    }

    public void setAnimalType(AnimalType animalType) {
        this.animalType = animalType;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void setCommands(ArrayList commands) {
        this.commands = commands;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public AnimalClass getAnimalClass() {
        return animalClass;
    }

    public AnimalType getAnimalType() {
        return animalType;
    }

    public String getBreed() {
        return breed;
    }

    public ArrayList getCommands() {
        return commands;
    }

    public boolean addCommand(Commands command) {
        if (!commands.contains(command)) {
            commands.add(command);
            return true;
        }
        return false;
    }

    public String getAge() {
        return Integer.toString(getPeriod(this.dateOfBirth, LocalDate.now()));
    }

    private int getPeriod(LocalDate start, LocalDate end) {
        Period difference = Period.between(start, end);
        return difference.getYears();
    }

    public String getInfo() {
        StringBuilder info = new StringBuilder();
        info.append("id: ");
        info.append(id);
        info.append(", имя: ");
        info.append(name);
        info.append(", дата рождения: ");
        info.append(getDateOfBirth());
        info.append(", возраст: ");
        info.append(getAge());
        info.append(", пол: ");
        info.append(getGender());
        info.append(", класс животного: ");
        info.append(getAnimalClass());
        info.append(", вид животного: ");
        info.append(getAnimalType());
        info.append(", порода: ");
        info.append(getBreed());
        info.append(", команды: ");
        info.append(getCommands());

        return info.toString();
    }

    @Override
    public String toString() {
        return getInfo().replace("[", "").replace("]", "");
    }
}
