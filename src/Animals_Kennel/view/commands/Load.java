package Animals_Kennel.view.commands;

import Animals_Kennel.view.ConsoleUI;

public class Load extends Command{
    public Load(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Загрузить ранее сохраненный реестр";
    }

    @Override
    public void execute() {
        consoleUI.load();
    }
}
