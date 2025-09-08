package state;

public class IntermediateState implements State {
    @Override
    public void train(GameCharacter character) {
        System.out.println(TextColor.BLUE + character.getName() + TextColor.RESET + " trained and gained " + TextColor.GREEN + "12" + TextColor.RESET +" xp!");
        character.addExperience(12);
        if (character.getExperience() > 72) {
            System.out.println("Level up! " + TextColor.BLUE + character.getName() + TextColor.RESET + " is now " + TextColor.GREEN + "Expert" + TextColor.RESET + " level!");
            character.setState(new ExpertState());
        }
    }

    @Override
    public void meditate(GameCharacter character) {
        System.out.println(TextColor.BLUE + character.getName() + TextColor.RESET + " meditates and gains " + TextColor.GREEN + "5" + TextColor.RESET + " hp!");
        character.addHealth(5);
    }

    @Override
    public void fight(GameCharacter character) {
        System.out.println(TextColor.RED + "Fighting is not available!" + TextColor.RESET);
    }

    @Override
    public String getLevelName() {
        return "Intermediate";
    }
}
