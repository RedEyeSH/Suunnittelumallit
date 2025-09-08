package state;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your character name: ");
        String name = scanner.nextLine();
        GameCharacter character = new GameCharacter(name);

        while (character.isAlive() && !(character.getState() instanceof MasterState)) {
            character.displayStatus();

            System.out.print("Choose action (" + TextColor.GREEN + "train" + TextColor.RESET + "/" + TextColor.GREEN + "meditate" + TextColor.RESET + "/" + TextColor.GREEN + "fight" + TextColor.RESET + "): ");
            String action = scanner.nextLine().toLowerCase();
            System.out.println();

            switch (action) {
                case "train":
                    character.train();
                    break;
                case "meditate":
                    character.meditate();
                    break;
                case "fight":
                    character.fight();
                    break;
                default:
                    System.out.println(TextColor.RED + "Invalid action. Try again." + TextColor.RESET);
            }
            System.out.println();
        }

        character.displayStatus();
        System.out.println();

        if (!character.isAlive()) {
            System.out.println(TextColor.BLUE + character.getName() + TextColor.RESET + " has fallen in battle. Game Over!");
        } else {
            System.out.println("Congratulations! " + TextColor.GREEN + character.getName() + TextColor.RESET + " has reached " + TextColor.GREEN + "Master" + TextColor.RESET + " level. Game Over.");
        }
    }
}
