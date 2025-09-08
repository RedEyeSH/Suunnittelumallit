package state;

public class MasterState implements State {
    @Override
    public void train(GameCharacter character) {
        System.out.println("Game Over! " + character.getName() + " has already reached Master level!");
    }

    @Override
    public void meditate(GameCharacter character) {
        System.out.println("Game Over! " + character.getName() + " has already reached Master level!");
    }

    @Override
    public void fight(GameCharacter character) {
        System.out.println("Game Over! " + character.getName() + " has already reached Master level!");
    }

    @Override
    public String getLevelName() {
        return "Master";
    }
}
