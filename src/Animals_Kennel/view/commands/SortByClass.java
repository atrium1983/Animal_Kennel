package Animals_Kennel.view.commands;

import Animals_Kennel.view.ConsoleUI;

public class SortByClass extends Command{
    public SortByClass(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Выполнить сортировку по классам";
    }

    @Override
    public void execute() {
        consoleUI.sortByClass();
    }
}
