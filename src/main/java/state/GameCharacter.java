package state;

public class GameCharacter {
    private final String name;
    private int experience;
    private int health;
    private State state;

    public GameCharacter(String name) {
        this.name = name;
        this.experience = 0;
        this.health = 100;
        this.state = new NoviceState();
    }

    public String getName() {
        return name;
    }

    public int getExperience() {
        return experience;
    }

    public int getHealth() {
        return health;
    }

    public void addExperience(int xp) {
        experience += xp;
    }

    public void addHealth(int hp) {
        health += hp;
    }

    public void reduceHp(int hp) {
        if (hp > health) {
            hp = health;
        }
        health -= hp;
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public void train() {
        state.train(this);
    }

    public void meditate() {
        state.meditate(this);
    }

    public void fight() {
        state.fight(this);
    }

    public boolean isAlive() {
        return health > 0;
    }

    public void displayStatus() {
        System.out.println("=== Player status ===");
        System.out.println("Name: " + TextColor.BLUE + name + TextColor.RESET);
        System.out.println("Experience: " + TextColor.GREEN + experience + TextColor.RESET);
        System.out.println("Health: " + TextColor.GREEN + health + TextColor.RESET);
        System.out.println("Level: " + TextColor.GREEN + state.getLevelName() + TextColor.RESET);
    }

}
