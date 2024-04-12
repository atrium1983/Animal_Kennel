package Animals_Kennel.view.commands;

import Animals_Kennel.view.ConsoleUI;

public class GenerateRegistry extends Command{
    public GenerateRegistry(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Сгенерировать реестр животных";
    }

    @Override
    public void execute() {
        consoleUI.generateRegistry();
    }
}
