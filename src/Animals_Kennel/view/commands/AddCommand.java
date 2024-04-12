package Animals_Kennel.view.commands;

import Animals_Kennel.view.ConsoleUI;

public class AddCommand extends Command{
    public AddCommand(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Научить животное новым командам";
    }

    @Override
    public void execute() {
        consoleUI.addCommand();
    }
}
