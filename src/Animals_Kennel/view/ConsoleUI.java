package Animals_Kennel.view;

import Animals_Kennel.model.animal.AnimalClass;
import Animals_Kennel.model.animal.AnimalType;
import Animals_Kennel.model.animal.Commands;
import Animals_Kennel.model.animal.Gender;
import Animals_Kennel.model.writer.Writable;
import Animals_Kennel.presenter.Presenter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleUI {

    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private MainMenu menu;
    private String error = "Ошибка!";

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        menu = new MainMenu(this);
    }

    public void start() {
        hello();
        while (work){
            printMenu();
            execute();
        }
    }

    private void hello() {
        answer("Добро пожаловать в систему учёта животных в питомнике!");
    }

    public void finish() {
        answer("Сеанс завершен. До свидания!");
        work = false;
        scanner.close();
    }

    private void printMenu(){
        answer(menu.getMenu());
    }

    public void printRegistry(){
        presenter.print();
    }

    public void generateRegistry(){
        presenter.generateRegistry();
    }

    public void answer(String text) {
        System.out.println(text);
    }

    public void addAnimal(){
        answer("Введите имя питомца: ");
        String name = scanner.nextLine();
        answer("Введите дату рождения");
        LocalDate dateOfBirth = getDate();
        answer("Выберите пол : 1. Мужской, 2. Женский : ");
        String g = scanner.nextLine();
        Gender gender = putGender(g);
        answer("Выберите класс животного: 1. Домашнее, 2. Вьючное : ");
        String cl = scanner.nextLine();
        AnimalClass animalClass = putClass(cl);
        if (cl.equals("1")) {
            answer("Выберите вид животного: 1. Собака, 2. Кот, 3. Хомяк : ");
        }
        if (cl.equals("2")) {
            answer("Выберите вид животного: 1. Лощадь, 2. Верблюд, 3. Осёл : ");
        }
        String type = scanner.nextLine();
        AnimalType animalType = putType(cl, type);
        answer("Введите название породы питомца: ");
        String breed = scanner.nextLine();
        presenter.addAnimal(name, dateOfBirth, gender, animalClass, animalType, breed);
    }

    private LocalDate getDate() {
        boolean flag = true;
        LocalDate date = null;
        while (flag) {
            answer("Формат ввода ГГГГ-ММ-ДД (пример: 2000-05-25)");
            flag = false;
            try {
                date = LocalDate.parse(scanner.nextLine());
            } catch (Exception e) {
                answer("Вы ввели неверную дату повторите ввод");
                flag = true;
            }
        }
        return date;
    }

    public Gender putGender(String answer) {
        Gender gender = null;
        if (answer.equals("1")){
            gender = Gender.Male;
        }
        if (answer.equals("2")){
            gender = Gender.Female;
        }
        return gender;
    }

    public AnimalClass putClass(String answer) {
        AnimalClass animalClass = null;
        if (answer.equals("1")){
            animalClass = AnimalClass.Pet;
        }
        if (answer.equals("2")){
            animalClass = AnimalClass.PackAnimal;
        }
        return animalClass;
    }

    public AnimalType putType(String cl, String type) {
        AnimalType animalType = null;
        if (cl.equals("1") && type.equals("1")){
            animalType = AnimalType.Dog;
        }
        if (cl.equals("1") && type.equals("2")) {
            animalType = AnimalType.Cat;
        }
        if (cl.equals("1") && type.equals("3")){
            animalType = AnimalType.Hamster;
        }
        if (cl.equals("2") && type.equals("1")){
            animalType = AnimalType.Horse;
        }
        if (cl.equals("2") && type.equals("2")) {
            animalType = AnimalType.Camel;
        }
        if (cl.equals("2") && type.equals("3")){
            animalType = AnimalType.Donkey;
        }
        return animalType;
    }

    private void execute(){
        String input = scanner.nextLine();
        if (checkIfInt(input)){
            int numCommand = Integer.parseInt(input);
            if (checkCommand(numCommand)){
                menu.execute(numCommand);
            }
        }
    }

    private boolean checkIfInt(String text){
        if (text.matches("[0-9]+")){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private boolean checkCommand(int numCommand){
        if (numCommand <= menu.getSize()){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private int checkId(String id){
        if (checkIfInt(id)) {
            int intId = Integer.parseInt(id);
            if (findById(intId)) {
                return intId;
            }
        }
        return -1;
    }

    private boolean findById(int id){
        return presenter.findById(id);
    }

    private void inputError(){
        System.out.println(error);
    }

    public void sortByClass(){
        presenter.sortByClass();
    }

    public void sortById(){
        presenter.sortById();
    }

    public void sortByType(){
        presenter.sortByType();
    }

    public void load(){
        presenter.load();
    }

    public void save(){
        presenter.save();
    }

    public void addCommand(){
        answer("Введите ID питомца, которого Вы хотите обучить: ");
        int animalId = checkId(scanner.nextLine());
        if (animalId>=0){
            Commands command = chooseCommand();
            presenter.addCommand(animalId, command);
        } else {
            answer(error);
        }
    }

    public Commands chooseCommand(){
        answer("Выберите команду:");
        answer("1.Call, 2.Go, 3.Run, 4.Lie, 5.Faster, 6.Eat, 7.Stop, 8.Play");
        String input = scanner.nextLine();
        if (checkIfInt(input)) {
            int numCommand = Integer.parseInt(input);
            switch (numCommand){
                case 1 -> {
                    return Commands.Call;
                }
                case 2 -> {
                    return Commands.Go;
                }
                case 3 -> {
                    return Commands.Run;
                }
                case 4 -> {
                    return Commands.Lie;
                }
                case 5 -> {
                    return Commands.Faster;
                }
                case 6 -> {
                    return Commands.Eat;
                }
                case 7 -> {
                    return Commands.Stop;
                }
                case 8 -> {
                    return Commands.Play;
                }
            }
        }
        return null;
    }

    public void printCommands(){
        answer("Введите ID питомца: ");
        int animalId = checkId(scanner.nextLine());
        if (animalId>=0){
            ArrayList commands = presenter.printCommands(animalId);
            if(commands.size() != 0) {
                answer("Питомец знает следующие команды: ");
                answer(commands.toString().replace("[","").replace("]",""));
            } else {
                answer("Выбранный питомец не обучен командам");
            }
        } else {
            answer(error);
        }
    }

    public void setWritable(Writable writable) {
        presenter.setWritable(writable);
    }
}
