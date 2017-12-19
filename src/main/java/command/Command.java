package command;

import java.util.Scanner;

public interface Command {
    Scanner scanner = new Scanner(System.in);

    public void execute();
}
