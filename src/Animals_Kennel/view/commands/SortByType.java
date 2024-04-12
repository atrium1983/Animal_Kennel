package Animals_Kennel.view.commands;

import Animals_Kennel.view.ConsoleUI;

public class SortByType extends Command{
    public SortByType(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Выполнить сортировку по видам";
    }

    @Override
    public void execute() {
        consoleUI.sortByType();
    }
}
