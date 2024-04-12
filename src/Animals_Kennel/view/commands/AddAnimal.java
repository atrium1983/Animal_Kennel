package Animals_Kennel.view.commands;

import Animals_Kennel.view.ConsoleUI;

public class AddAnimal extends Command{
    public AddAnimal(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить животное";
    }

    @Override
    public void execute() {
        consoleUI.addAnimal();
    }
}
