package Animals_Kennel.view.commands;

import Animals_Kennel.view.ConsoleUI;

public class SortById extends Command{
    public SortById(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Выполнить сортировку по ID";
    }

    @Override
    public void execute() {
        consoleUI.sortById();
    }
}
