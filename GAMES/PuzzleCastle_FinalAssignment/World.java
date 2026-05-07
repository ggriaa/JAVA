//World.java

public class World {

	// ---- FOR COLORED TEXT ----
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_PURPLE = "\u001B[35m";

	public Room startingRoom;

	public World() {
		generateWorld();
	}

	public void generateWorld() {

		// Creates rooms
		Room start = new Room("the room you woke up in", ANSI_PURPLE + "\"Lead the way,\"" + ANSI_RESET, false);
		Room hallway = new Room("a hallway with three doors on each side and one at the end.", ANSI_PURPLE + "\"This is the puzzle hallway.\" \n \n\"Each of these rooms will give you one key to open the door at the end.\" \n \n\"There, you'll be able to talk to the Puzzle Freak.\" " + ANSI_RESET, false);
		Room room1 = new Room("the first room to the right", "You look around. It's a more decorated room than the one you first woke up in. \nThere's a riddle written on the back wall.", true);
		Room room2 = new Room("the first room to the left", "It's a room decorated about the same as the rest, this time orange. \nThere's a riddle written on the back wall.", true);
		Room room3 = new Room("the second room to the right", "It's a room decorated about the same as the rest, this time yellow. \nThere's a riddle written on the back wall.", true);
		Room room4 = new Room("the second room to the left", "It's a room decorated about the same as the rest, this time green. \nThere's a riddle written on the back wall.", true);
		Room room5 = new Room("the third room to the right", "It's a room decorated about the same as the rest, this time blue. \nThere's a riddle written on the back wall.", true);
		Room room6 = new Room("the third room to the left", "It's a room decorated about the same as the rest, this time purple. \nThere's a riddle written on the back wall.", true);
		Room finalRoom = new Room("the final room.", "...", false);

	
		// ---- EXITS ---
		// Main path
		start.setExit("exit", hallway);
		hallway.setExit("end", finalRoom);

		// Side rooms
		hallway.setExit("right1", room1);
		room1.setExit("back", hallway);

		hallway.setExit("left1", room2);
		room2.setExit("back", hallway);

		hallway.setExit("right2", room3);
		room3.setExit("back", hallway);

		hallway.setExit("left2", room4);
		room4.setExit("back", hallway);

		hallway.setExit("right3", room5);
		room5.setExit("back", hallway);

		hallway.setExit("left3", room6);
		room6.setExit("back", hallway);

		// Spawn point
		this.startingRoom = start;

	}

	public Room getStartingRoom() {
		return startingRoom;
}


}
