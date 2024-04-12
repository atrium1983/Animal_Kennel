package Animals_Kennel.view.commands;

import Animals_Kennel.view.ConsoleUI;

public class PrintInfo extends Command{
    public PrintInfo(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Показать реестр животных";
    }

    @Override
    public void execute() {
        consoleUI.printRegistry();
    }
}
