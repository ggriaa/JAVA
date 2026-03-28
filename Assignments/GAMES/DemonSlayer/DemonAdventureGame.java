import java.util.Scanner;

public class DemonAdventureGame {

    static Scanner input = new Scanner(System.in);

    static String playerName;
    static int honor = 0;
    static int courage = 0;
    static boolean hasNichirinBlade = false;
    static boolean knowsTruth = false;
    static boolean savedRen = false;
    static boolean hasCharm = false;

    public static void main(String[] args) {
        startGame();
    }

    // Starts the game
    public static void startGame() {
        System.out.println("==========================================");
        System.out.println("     SHADOWS OF THE CRIMSON MOON");
        System.out.println("==========================================");
        System.out.print("Enter your name: ");
        playerName = input.nextLine();

        System.out.println("\nTaisho-era Japan.");
        System.out.println("The wind moves through the cedar trees as the night deepens.");
        System.out.println("You return to your mountain village and find the houses silent.");
        System.out.println("The smell of smoke and blood clings to the air.");
        System.out.println("Your family home stands open.");
        System.out.println("\nDo you ENTER the house or SEARCH the village first?");

        String choice = input.nextLine().toLowerCase();

        if (choice.equals("enter")) {
            courage++;
            houseScene();
        } else if (choice.equals("search")) {
            honor++;
            villageScene();
        } else {
            invalidChoice();
            startGame();
        }
    }

    // Scene in the family house
    public static void houseScene() {
        System.out.println("\nYou step into the house.");
        System.out.println("The lantern has been knocked over.");
        System.out.println("Your family's prayer altar is broken.");
        System.out.println("On the floor, you find a torn ofuda charm covered in blood.");
        System.out.println("Then you hear movement behind the house.");
        System.out.println("\nDo you GRAB the charm or RUN outside immediately?");

        String choice = input.nextLine().toLowerCase();

        if (choice.equals("grab")) {
            hasCharm = true;
            honor++;
            System.out.println("\nYou take the torn charm and rush outside.");
            backyardScene();
        } else if (choice.equals("run")) {
            courage++;
            backyardScene();
        } else {
            invalidChoice();
            houseScene();
        }
    }

    // Scene searching village first
    public static void villageScene() {
        System.out.println("\nYou move through the village square.");
        System.out.println("Doors are broken. Rice bowls lie shattered in the dirt.");
        System.out.println("Near the well, an injured slayer is leaning against a post.");
        System.out.println("He is young, bleeding, and barely conscious.");
        System.out.println("\"The demon... went toward your home...\" he whispers.");
        System.out.println("\nDo you HELP him or LEAVE him and run to your house?");

        String choice = input.nextLine().toLowerCase();

        if (choice.equals("help")) {
            honor += 2;
            savedRen = true;
            System.out.println("\nYou tear cloth from your sleeve and bind his wound.");
            System.out.println("\"My name is Ren,\" he says weakly. \"Take this blade.\"");
            System.out.println("He gives you a Nichirin sword.");
            hasNichirinBlade = true;
            backyardScene();
        } else if (choice.equals("leave")) {
            courage++;
            System.out.println("\nYou sprint toward your house as the wounded slayer fades behind you.");
            backyardScene();
        } else {
            invalidChoice();
            villageScene();
        }
    }

    // Back of house scene
    public static void backyardScene() {
        System.out.println("\nBehind your house, the moon shines over the pine trees.");
        System.out.println("A figure crouches beside the old stone storehouse.");
        System.out.println("It slowly rises.");
        System.out.println("Its eyes glow red.");
        System.out.println("Its mouth is stained black with blood.");
        System.out.println("\nIt was once your older brother.");
        System.out.println("\nDo you CALL out to him, ATTACK, or HIDE?");

        String choice = input.nextLine().toLowerCase();

        if (choice.equals("call")) {
            honor++;
            brotherScene();
        } else if (choice.equals("attack")) {
            courage += 2;
            if (hasNichirinBlade) {
                System.out.println("\nYou strike with the Nichirin blade.");
                System.out.println("The demon leaps back with unnatural speed.");
                brotherScene();
            } else {
                System.out.println("\nYou rush forward bare-handed.");
                System.out.println("The demon knocks you into the dirt.");
                System.out.println("You barely escape with your life.");
                brotherScene();
            }
        } else if (choice.equals("hide")) {
            System.out.println("\nYou slip behind a woodpile and watch.");
            System.out.println("The demon whispers in a broken voice:");
            System.out.println("\"Why did Father hide the truth from you...?\"");
            brotherScene();
        } else {
            invalidChoice();
            backyardScene();
        }
    }

    // Brother demon scene
    public static void brotherScene() {
        System.out.println("\nThe demon stares at you.");
        System.out.println("\"Leave,\" he growls. \"Before they come.\"");
        System.out.println("\"The slayers do not know what lives in your blood.\"");
        System.out.println("Before you can speak, a group of demon slayers appears at the edge of the trees.");
        System.out.println("Their leader, Master Daichi, points his blade at both of you.");
        System.out.println("\"Stand aside,\" he says. \"That creature dies now.\"");
        System.out.println("\nDo you PROTECT your brother, JOIN the slayers, or DEMAND answers?");

        String choice = input.nextLine().toLowerCase();

        if (choice.equals("protect")) {
            honor += 2;
            forestEscapeScene();
        } else if (choice.equals("join")) {
            courage++;
            slayerCampScene();
        } else if (choice.equals("demand")) {
            knowsTruth = true;
            truthScene();
        } else {
            invalidChoice();
            brotherScene();
        }
    }

    // Escape scene with brother
    public static void forestEscapeScene() {
        System.out.println("\nYou step between the slayers and your brother.");
        System.out.println("\"Move and die with him,\" Master Daichi says.");
        System.out.println("Your brother suddenly grabs your sleeve and drags you into the forest.");
        System.out.println("Branches lash your face as you run through the dark cedar woods.");
        System.out.println("\nAt a fork in the forest path, he stops.");
        System.out.println("\"The shrine... or the river,\" he says weakly.");
        System.out.println("\"One still holds the truth.\"");
        System.out.println("\nDo you go to the SHRINE or the RIVER?");

        String choice = input.nextLine().toLowerCase();

        if (choice.equals("shrine")) {
            shrineScene();
        } else if (choice.equals("river")) {
            riverScene();
        } else {
            invalidChoice();
            forestEscapeScene();
        }
    }

    // Join slayers scene
    public static void slayerCampScene() {
        System.out.println("\nYou lower your head and step toward the slayers.");
        System.out.println("Master Daichi orders his men to pursue the demon through the forest.");
        System.out.println("He studies you carefully.");
        System.out.println("\"Come with us,\" he says. \"If you survive the night, perhaps you are worth training.\"");
        System.out.println("\nAt the temporary slayer camp, you are shown a sword stand, a fire, and a sealed wooden box.");
        System.out.println("Daichi says the box was found hidden beneath your house.");
        System.out.println("\nDo you OPEN the box, ASK about your family, or ACCEPT training first?");

        String choice = input.nextLine().toLowerCase();

        if (choice.equals("open")) {
            boxScene();
        } else if (choice.equals("ask")) {
            truthScene();
        } else if (choice.equals("accept")) {
            courage++;
            trainingScene();
        } else {
            invalidChoice();
            slayerCampScene();
        }
    }

    // Truth scene
    public static void truthScene() {
        knowsTruth = true;
        System.out.println("\nThe night falls silent.");
        System.out.println("Master Daichi narrows his eyes.");
        System.out.println("\"Very well,\" he says. \"Your family were not ordinary villagers.\"");
        System.out.println("\"Generations ago, your bloodline guarded a breathing style lost to both humans and demons.\"");
        System.out.println("\"A style so dangerous it was buried with seals and lies.\"");
        System.out.println("\"Your brother discovered it first.\"");
        System.out.println("\"The demon lord wanted that bloodline.\"");
        System.out.println("\nYour brother laughs bitterly from the shadows.");
        System.out.println("\"That is not all,\" he says.");
        System.out.println("\"Father served the slayers once. He made a pact to hide us.\"");
        System.out.println("\"When they feared us, they abandoned the village.\"");
        System.out.println("\nDo you TRUST Daichi, TRUST your brother, or SEARCH for proof yourself?");

        String choice = input.nextLine().toLowerCase();

        if (choice.equals("trust daichi")) {
            slayerCampScene();
        } else if (choice.equals("trust your brother")) {
            forestEscapeScene();
        } else if (choice.equals("search")) {
            shrineScene();
        } else {
            invalidChoice();
            truthScene();
        }
    }

    // Shrine scene
    public static void shrineScene() {
        System.out.println("\nDeep in the mountain forest, you arrive at your family shrine.");
        System.out.println("Torii gates rise in the mist.");
        System.out.println("Paper charms flutter in the wind.");
        System.out.println("Inside the shrine hall, the floorboards are disturbed.");
        System.out.println("Beneath them, you discover a hidden scroll and a wrapped blade.");
        System.out.println("\nDo you READ the scroll or TAKE the blade first?");

        String choice = input.nextLine().toLowerCase();

        if (choice.equals("read")) {
            System.out.println("\nThe scroll describes the Sun Shadow Breathing style.");
            System.out.println("It says only those born of your line can wield it without dying.");
            System.out.println("It also reveals the true twist:");
            System.out.println("Your family was not protecting the village from demons.");
            System.out.println("They were protecting demons from a greater evil.");
            System.out.println("Some demons could still choose not to kill.");
            System.out.println("Your brother was turned while defending the shrine.");
            knowsTruth = true;
            hasNichirinBlade = true;
            finalRoadScene();
        } else if (choice.equals("take")) {
            System.out.println("\nYou unwrap the blade.");
            System.out.println("Its steel glows crimson under the moon.");
            hasNichirinBlade = true;
            finalRoadScene();
        } else {
            invalidChoice();
            shrineScene();
        }
    }

    // River scene
    public static void riverScene() {
        System.out.println("\nYou reach the riverbank.");
        System.out.println("The water reflects the moon like shattered silver.");
        System.out.println("Near the stones lies your mother, barely alive.");
        System.out.println("She clutches a prayer bead bracelet and gasps when she sees you.");
        System.out.println("\"Listen... your brother is not the enemy...\" she whispers.");
        System.out.println("\"Daichi came before the attack... he wanted the sealed blade...\"");
        System.out.println("\nDo you STAY with her or CHASE Daichi immediately?");

        String choice = input.nextLine().toLowerCase();

        if (choice.equals("stay")) {
            honor += 2;
            System.out.println("\nShe places the bracelet in your hands.");
            System.out.println("\"At the shrine... beneath the altar...\"");
            hasCharm = true;
            shrineScene();
        } else if (choice.equals("chase")) {
            courage += 2;
            towerRoadScene();
        } else {
            invalidChoice();
            riverScene();
        }
    }

    // Hidden box scene
    public static void boxScene() {
        System.out.println("\nYou open the wooden box.");
        System.out.println("Inside is a child-sized kimono, a family crest, and a letter.");
        System.out.println("The letter is from your father.");
        System.out.println("\n\"If you are reading this, then the slayers have failed us.\"");
        System.out.println("\"Do not trust any leader who seeks the Crimson Blade.\"");
        System.out.println("\"That blade was forged to kill the First Shadow, not ordinary demons.\"");
        System.out.println("\nMaster Daichi reaches for the letter.");
        System.out.println("\"Enough,\" he says sharply.");
        System.out.println("\nDo you GIVE him the letter or HIDE it?");

        String choice = input.nextLine().toLowerCase();

        if (choice.equals("give")) {
            System.out.println("\nDaichi burns the letter in the fire.");
            System.out.println("\"Forget what you saw,\" he says.");
            trainingScene();
        } else if (choice.equals("hide")) {
            honor++;
            knowsTruth = true;
            System.out.println("\nYou slip the letter into your robe.");
            System.out.println("Daichi notices but says nothing.");
            towerRoadScene();
        } else {
            invalidChoice();
            boxScene();
        }
    }

    // Training scene
    public static void trainingScene() {
        System.out.println("\nBefore dawn, Daichi tests you.");
        System.out.println("You are told to choose one trial:");
        System.out.println("STONE, WIND, or FIRE.");
        System.out.println("Each represents a different kind of strength.");
        System.out.println("\nWhich trial do you choose?");

        String choice = input.nextLine().toLowerCase();

        if (choice.equals("stone")) {
            honor++;
            System.out.println("\nYou stand beneath a waterfall until your legs nearly fail.");
            System.out.println("Daichi nods. \"You endure.\"");
            towerRoadScene();
        } else if (choice.equals("wind")) {
            courage++;
            System.out.println("\nYou race across pine beams above a ravine.");
            System.out.println("Daichi nods. \"You move without fear.\"");
            towerRoadScene();
        } else if (choice.equals("fire")) {
            courage++;
            honor++;
            System.out.println("\nYou practice strikes beside a ring of flames until your hands bleed.");
            System.out.println("Daichi watches in silence. \"You have dangerous resolve.\"");
            towerRoadScene();
        } else {
            invalidChoice();
            trainingScene();
        }
    }

    // Final road scene from shrine
    public static void finalRoadScene() {
        System.out.println("\nAt the back of the shrine, a hidden stone door opens.");
        System.out.println("A path leads up the mountain toward the abandoned temple of the Crimson Moon.");
        System.out.println("From behind you comes the sound of footsteps.");
        if (savedRen) {
            System.out.println("Ren, pale but standing, has followed you.");
            System.out.println("\"I owe you my life,\" he says. \"Let me fight beside you.\"");
        } else {
            System.out.println("You stand alone under the cold moonlight.");
        }
        System.out.println("\nDo you GO to the temple or WAIT and prepare?");

        String choice = input.nextLine().toLowerCase();

        if (choice.equals("go")) {
            templeScene();
        } else if (choice.equals("wait")) {
            honor++;
            templeScene();
        } else {
            invalidChoice();
            finalRoadScene();
        }
    }

    // Road leading to confrontation
    public static void towerRoadScene() {
        System.out.println("\nYou follow the mountain road toward the abandoned temple.");
        System.out.println("The clouds cover the moon.");
        System.out.println("At the temple steps stand both your brother and Master Daichi.");
        System.out.println("Neither has attacked yet.");
        System.out.println("Each waits for you.");
        System.out.println("\nDo you STAND with Daichi, STAND with your brother, or FACE both alone?");

        String choice = input.nextLine().toLowerCase();

        if (choice.equals("stand with daichi")) {
            templeSceneDaichi();
        } else if (choice.equals("stand with your brother")) {
            templeSceneBrother();
        } else if (choice.equals("face both")) {
            templeScene();
        } else {
            invalidChoice();
            towerRoadScene();
        }
    }

    // Neutral temple scene
    public static void templeScene() {
        System.out.println("\nInside the temple, candles ignite on their own.");
        System.out.println("At the center lies a black altar and above it hangs the Crimson Blade seal.");
        System.out.println("A voice echoes through the hall.");
        System.out.println("A tall figure emerges from the darkness.");
        System.out.println("It is the First Shadow, the demon from whom all others descend.");
        System.out.println("\nHe smiles at you.");
        System.out.println("\"At last,\" he says. \"The child of the sealed bloodline.\"");
        System.out.println("\"Your father stole my blade. Your brother became mine. And now you will choose.\"");
        System.out.println("\nDo you FIGHT the First Shadow, BREAK the seal, or SACRIFICE yourself?");

        String choice = input.nextLine().toLowerCase();

        if (choice.equals("fight")) {
            freedomEnding();
        } else if (choice.equals("break")) {
            shadowEnding();
        } else if (choice.equals("sacrifice")) {
            sacrificeEnding();
        } else {
            invalidChoice();
            templeScene();
        }
    }

    // Temple if standing with Daichi
    public static void templeSceneDaichi() {
        System.out.println("\nYou step beside Master Daichi.");
        System.out.println("He smiles faintly.");
        System.out.println("\"You chose well,\" he says.");
        System.out.println("Then he turns his blade, not toward the demon, but toward the altar.");
        System.out.println("\"With your blood, the Crimson Blade can be awakened.\"");
        System.out.println("So there it is. Betrayal. Humans remain committed to being exhausting.");
        System.out.println("\nDo you STOP Daichi, GIVE your blood, or CALL to your brother for help?");

        String choice = input.nextLine().toLowerCase();

        if (choice.equals("stop daichi")) {
            freedomEnding();
        } else if (choice.equals("give")) {
            falsePeaceEnding();
        } else if (choice.equals("call")) {
            savedRen = true;
            freedomEnding();
        } else {
            invalidChoice();
            templeSceneDaichi();
        }
    }

    // Temple if standing with brother
    public static void templeSceneBrother() {
        System.out.println("\nYou stand beside your brother.");
        System.out.println("His demonic eyes soften for a moment.");
        System.out.println("\"I held on as long as I could,\" he says.");
        System.out.println("\"But if the seal breaks, I may lose myself forever.\"");
        System.out.println("\nMaster Daichi raises his sword.");
        System.out.println("\"Then both of you die here,\" he says.");
        System.out.println("\nDo you DEFEND your brother, FORCE him to flee, or CHALLENGE Daichi?");

        String choice = input.nextLine().toLowerCase();

        if (choice.equals("defend")) {
            honor += 2;
            freedomEnding();
        } else if (choice.equals("force")) {
            sacrificeEnding();
        } else if (choice.equals("challenge")) {
            courage += 2;
            freedomEnding();
        } else {
            invalidChoice();
            templeSceneBrother();
        }
    }

    // Good ending
    public static void freedomEnding() {
        System.out.println("\n========== ENDING: DAWN OVER THE MOUNTAIN ==========");
        if (hasNichirinBlade && knowsTruth) {
            System.out.println("Using the crimson blade and the hidden breathing form, you cut through the altar seal.");
            System.out.println("The First Shadow is dragged into the fire of the rising sun.");
            System.out.println("Master Daichi falls, exposed at last for what he truly wanted: power.");
            if (savedRen) {
                System.out.println("Ren helps hold back the shadows while your brother, with his last strength, thanks you.");
            }
            System.out.println("When morning comes, the mountain is quiet.");
            System.out.println("The truth of your family survives, and a new path opens between humans and those demons who resisted darkness.");
        } else {
            System.out.println("You win, but only barely.");
            System.out.println("The battle leaves the temple in ruins and the truth only half uncovered.");
        }
        printStats();
        replayGame();
    }

    // Dark ending
    public static void shadowEnding() {
        System.out.println("\n========== ENDING: HEIR OF THE CRIMSON NIGHT ==========");
        System.out.println("You break the seal.");
        System.out.println("Power floods the temple like black fire.");
        System.out.println("The First Shadow kneels, not in defeat, but in recognition.");
        System.out.println("\"You were never meant to destroy this power,\" he says. \"You were meant to inherit it.\"");
        System.out.println("The moon turns red.");
        System.out.println("By dawn, the mountain belongs to you.");
        System.out.println("Whether you become protector or tyrant is left to history.");
        printStats();
        replayGame();
    }

    // Sacrifice ending
    public static void sacrificeEnding() {
        System.out.println("\n========== ENDING: THE LAST BREATH ==========");
        System.out.println("You cut your own palm and place your blood upon the altar.");
        System.out.println("The seal closes with your life force bound into it.");
        System.out.println("The temple trembles.");
        System.out.println("The First Shadow is trapped once more.");
        System.out.println("Your brother's demonic form begins to fade.");
        System.out.println("For one brief moment, he is himself again.");
        System.out.println("\"I'm sorry,\" he whispers.");
        System.out.println("Snow begins to fall as the mountain goes still.");
        printStats();
        replayGame();
    }

    // False peace ending
    public static void falsePeaceEnding() {
        System.out.println("\n========== ENDING: PEACE BOUGHT IN BLOOD ==========");
        System.out.println("You offer your blood to awaken the Crimson Blade for Daichi.");
        System.out.println("He slays the First Shadow and becomes a hero to the slayers.");
        System.out.println("But your family name is erased from history.");
        System.out.println("Your brother is executed, and the truth dies in silence.");
        System.out.println("Japan gains peace for a time.");
        System.out.println("It is not a clean peace.");
        printStats();
        replayGame();
    }

    // Show final stats
    public static void printStats() {
        System.out.println("\n----- FINAL STATS -----");
        System.out.println("Player: " + playerName);
        System.out.println("Honor: " + honor);
        System.out.println("Courage: " + courage);
        System.out.println("Has Nichirin Blade: " + hasNichirinBlade);
        System.out.println("Knows Truth: " + knowsTruth);
        System.out.println("Saved Ren: " + savedRen);
        System.out.println("Has Charm: " + hasCharm);
    }

    // Replay option
    public static void replayGame() {
        System.out.println("\nWould you like to play again? YES or NO");
        String choice = input.nextLine().toLowerCase();

        if (choice.equals("yes")) {
            resetGame();
            startGame();
        } else if (choice.equals("no")) {
            System.out.println("\nThe lantern flame fades.");
            System.out.println("Game over. `yoru` (night) wins again.");
        } else {
            invalidChoice();
            replayGame();
        }
    }

    // Reset game stats
    public static void resetGame() {
        honor = 0;
        courage = 0;
        hasNichirinBlade = false;
        knowsTruth = false;
        savedRen = false;
        hasCharm = false;
    }

    // Invalid choice helper
    public static void invalidChoice() {
        System.out.println("\nInvalid choice. Type one of the choices shown.");
    }
}
