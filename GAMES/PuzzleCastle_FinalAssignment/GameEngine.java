import java.util.Scanner;

public class GameEngine {

    // ---- FOR COLORED TEXT ----
    public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";


    // ---- CORE ----
    private Player player;
    private World world;
    private boolean running;
    private Room currentRoom;

    private int mistakes = 0;
    private int puzzlesSolved = 0;

    private final int MAX_MISTAKES = 3;
    private final int TOTAL_PUZZLES = 6;

    // ---- MAIN ---
    public static void main(String[] args) {
        GameEngine game = new GameEngine();
        
        game.start();
    }

    // --- CONSTRUCTOR ----
    public GameEngine() {
        player = new Player();
        world = new World();
        running = true;
        currentRoom = world.getStartingRoom();
    }

    // ----GAME START ----
    public void start() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("It was supposed to be a night like any other.");
        pause(scanner);

        System.out.println("It was the eve of the Harvest Festival. You, a knight, were tasked with escorting the princess down from the castle so she could make her customary appearance.");
        System.out.println("It was not a long trip, only a days ride on horseback from the castle to the village. ");
        System.out.println("You and the princess were about halfway there, walking your horses down the forest path when all of a sudden…");
        pause(scanner);

        System.out.println("BOOM! An explosion.");
        System.out.println("Your horses startle and run off down the path, trees come crashing down around you from the force of the blast.");
        System.out.println("In all the chaos, you lose sight of the princess.");
        System.out.println("You look around frantically, trying to catch sight of her.");
        pause(scanner);

        System.out.println("BANG! Another explosion.");
        System.out.println("This one knocks you to the ground.");
        System.out.println("You hit your head on something hard as you fall.");
        System.out.println("The last thing you see before everything goes dark is a figure approaching from the distance...");
        pause(scanner);

        // Everything before this line with castle background

        // Black screen

        System.out.println("...");
        pause(scanner);

        System.out.println("...");
        pause(scanner);

        // Startng room background starts here

        System.out.println("Feeling comes to you before anything else.");
        System.out.println("You are lying on... something. Hard and cold. Wood, perhaps?");
        System.out.println("Whatever it is, laying on it is not helping your aching body.");
        System.out.println("You try to recall how you ended up here.");
        System.out.println("You were walking through the forest on the way to the festival and...");
        pause(scanner);

        System.out.println("The princess!");
        pause(scanner);

        System.out.println("You quickly right yourself, opening your eyes to look around the room.");
        System.out.println("The room you find yourself in is mostly empty. Nothing but a couple of boxes leaned against one of the walls. ");
        pause(scanner);

        System.out.println(ANSI_PURPLE + "\"Hey, you. You're finally awake.\"" + ANSI_RESET);
        pause(scanner);

        System.out.println("Wh- who was that?");
        System.out.println("You look around the room again. As far as you can see you're all alone.");
        pause(scanner);

        System.out.println(ANSI_PURPLE + "\"Hey! Over here!\"" + ANSI_RESET);
        pause(scanner); 

        System.out.println("You look towards the sound of the voice. All you see are the boxes in the corner and...");
        pause(scanner);

        System.out.println("Wait is that a rat");
        pause(scanner);

        System.out.println("Sat on top of the larger of the two boxes is a rat of considerable size.");
        System.out.println("It's staring right at you.");
        pause(scanner);
        System.out.println("Did... did the rat just talk to you?");
        System.out.println("Maybe you hit your head harder than you thought.");
        pause(scanner);

        System.out.println(ANSI_PURPLE + "\"Yeah, you! Who else would I be talking to. How'd you end up here?\"" + ANSI_RESET);
        pause(scanner);

        System.out.println("The rat seems annoyed at being overlooked by you.");
        System.out.println("But why would you expect a rat to suddenly start making converstaion with you!?");
        pause(scanner);
        System.out.println("Oh well. You figure this is not the time to be getting caught up on the concept of a talking rat when the princess of the realm has gone missing on your watch.");
        System.out.println("You explain to the rat everything that happened.");
        System.out.println("The festival, the explosions, the missing princess...");
        pause(scanner);

        System.out.println(ANSI_PURPLE  + "\"Wow. That sounds a little extreme, even for the Puzzle Freak.\"" + ANSI_RESET);
        pause(scanner);
        System.out.println("The... who?");
        pause(scanner);
        System.out.println("The rat seems to ponder for a moment");
        pause(scanner);
        System.out.println(ANSI_PURPLE + "\"No matter. The princess is most likely somehwere here. This is the Puzzle Freak's castle of puzzles.\"" + ANSI_RESET);
        pause(scanner);
        System.out.println(ANSI_PURPLE + "\"I'm sure he just wanted someone to test his new riddles. And holding you princess hostage gives you an incentive to do that.\"" + ANSI_RESET);
        pause(scanner);

        System.out.println("Well that's... unortahdox. But once again, you don't exactly have time to get caught up on the details.");
        System.out.println("You know where the princess is now.");
        pause(scanner);
        System.out.println("Somewhat.");
        pause(scanner);
        System.out.println("And this \"Puzzle Freak\"... ");
        System.err.println("Sure sounds like a freak to you, kidnapping people and making them do puzzles!");
        pause(scanner);

        System.out.println(ANSI_PURPLE + "\"Do you have a name, knight?\"" + ANSI_RESET);
        pause(scanner);
        
        // NAME
        System.out.println("Enter your name");
        System.out.print("> ");

        String name = scanner.nextLine().trim();
        player.setName(name.isEmpty() ? "Nameless One" : name);

        System.out.println(ANSI_PURPLE + "\n\"Well then, " + player.getName() + ", let's go find this princess of yours.\"" + ANSI_RESET);
        pause(scanner);

        System.out.println("...");
        pause(scanner);

       
       
        // ---------------- MAIN LOOP ----------------
        while (running) {
        
            System.out.println(" ");
            if (currentRoom.getDescription().contains("final room")) {
                
            } else {
                System.out.println("You are in " + currentRoom.getDescription());
                pause(scanner);
            }

            if (!currentRoom.hasBeenVisited()) {
                System.out.println(currentRoom.getFlavorText());
                pause(scanner);
                // Marks room as visited
                currentRoom.markAsVisited();
            }
            // Triggers riddle
            if (currentRoom.isPuzzleRoom() && puzzlesSolved < TOTAL_PUZZLES) {
                int currentSolved = puzzlesSolved;
                while (currentRoom.isPuzzleRoom() && puzzlesSolved == currentSolved && running) {
                    System.out.println("You approach the riddle. It reads: ");
                    askRiddle(scanner);
                }

                if (!running) break;
            }

            // Triggers final room
            if (puzzlesSolved >= TOTAL_PUZZLES && currentRoom.getDescription().contains("final room")) {
                finalRoom(scanner);

            // Navigation 
            } else {
            System.out.println("Where to go?");
            System.out.println(currentRoom.getExitString());
            System.out.print("> ");
            String command = scanner.nextLine().trim().toLowerCase();

            if (command.equals("quit")) {
                running = false;
            } else { 
                movePlayer(command);
            }
            }

        }
    }

    // ----RIDDLE SYSTEM ------
    private void askRiddle(Scanner scanner) {

        String question;
        String answer;

        if (puzzlesSolved == 0) {
            question = "I speak without a mouth and hear without ears. What am I?";
            answer = "echo";
        } 
        else if (puzzlesSolved == 1) {
            question = "The more you take, the more you leave behind. What are they?";
            answer = "footsteps";
        } 
        else if (puzzlesSolved == 2) {
            question = "I have one eye but am unable to see. What am I?";
            answer = "needle";
        }
        else if (puzzlesSolved == 3) {
            question = "What goes through cities and fields, but never moves? ";
            answer = "road";
        }
        else if (puzzlesSolved == 4) {
            question = "What starts with T, ends with T, and has T in it?";
            answer = "teapot";
        }
        else {
            question = "What has to be broken before you can use it?";
            answer = "egg";
        }

        System.out.println(question);
        System.out.println("(type answer or HINT)");
        System.out.print("> ");

        String guess = scanner.nextLine().trim().toLowerCase();

        // --HINT ---
        if (guess.equals("hint")) {
            giveHint(answer);
            System.out.print("\nYour answer > ");
            guess = scanner.nextLine().trim().toLowerCase();
        }

        // ---- CHECK ----
        if (guess.equals(answer)) {

            System.out.println("\nCorrect.");
            System.out.println("A key falls from the ceiling!");
            System.out.println("The rat pickes it up for you.");

            puzzlesSolved++;
            player.addKey();

            System.out.println("Keys collected: " + player.getKeys());
            System.out.println("");

        } else {

            mistakes++;

            System.out.println("\nWrong.");

            if (mistakes == 1) {
                System.out.println("\"Careful...\"");
                
            } 
            else if (mistakes == 2) {
                System.out.println("\"One more mistake...\"");
                
            }

            if (mistakes < MAX_MISTAKES) {
                System.out.println("Try again.");
            } else {
                gameOver(scanner);
            }
        }
    }

    // ---HINT SYSTEM ---
    private void giveHint(String answer) {

        System.out.println("\n--- HINT ---");

        System.out.println("Starts with: " + answer.charAt(0));
        System.out.println("Ends with: " + answer.charAt(answer.length() - 1));
        System.out.println("Length: " + answer.length());

        System.out.println("\nChoices:");

        if (answer.equals("echo")) {
            System.out.println("A) echo  B) voice  C) sound");
        } 
        else if (answer.equals("footsteps")) {
            System.out.println("A) shadows  B) footsteps  C) marks");
        } 
        else if (answer.equals("needle")) {
            System.out.println("A) blind cyclops  B) the alphabet  C) needle");
        }
        else if (answer.equals("road")) {
             System.out.println("A) river  B) road  C) wind");
        }
        else if (answer.equals("teapot")) {
             System.out.println("A) teapot  B) toilet  C) testement");
        }
        else if (answer.equals("egg")) {
            System.out.println("A) glass  B) egg  C) stone");
        }
    }

    // ---FINAL ROOM ---
    private void finalRoom(Scanner scanner) {

        
        System.out.println("You stand before the final door.");

        if (player.getKeys() < TOTAL_PUZZLES) {
            System.out.println("You don't have enough keys...");
            gameOver(scanner);
            return;
        }

        System.out.println("The rat climbs up your armor ro hand you all the keys you've collected.");
        pause(scanner);
        System.out.println("You insert each key into the holes on the door.");
        pause(scanner);
        System.out.println("CLICK! The door opens");
        pause(scanner);
        System.out.println("Upon entering the room you see, behind the bars of a jail cel...");
        pause(scanner);
        System.out.println("The Princess! She's alright!");
        pause(scanner);
        System.out.println(ANSI_CYAN + "\"" + player.getName() + "! You made it!\"" + ANSI_RESET);
        pause(scanner);
        System.out.println(ANSI_CYAN + "\"Quick, there's a riddle written on the floor. Figure it out and get me out of here before that werid guy comes back!\"" + ANSI_RESET);
        pause(scanner);
        System.out.println("You step further into the room to see the riddle");
        System.out.println(" ");

        System.out.println("The final riddle reads: ");
        System.out.println("If you throw me from the window, I will leave a grieving wife. Bring me back, but in the door, and You'll see someone giving life! What am I?");
        System.out.print("> ");

        String answer = scanner.nextLine();

        if (answer.equals("n")) {

            System.out.println("\nTHe door to the cell swings open.");
            System.out.println("YOU SAVED THE PRINCESS!");
            System.out.println("YOU WIN !!!");

            running = false;

        } else {

            mistakes++;
            System.out.println("\nWrong...");
            System.out.println("\n--- HINT ---");
            System.out.println("A letter between K and Q");

            if (mistakes >= MAX_MISTAKES) {
                gameOver(scanner);
            }
        }
    }

    // ---- PLAYER MOVEMENT ---
    private void movePlayer(String direction) {
        Room nextRoom = currentRoom.getExit(direction);
        if (nextRoom != null) {
        currentRoom = nextRoom;
        } else {
        System.out.println("\n[!] You can't go that way.");
    }
    }

    // ---- GAME OVER ---
    private void gameOver(Scanner scanner) {

        System.out.println("\nYou failed.");
        System.out.println("Type RESTART or QUIT");
        System.out.print("> ");

        String choice = scanner.nextLine().toLowerCase();

        if (choice.equals("restart")) {

            world.generateWorld();
            this.currentRoom = world.getStartingRoom();

            mistakes = 0;
            puzzlesSolved = 0;
            player.resetKeys();

            System.out.println("\nThe castle resets...\n");
            System.out.println("You are in " + currentRoom.getDescription());
            pause(scanner);

        } else {

            System.out.println("Game Over.");
            running = false;
        }
    }

    // ----PAUSE ---
    private void pause(Scanner scanner) {
        System.out.println("(Press Enter)");
        scanner.nextLine();
    }
}    
