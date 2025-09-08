package state;

import org.w3c.dom.Text;

public class ExpertState implements State {
    @Override
    public void train(GameCharacter character) {
        System.out.println(TextColor.BLUE + character.getName() + TextColor.RESET + " trained and gained 12 xp!");
        character.addExperience(25);
        if (character.getExperience() > 220) {
            System.out.println("Level up! " + TextColor.BLUE + character.getName() + TextColor.RESET + " is now Expert level!");
            character.setState(new MasterState());
        }
    }

    @Override
    public void meditate(GameCharacter character) {
        System.out.println(TextColor.BLUE + character.getName() + TextColor.RESET + " meditates and gains " + TextColor.GREEN + "10" + TextColor.RESET + " hp!");
        character.addHealth(10);
    }

    @Override
    public void fight(GameCharacter character) {
        int damage = 45;
        int healthLoss = Math.min(damage, character.getHealth());

        character.reduceHp(damage);

        // Check if player's health dropped to 0. If dead, the player does not gain xp.
        if (character.getHealth() <= 0) {
            System.out.println(TextColor.BLUE + character.getName() + TextColor.RESET + " fought, lost " + TextColor.RED + healthLoss + TextColor.RESET + " hp and has fallen in battle!");
            return;
        }

        System.out.println(TextColor.BLUE + character.getName() + TextColor.RESET + " fought, lost " + TextColor.RED + healthLoss + TextColor.RESET + " hp and gained " + TextColor.GREEN + "47" + TextColor.RESET + " xp!");
        character.addExperience(47);

        if (character.getExperience() > 220) {
            System.out.println("Level up! " + character.getName() + " is now " + TextColor.GREEN + "Master" + TextColor.RESET + " level!");
            character.setState(new MasterState());
        }
    }

    @Override
    public String getLevelName() {
        return "Expert";
    }
}
