// Room.java

import java.util.HashMap;

public class Room {
    private String description; // Room desc.
    private String flavorText; // Text that displays on first entry
    private HashMap<String, Room> exits; // Room exits
    private boolean visited; // Tracks if player has been here before
    private boolean isPuzzleRoom; // Flags if room has riddle


    public Room(String description, String flavorText, boolean isPuzzleRoom) {
        this.description = description;
        this.flavorText = flavorText;
        this.exits = new HashMap<>();
        this.isPuzzleRoom = isPuzzleRoom;
        this.visited = false; 
    }
    // Set exit
    public void setExit(String direction, Room neighbor) {
        exits.put(direction, neighbor); 
    }
    // Get exit
    public Room getExit(String direction) {
        return exits.get(direction);
    }

    // Get desc.
    public String getDescription() {
        return description;
    }
    // Get flavor text
    public String getFlavorText() {
        return flavorText;
    }

    // Lists exits for players
    public String getExitString() {
        String returnString = "ACTIONS: ";

        for (String exit : exits.keySet()) {
            returnString += exit + "  ";
        }
        return returnString;
    }

    // Puzzle room status
    public boolean isPuzzleRoom() {
        return isPuzzleRoom;
    }

    // Visited status
    public boolean hasBeenVisited() {
        return visited;
    }
    public void markAsVisited() {
        this.visited = true;
    }
}
