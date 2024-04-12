package Animals_Kennel.view.commands;

import Animals_Kennel.view.ConsoleUI;

public class Save extends Command {
    public Save(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Сохранить изменения";
    }

    @Override
    public void execute() {
        consoleUI.save();
    }
}
