package Animals_Kennel;

import Animals_Kennel.model.writer.FileHandler;
import Animals_Kennel.view.ConsoleUI;

public class Main {
    public static void main(String[] args) {
        ConsoleUI consoleUI = new ConsoleUI();
        consoleUI.setWritable(new FileHandler());
        consoleUI.start();
    }
}