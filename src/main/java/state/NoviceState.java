package state;

public class NoviceState implements State {
    @Override
    public void train(GameCharacter character) {
        System.out.println(TextColor.BLUE + character.getName() + TextColor.RESET + " trained and gained " + TextColor.GREEN + "5" + TextColor.RESET +" xp!");
        character.addExperience(5);
        if (character.getExperience() > 24) {
            System.out.println("Level up! "+  TextColor.BLUE + character.getName() + TextColor.RESET + " is now " + TextColor.GREEN + "Intermediate" + TextColor.RESET + " level!");
            character.setState(new IntermediateState());
        }
    }

    @Override
    public void meditate(GameCharacter character) {
        System.out.println(TextColor.RED + "Meditating is not available!" + TextColor.RESET);
    }

    @Override
    public void fight(GameCharacter character) {
        System.out.println(TextColor.RED + "Fighting is not available!" + TextColor.RESET);
    }

    @Override
    public String getLevelName() {
        return "Novice";
    }
}
