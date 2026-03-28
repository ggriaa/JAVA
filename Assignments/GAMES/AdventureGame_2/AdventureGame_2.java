import java.util.Scanner;

public class AdventureGame_2 {

    static Scanner input = new Scanner(System.in);

    static String playerName;
    static int trust = 0;
    static int courage = 0;
    static boolean hasKey = false;
    static boolean knowsTruth = false;
    static boolean savedMira = false;

    public static void main(String[] args) {
        startGame();
    }

    public static void startGame() {
        System.out.println("======================================");
        System.out.println("        THE CITY OF GLASS");
        System.out.println("======================================");
        System.out.print("Enter your name: ");
        playerName = input.nextLine();

        System.out.println("\nYou wake up on a cold metal floor.");
        System.out.println("Your head is pounding. The last thing you remember is a voice saying:");
        System.out.println("\"Do not let them find out who you are.\"");
        System.out.println("\nRed emergency lights flash above you.");
        System.out.println("A steel door is slightly open.");
        System.out.println("Do you LEAVE the room or HIDE and wait?");

        String choice = input.nextLine().toLowerCase();

        if (choice.equals("leave")) {
            courage++;
            hallwayScene();
        } else if (choice.equals("hide")) {
            trust--;
            hidingScene();
        } else {
            invalidChoice();
            startGame();
        }
    }

    public static void hidingScene() {
        System.out.println("\nYou crouch behind a broken machine.");
        System.out.println("Footsteps approach.");
        System.out.println("A girl in a torn black jacket slips into the room.");
        System.out.println("She whispers, \"If you're awake, we need to go now.\"");
        System.out.println("Do you TRUST her or RUN from her?");

        String choice = input.nextLine().toLowerCase();

        if (choice.equals("trust")) {
            trust++;
            System.out.println("\nShe nods. \"Good. My name is Mira. They're searching the lower sector.\"");
            hallwayWithMira();
        } else if (choice.equals("run")) {
            courage++;
            System.out.println("\nYou bolt past her into the corridor.");
            hallwayScene();
        } else {
            invalidChoice();
            hidingScene();
        }
    }

    public static void hallwayScene() {
        System.out.println("\nThe hallway stretches in both directions.");
        System.out.println("To your LEFT, you hear distant alarms.");
        System.out.println("To your RIGHT, you see a faint blue light.");
        System.out.println("Do you go LEFT or RIGHT?");

        String choice = input.nextLine().toLowerCase();

        if (choice.equals("left")) {
            courage++;
            guardScene();
        } else if (choice.equals("right")) {
            trust++;
            memoryRoomScene();
        } else {
            invalidChoice();
            hallwayScene();
        }
    }

    public static void hallwayWithMira() {
        System.out.println("\nMira leads you into the corridor.");
        System.out.println("\"Listen carefully,\" she says. \"This place is beneath the city. They erased your memory for a reason.\"");
        System.out.println("You both reach a split in the hall.");
        System.out.println("Mira says the LEFT path leads to the records vault.");
        System.out.println("The RIGHT path leads to the elevator to the city above.");
        System.out.println("Do you go LEFT to learn the truth or RIGHT to escape?");

        String choice = input.nextLine().toLowerCase();

        if (choice.equals("left")) {
            trust++;
            vaultScene();
        } else if (choice.equals("right")) {
            courage++;
            cityArrivalScene();
        } else {
            invalidChoice();
            hallwayWithMira();
        }
    }

    public static void guardScene() {
        System.out.println("\nYou turn left and nearly collide with a security guard.");
        System.out.println("He freezes. You freeze. Humanity's favorite shared hobby.");
        System.out.println("Do you FIGHT, LIE, or RUN?");

        String choice = input.nextLine().toLowerCase();

        if (choice.equals("fight")) {
            courage += 2;
            System.out.println("\nYou slam into him and knock the stun baton from his hand.");
            System.out.println("You escape, but not before taking a keycard from his belt.");
            hasKey = true;
            cityArrivalScene();
        } else if (choice.equals("lie")) {
            trust++;
            System.out.println("\nYou say, \"Director sent me to Sector Nine.\"");
            System.out.println("The guard hesitates, then steps aside.");
            System.out.println("Either you sound convincing, or this facility is run by idiots.");
            cityArrivalScene();
        } else if (choice.equals("run")) {
            courage++;
            System.out.println("\nThe guard shouts and gives chase.");
            System.out.println("You dive through a maintenance hatch and tumble into another corridor.");
            memoryRoomScene();
        } else {
            invalidChoice();
            guardScene();
        }
    }

    public static void memoryRoomScene() {
        System.out.println("\nYou enter a circular room filled with glass pods.");
        System.out.println("Inside each pod is a sleeping person.");
        System.out.println("One pod is shattered from the inside.");
        System.out.println("A console in the center reads: SUBJECT A-17 MEMORY ARCHIVE.");
        System.out.println("Do you USE the console or LEAVE immediately?");

        String choice = input.nextLine().toLowerCase();

        if (choice.equals("use")) {
            knowsTruth = true;
            System.out.println("\nThe screen flickers.");
            System.out.println("A video begins playing.");
            System.out.println("You see yourself speaking into the camera:");
            System.out.println("\"If I wake up without memory, it means the rebellion failed... or I betrayed them.\"");
            System.out.println("\"The city above is fake. It is a controlled simulation built to keep everyone obedient.\"");
            System.out.println("\nYour stomach drops.");
            vaultScene();
        } else if (choice.equals("leave")) {
            cityArrivalScene();
        } else {
            invalidChoice();
            memoryRoomScene();
        }
    }

    public static void vaultScene() {
        System.out.println("\nYou reach the records vault.");
        System.out.println("Massive doors block the entrance.");
        System.out.println("A scanner flashes red.");
        System.out.println("Do you USE a keycard, HACK the panel, or SEARCH for another way?");

        String choice = input.nextLine().toLowerCase();

        if (choice.equals("use")) {
            if (hasKey) {
                System.out.println("\nThe keycard works.");
                insideVaultScene();
            } else {
                System.out.println("\nYou don't have a keycard.");
                vaultScene();
            }
        } else if (choice.equals("hack")) {
            courage++;
            System.out.println("\nYou tear open the panel and reconnect two wires.");
            System.out.println("The vault door groans open. Safety regulations are dead, apparently.");
            insideVaultScene();
        } else if (choice.equals("search")) {
            trust++;
            System.out.println("\nYou discover an air vent leading into the vault.");
            insideVaultScene();
        } else {
            invalidChoice();
            vaultScene();
        }
    }

    public static void insideVaultScene() {
        System.out.println("\nRows of files and glowing servers fill the chamber.");
        System.out.println("At the center is a projection terminal.");
        System.out.println("It activates automatically.");
        System.out.println("\nA man appears on the screen.");
        System.out.println("\"Hello, " + playerName + ". If you're seeing this, then memory restoration has begun.\"");
        System.out.println("\"You were never a prisoner. You were the architect of the City of Glass.\"");
        System.out.println("\nPlot twist. There it is.");
        System.out.println("\"You built the simulation to protect humanity after the surface became unlivable.\"");
        System.out.println("\"But later, you wanted to shut it down and free everyone.\"");
        System.out.println("\"The Council erased your memory before you could.\"");
        System.out.println("\nDo you DESTROY the city system, CONTROL it yourself, or SEEK Mira first?");

        String choice = input.nextLine().toLowerCase();

        if (choice.equals("destroy")) {
            knowsTruth = true;
            reactorScene();
        } else if (choice.equals("control")) {
            towerScene();
        } else if (choice.equals("seek")) {
            miraTruthScene();
        } else {
            invalidChoice();
            insideVaultScene();
        }
    }

    public static void cityArrivalScene() {
        System.out.println("\nYou reach the surface elevator.");
        System.out.println("The doors open onto a neon city under a perfect artificial sky.");
        System.out.println("The streets are clean. Too clean.");
        System.out.println("Everyone smiles the exact same smile.");
        System.out.println("A public screen flashes your face for half a second, then switches to an advertisement.");
        System.out.println("\nDo you BLEND into the crowd, FOLLOW the screen signal, or SEARCH for Mira?");

        String choice = input.nextLine().toLowerCase();

        if (choice.equals("blend")) {
            crowdScene();
        } else if (choice.equals("follow")) {
            towerScene();
        } else if (choice.equals("search")) {
            miraTruthScene();
        } else {
            invalidChoice();
            cityArrivalScene();
        }
    }

    public static void crowdScene() {
        System.out.println("\nYou walk among the citizens.");
        System.out.println("No one speaks above a whisper.");
        System.out.println("A small child looks at you and says, \"You came back.\"");
        System.out.println("Before you can respond, drones descend from above.");
        System.out.println("Do you HIDE in an alley or CLIMB onto a transit rail?");

        String choice = input.nextLine().toLowerCase();

        if (choice.equals("hide")) {
            trust--;
            miraTruthScene();
        } else if (choice.equals("climb")) {
            courage++;
            towerScene();
        } else {
            invalidChoice();
            crowdScene();
        }
    }

    public static void miraTruthScene() {
        System.out.println("\nYou find Mira waiting in an abandoned train station.");
        System.out.println("She looks relieved, then guilty.");
        System.out.println("\"There’s something I didn’t tell you,\" she says.");
        System.out.println("\"I work for the Council.\"");
        System.out.println("\"I was sent to watch you.\"");
        System.out.println("\"But I switched sides after I learned what they did to you.\"");
        System.out.println("\nDo you FORGIVE Mira or ACCUSE her of betrayal?");

        String choice = input.nextLine().toLowerCase();

        if (choice.equals("forgive")) {
            trust += 2;
            savedMira = true;
            System.out.println("\nMira exhales shakily. \"Then let me help you finish this.\"");
            finalChoiceScene();
        } else if (choice.equals("accuse")) {
            courage++;
            System.out.println("\nMira steps back. \"You still don't understand. If you go alone, you'll become exactly who they feared.\"");
            finalChoiceScene();
        } else {
            invalidChoice();
            miraTruthScene();
        }
    }

    public static void towerScene() {
        System.out.println("\nYou reach the central tower, the highest point in the city.");
        System.out.println("Inside the command chamber is the Council's leader.");
        System.out.println("He smiles when he sees you.");
        System.out.println("\"At last,\" he says. \"We can restore your position.\"");
        System.out.println("\"The people need their creator.\"");
        System.out.println("\nHe offers you a chair before the master console.");
        System.out.println("Do you ACCEPT the offer or REFUSE and attack the system?");

        String choice = input.nextLine().toLowerCase();

        if (choice.equals("accept")) {
            controlEnding();
        } else if (choice.equals("refuse")) {
            reactorScene();
        } else {
            invalidChoice();
            towerScene();
        }
    }

    public static void reactorScene() {
        System.out.println("\nYou descend into the reactor core beneath the tower.");
        System.out.println("The system that powers the simulation hums like a living thing.");
        System.out.println("If you destroy it, the city will collapse.");
        System.out.println("But the false sky, the controlled minds, and the lie will end.");
        System.out.println("\nDo you SHUT IT DOWN or OVERLOAD it completely?");

        String choice = input.nextLine().toLowerCase();

        if (choice.equals("shut it down")) {
            finalChoiceScene();
        } else if (choice.equals("overload")) {
            sacrificeEnding();
        } else {
            invalidChoice();
            reactorScene();
        }
    }

    public static void finalChoiceScene() {
        System.out.println("\nEmergency sirens roar across the city.");
        System.out.println("The truth is out. Citizens are waking up.");
        System.out.println("Some are terrified. Some are furious.");
        System.out.println("The city is on the edge of chaos.");
        System.out.println("\nYou reach the final control terminal.");
        System.out.println("One last choice remains:");
        System.out.println("FREE everyone and face the unknown world outside,");
        System.out.println("or RESET the system and keep the city stable.");
        System.out.println("\nType FREE or RESET.");

        String choice = input.nextLine().toLowerCase();

        if (choice.equals("free")) {
            freedomEnding();
        } else if (choice.equals("reset")) {
            falsePeaceEnding();
        } else {
            invalidChoice();
            finalChoiceScene();
        }
    }

    public static void freedomEnding() {
        System.out.println("\n========== ENDING: THE OPEN SKY ==========");
        System.out.println("You disable the final locks.");
        System.out.println("Across the city, glass walls crack and projections die.");
        System.out.println("For the first time in decades, people see the real world beyond the dome.");
        System.out.println("It is scarred, harsh, and unfinished.");
        System.out.println("But it is real.");
        if (savedMira) {
            System.out.println("Mira takes your hand as the dawn rises over the ruins.");
            System.out.println("\"Whatever comes next,\" she says, \"at least it's ours.\"");
        } else {
            System.out.println("You step into the cold morning alone, but finally awake.");
        }
        printStats();
        replayGame();
    }

    public static void falsePeaceEnding() {
        System.out.println("\n========== ENDING: THE BEAUTIFUL LIE ==========");
        System.out.println("You reset the city.");
        System.out.println("Memories fade. Fear disappears. Order returns.");
        System.out.println("The citizens smile again beneath the perfect sky.");
        System.out.println("You sit in the tower, guardian of a peaceful prison.");
        System.out.println("You saved them from pain.");
        System.out.println("You also stole the truth from them.");
        printStats();
        replayGame();
    }

    public static void controlEnding() {
        System.out.println("\n========== ENDING: THE NEW RULER ==========");
        System.out.println("You accept the Council's offer and take control of the city.");
        System.out.println("At first, you promise yourself you will rule better than they did.");
        System.out.println("At first.");
        System.out.println("Months later, your orders are law and dissent disappears.");
        System.out.println("You became the one thing you once tried to destroy.");
        printStats();
        replayGame();
    }

    public static void sacrificeEnding() {
        System.out.println("\n========== ENDING: ASHES AND LIGHT ==========");
        System.out.println("You overload the reactor.");
        System.out.println("The tower erupts in white light.");
        System.out.println("The system dies instantly.");
        System.out.println("So do you.");
        System.out.println("But the city is free.");
        if (savedMira) {
            System.out.println("Years later, Mira tells the story of the person who broke the sky to save them all.");
        }
        printStats();
        replayGame();
    }

    public static void printStats() {
        System.out.println("\n----- FINAL STATS -----");
        System.out.println("Player: " + playerName);
        System.out.println("Trust: " + trust);
        System.out.println("Courage: " + courage);
        System.out.println("Has Keycard: " + hasKey);
        System.out.println("Knows Truth: " + knowsTruth);
        System.out.println("Saved Mira: " + savedMira);
    }

    public static void replayGame() {
        System.out.println("\nWould you like to play again? YES or NO");
        String choice = input.nextLine().toLowerCase();

        if (choice.equals("yes")) {
            resetGame();
            startGame();
        } else if (choice.equals("no")) {
            System.out.println("\nThanks for playing.");
            System.out.println("The city goes dark. Very dramatic. Very yabai (dangerous).");
        } else {
            invalidChoice();
            replayGame();
        }
    }

    public static void resetGame() {
        trust = 0;
        courage = 0;
        hasKey = false;
        knowsTruth = false;
        savedMira = false;
    }

    public static void invalidChoice() {
        System.out.println("\nInvalid choice. Type one of the choices shown.");
    }
}
