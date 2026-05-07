// Player.java

public class Player {

    // Fields
    private String name;
    private int failures;
    private int keys;

    // Constructor
    public Player() {
        name = "Unknown Knight";
        failures = 0;
        keys = 0;
    }

    // Name methods
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Failure methods
    public void addFailure() {
        failures++;
    }

    public int getFailures() {
        return failures;
    }

    public boolean hasLost() {
        return failures >= 3;
    }

    public void resetFailures() {
        failures = 0;
    }

    // Key methods
    public void addKey() {
        keys++;
    }

    public int getKeys() {
        return keys;
    }

    public boolean hasAllKeys() {
        return keys >= 6;
    }

    public void resetKeys() {
        keys = 0;
    }

    // Display player status
    public void showStatus() {
        System.out.println("Name: " + name);
        System.out.println("Keys: " + keys + "/6");
        System.out.println("Failures: " + failures + "/3");
    }
}
