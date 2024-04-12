package Animals_Kennel.view.commands;

import Animals_Kennel.view.ConsoleUI;

public class PrintCommands extends Command{
    public PrintCommands(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Показать команды, которым обучено животное";
    }

    @Override
    public void execute() {
        consoleUI.printCommands();
    }
}
