import java.util.Scanner;

public class BellsOfKurogane {

    static Scanner input = new Scanner(System.in);

    static String playerName;
    static int resolve = 0;
    static int compassion = 0;
    static boolean hasLantern = false;
    static boolean hasKnife = false;
    static boolean knowsTruth = false;
    static boolean savedChild = false;
    static boolean hasBell = true;
    static boolean trustsMonk = false;

    public static void main(String[] args) {
        startGame();
    }

    public static void startGame() {
        System.out.println("========================================");
        System.out.println("      THE BELLS OF KUROGANE PASS");
        System.out.println("========================================");
        System.out.print("Enter your name: ");
        playerName = input.nextLine();

        System.out.println("\nYear 1904.");
        System.out.println("Snow gathers on the cedar roads of Kurogane Pass.");
        System.out.println("At dusk, your grandmother presses a wrapped bronze bell into your hands.");
        System.out.println("\"Take this to Jinko Monastery before dawn,\" she says.");
        System.out.println("\"Do not let it ring on the road. And if anyone asks your true name, do not answer.\"");
        System.out.println("\nYou leave your village as the last light fades.");
        System.out.println("At the first fork in the mountain road, you may take the FOREST trail or the RIVER road.");

        String choice = input.nextLine().toLowerCase();

        if (choice.equals("forest")) {
            resolve++;
            forestTrail();
        } else if (choice.equals("river")) {
            compassion++;
            riverRoad();
        } else {
            invalidChoice();
            startGame();
        }
    }

    public static void forestTrail() {
        System.out.println("\nYou enter the cedar forest.");
        System.out.println("The trees are dense, and strips of prayer paper flutter from broken branches.");
        System.out.println("Soon, you find an overturned pack beside the path.");
        System.out.println("A lantern lies in the snow, still usable.");
        System.out.println("Farther ahead, someone is crying.");
        System.out.println("\nDo you TAKE the lantern first or FOLLOW the crying?");

        String choice = input.nextLine().toLowerCase();

        if (choice.equals("take")) {
            hasLantern = true;
            System.out.println("\nYou light the lantern. The flame burns blue for a moment, then settles.");
            cryingScene();
        } else if (choice.equals("follow")) {
            compassion++;
            cryingScene();
        } else {
            invalidChoice();
            forestTrail();
        }
    }

    public static void riverRoad() {
        System.out.println("\nYou follow the river road where old stone markers lean under moss and snow.");
        System.out.println("At a collapsed bridge, you see a boy on the far bank.");
        System.out.println("He waves and shouts, but the wind carries only part of his voice.");
        System.out.println("A narrow beam still crosses the water.");
        System.out.println("\nDo you CROSS to help him or KEEP moving toward the monastery?");

        String choice = input.nextLine().toLowerCase();

        if (choice.equals("cross")) {
            compassion += 2;
            savedChild = true;
            childScene();
        } else if (choice.equals("keep")) {
            resolve++;
            System.out.println("\nYou keep moving, but the image of the boy follows you like a second shadow.");
            roadShrineScene();
        } else {
            invalidChoice();
            riverRoad();
        }
    }

    public static void cryingScene() {
        System.out.println("\nThe crying leads to a small roadside shrine with its roof half-buried in snow.");
        System.out.println("Inside sits a child in a straw coat, shivering.");
        System.out.println("He looks up and asks, \"Did they send you because I forgot my name?\"");
        System.out.println("The air turns suddenly cold.");
        System.out.println("Behind the shrine, bells ring once though nothing moves.");
        System.out.println("\nDo you HELP the child, ASK his name, or LEAVE immediately?");

        String choice = input.nextLine().toLowerCase();

        if (choice.equals("help")) {
            compassion += 2;
            savedChild = true;
            System.out.println("\nYou wrap the child in your cloak and lead him to the road.");
            roadShrineScene();
        } else if (choice.equals("ask")) {
            System.out.println("\nThe child opens his mouth, but before he can answer, the shrine walls shake.");
            System.out.println("A whisper circles the room: \"Names are doors.\"");
            roadShrineScene();
        } else if (choice.equals("leave")) {
            resolve++;
            System.out.println("\nYou back away from the shrine and return to the road, though the crying does not stop.");
            roadShrineScene();
        } else {
            invalidChoice();
            cryingScene();
        }
    }

    public static void childScene() {
        System.out.println("\nYou carefully cross the beam and reach the boy.");
        System.out.println("He is barefoot, freezing, and clutching a little wooden fox mask.");
        System.out.println("\"The masked riders came,\" he says. \"They took my mother up the mountain.\"");
        System.out.println("He stares at the bundle in your arms.");
        System.out.println("\"If that bell rings, they will hear you.\"");
        System.out.println("\nDo you CARRY the boy with you or SEND him to hide under the bridge?");

        String choice = input.nextLine().toLowerCase();

        if (choice.equals("carry")) {
            savedChild = true;
            compassion++;
            roadShrineScene();
        } else if (choice.equals("send")) {
            resolve++;
            System.out.println("\nYou tell him to hide until sunrise.");
            System.out.println("He nods, but before crawling under the bridge he says, \"The monastery lies.\"");
            roadShrineScene();
        } else {
            invalidChoice();
            childScene();
        }
    }

    public static void roadShrineScene() {
        System.out.println("\nNight deepens.");
        System.out.println("At the next bend stands a wayside shrine guarded by six iron bells hanging from a wooden beam.");
        System.out.println("One bell is missing.");
        System.out.println("The wrapped bundle in your hands feels suddenly heavier.");
        System.out.println("\nA traveling monk steps from the dark and bows.");
        System.out.println("\"I have been waiting,\" he says. \"The road above is no longer safe.\"");
        System.out.println("\"Come with me to the old watchtower and I will show you another path.\"");
        System.out.println("\nDo you TRUST the monk or REFUSE and continue alone?");

        String choice = input.nextLine().toLowerCase();

        if (choice.equals("trust")) {
            trustsMonk = true;
            compassion++;
            watchtowerScene();
        } else if (choice.equals("refuse")) {
            resolve++;
            nightRoadScene();
        } else {
            invalidChoice();
            roadShrineScene();
        }
    }

    public static void watchtowerScene() {
        System.out.println("\nYou follow the monk to a ruined watchtower overlooking the pass.");
        System.out.println("Inside are old maps, ashes, and a sword rack with only one blade remaining: a short iron knife.");
        System.out.println("The monk studies the bundle in your arms.");
        System.out.println("\"Your family still serves the pact,\" he says quietly.");
        System.out.println("\"Tell me, did your grandmother explain what the bell is really for?\"");
        System.out.println("\nDo you ASK him what he knows, GIVE him the bell, or TAKE the knife first?");

        String choice = input.nextLine().toLowerCase();

        if (choice.equals("ask")) {
            truthScene();
        } else if (choice.equals("give")) {
            falseTrustScene();
        } else if (choice.equals("take")) {
            hasKnife = true;
            System.out.println("\nYou take the iron knife. The monk notices, but says nothing.");
            truthScene();
        } else {
            invalidChoice();
            watchtowerScene();
        }
    }

    public static void nightRoadScene() {
        System.out.println("\nYou continue alone.");
        System.out.println("Snow begins to fall harder, and the road narrows along a cliff face.");
        System.out.println("Ahead, three riders in white masks block the path.");
        System.out.println("Each carries a rope of small bells.");
        System.out.println("The center rider says, \"Traveler. Speak your name and pass in peace.\"");
        System.out.println("\nDo you SPEAK a false name, DRAW your knife, or STAY silent?");

        String choice = input.nextLine().toLowerCase();

        if (choice.equals("speak a false name")) {
            System.out.println("\nYou give a false name.");
            System.out.println("The riders tilt their heads together, like birds hearing thunder.");
            System.out.println("\"Not yours,\" they whisper.");
            cliffScene();
        } else if (choice.equals("draw")) {
            if (hasKnife) {
                resolve += 2;
                System.out.println("\nYou draw the iron knife.");
                System.out.println("The bells on their ropes stop ringing. For the first time, the riders hesitate.");
                cliffScene();
            } else {
                System.out.println("\nYou reach for a weapon you do not have. A bold plan. Poorly funded.");
                cliffScene();
            }
        } else if (choice.equals("stay silent")) {
            resolve++;
            System.out.println("\nYou say nothing and walk forward.");
            System.out.println("The riders part without a word, but one whispers, \"The bell remembers.\"");
            cliffScene();
        } else {
            invalidChoice();
            nightRoadScene();
        }
    }

    public static void truthScene() {
        knowsTruth = true;
        System.out.println("\nThe monk sits beside the tower fire.");
        System.out.println("\"Long ago,\" he says, \"the villages of Kurogane Pass were plagued not by demons, but by echoes.\"");
        System.out.println("\"Spirits born from names unspoken, grief unburied, and vows broken.\"");
        System.out.println("\"Your ancestors forged six iron bells to bind them.\"");
        System.out.println("\"But peace required a price. Each generation, one family delivered a seventh bell carrying a human name within it.\"");
        System.out.println("\nYou go still.");
        System.out.println("\"The bell is not a ward,\" he says. \"It is an offering.\"");
        System.out.println("\"When it rings at the monastery, someone is erased so the pass may remain quiet for another twenty years.\"");
        System.out.println("\nDo you BELIEVE the monk, DENY it, or OPEN the bundle yourself?");

        String choice = input.nextLine().toLowerCase();

        if (choice.equals("believe")) {
            compassion++;
            bellRevealScene();
        } else if (choice.equals("deny")) {
            resolve++;
            System.out.println("\nYou refuse to believe him, but your hands shake around the bundle.");
            bellRevealScene();
        } else if (choice.equals("open")) {
            bellRevealScene();
        } else {
            invalidChoice();
            truthScene();
        }
    }

    public static void falseTrustScene() {
        System.out.println("\nYou offer the bundle to the monk.");
        System.out.println("He unwraps it with careful hands and smiles sadly.");
        System.out.println("\"Then your family told you nothing,\" he says.");
        System.out.println("\"That may be mercy. Or cowardice.\"");
        System.out.println("He gives the bell back.");
        System.out.println("\"Keep it. The choice must be yours.\"");
        bellRevealScene();
    }

    public static void bellRevealScene() {
        System.out.println("\nYou unwrap the bronze bell.");
        System.out.println("Its surface is engraved with clouds, reeds, and a single line of characters.");
        System.out.println("Inside the bell, etched where only the bearer would see it, is one name:");
        System.out.println("\n" + playerName);
        System.out.println("\nThe mountain wind dies.");
        System.out.println("The monk lowers his eyes.");
        System.out.println("\"The offering is you.\"");
        System.out.println("\nDo you CONTINUE to the monastery, DESTROY the bell, or SEEK the masked riders?");

        String choice = input.nextLine().toLowerCase();

        if (choice.equals("continue")) {
            monasteryApproach();
        } else if (choice.equals("destroy")) {
            resolve += 2;
            maskedRidersScene();
        } else if (choice.equals("seek")) {
            maskedRidersScene();
        } else {
            invalidChoice();
            bellRevealScene();
        }
    }

    public static void cliffScene() {
        System.out.println("\nPast the riders, the path rises to a cliffside gate.");
        System.out.println("Beyond it, lanterns burn along the steps to Jinko Monastery.");
        System.out.println("A woman in a cracked fox mask sits by the gate, wounded.");
        System.out.println("She sees the bell and laughs weakly.");
        System.out.println("\"Still feeding the mountain?\" she asks.");
        System.out.println("\"I once carried one too.\"");
        System.out.println("\nDo you HELP the woman, QUESTION her, or IGNORE her and climb the steps?");

        String choice = input.nextLine().toLowerCase();

        if (choice.equals("help")) {
            compassion += 2;
            foxWomanScene();
        } else if (choice.equals("question")) {
            foxWomanScene();
        } else if (choice.equals("ignore")) {
            monasteryApproach();
        } else {
            invalidChoice();
            cliffScene();
        }
    }

    public static void foxWomanScene() {
        knowsTruth = true;
        System.out.println("\nYou kneel beside her.");
        System.out.println("\"The monks call us thieves,\" she says, \"but we were the wardens of the old pact.\"");
        System.out.println("\"When the monastery learned they could erase a chosen name and keep the villages obedient, they took the ritual for themselves.\"");
        System.out.println("\"Now they call sacrifice peace.\"");
        System.out.println("\nShe presses a small iron striker into your hand.");
        System.out.println("\"With this, you may ring the bell by choice... or break the altar that forces it.\"");
        hasKnife = true;
        System.out.println("\nDo you GO to the monastery or HIDE until dawn?");

        String choice = input.nextLine().toLowerCase();

        if (choice.equals("go")) {
            monasteryApproach();
        } else if (choice.equals("hide")) {
            System.out.println("\nYou hide among the pines, but the bells above begin to ring on their own.");
            System.out.println("The mountain has no patience for delayed decisions.");
            monasteryApproach();
        } else {
            invalidChoice();
            foxWomanScene();
        }
    }

    public static void maskedRidersScene() {
        System.out.println("\nYou follow the sound of distant bells into a snow-covered cedar grove.");
        System.out.println("The masked riders wait in a circle around a dead tree hung with strips of old names written on paper.");
        System.out.println("Their leader removes his mask.");
        System.out.println("He is the monk from the watchtower.");
        System.out.println("\n\"I was once of the monastery,\" he says.");
        System.out.println("\"Now I keep what fragments of truth remain outside its walls.\"");
        System.out.println("\"If the bell reaches the altar, your name will be consumed. The villages will sleep easier. The lie will continue.\"");
        System.out.println("\"If the bell is broken, the echoes bound beneath the pass will awaken.\"");
        System.out.println("\nDo you GO with the riders to challenge the ritual or RETURN alone to the monastery?");

        String choice = input.nextLine().toLowerCase();

        if (choice.equals("go")) {
            compassion++;
            monasteryApproach();
        } else if (choice.equals("return")) {
            resolve++;
            monasteryApproach();
        } else {
            invalidChoice();
            maskedRidersScene();
        }
    }

    public static void monasteryApproach() {
        System.out.println("\nAt last you reach Jinko Monastery.");
        System.out.println("The monks stand in two silent rows beneath hanging lanterns.");
        System.out.println("At the top of the steps waits the abbot in black robes.");
        System.out.println("\"You are late,\" he says.");
        System.out.println("\"Bring the bell to the Hall of Quieting.\"");
        System.out.println("\nBehind him, from deep within the monastery, comes the sound of hundreds of voices trying not to be heard.");
        System.out.println("\nDo you OBEY the abbot, ACCUSE him publicly, or ASK what lies beneath the hall?");

        String choice = input.nextLine().toLowerCase();

        if (choice.equals("obey")) {
            hallOfQuieting();
        } else if (choice.equals("accuse")) {
            resolve++;
            hallOfQuieting();
        } else if (choice.equals("ask")) {
            compassion++;
            hallOfQuieting();
        } else {
            invalidChoice();
            monasteryApproach();
        }
    }

    public static void hallOfQuieting() {
        System.out.println("\nYou enter the Hall of Quieting.");
        System.out.println("Six ancient bells hang around a stone altar. Your bell belongs at the center.");
        System.out.println("Beneath the floorboards, something breathes.");
        System.out.println("The abbot turns to you.");
        System.out.println("\"Place the bell and ring it,\" he says.");
        System.out.println("\"One life to preserve many. Such is the mercy of order.\"");
        System.out.println("\nThen the floor cracks.");
        System.out.println("Whispers flood the room. Names. Promises. Apologies. Prayers.");
        System.out.println("The bound echoes are waking.");
        System.out.println("\nFinal choice:");
        System.out.println("RING the bell, BREAK the altar, or DESCEND below and face what is bound there.");

        String choice = input.nextLine().toLowerCase();

        if (choice.equals("ring")) {
            sacrificeEnding();
        } else if (choice.equals("break")) {
            freedomEnding();
        } else if (choice.equals("descend")) {
            shadowEnding();
        } else {
            invalidChoice();
            hallOfQuieting();
        }
    }

    public static void sacrificeEnding() {
        System.out.println("\n========== ENDING: THE QUIET NAME ==========");
        System.out.println("You place the bell on the altar and strike it once.");
        System.out.println("Its sound is small, almost gentle.");
        System.out.println("The hall trembles. The whispers soften. The bound echoes sink back beneath the stones.");
        System.out.println("Snow falls outside in complete silence.");
        System.out.println("The villages of Kurogane Pass wake to peaceful morning.");
        System.out.println("No one remembers who carried the bell there.");
        System.out.println("Your footprints fade before sunrise.");
        printStats();
        replayGame();
    }

    public static void freedomEnding() {
        System.out.println("\n========== ENDING: THE BROKEN ALTAR ==========");
        System.out.println("You raise the iron striker and shatter the altar stone.");
        System.out.println("All seven bells cry out at once.");
        System.out.println("The monastery walls split. Lanterns burst. The whispers roar into voices.");
        System.out.println("Memories return to the villages: the missing, the sacrificed, the bargains dressed up as peace.");
        if (savedChild) {
            System.out.println("Among the voices is the child's mother, found alive in the mountain cells below.");
        }
        System.out.println("The pass is no longer quiet.");
        System.out.println("But for the first time in generations, it is honest.");
        printStats();
        replayGame();
    }

    public static void shadowEnding() {
        System.out.println("\n========== ENDING: KEEPER OF ECHOES ==========");
        System.out.println("You descend beneath the hall into a cavern of hanging bells and black water.");
        System.out.println("There you find the true source of the pass: not a monster, but a vast chorus of unfinished lives.");
        System.out.println("They do not ask for blood. They ask to be remembered.");
        System.out.println("You speak your own name aloud and offer yourself not as sacrifice, but as keeper.");
        System.out.println("The echoes gather around you like winter birds.");
        System.out.println("When dawn comes, the monastery stands empty.");
        System.out.println("Travelers later speak of a bell-warden on the mountain road who asks every stranger one thing:");
        System.out.println("\"Who have you forgotten?\"");
        printStats();
        replayGame();
    }

    public static void printStats() {
        System.out.println("\n----- FINAL STATS -----");
        System.out.println("Player: " + playerName);
        System.out.println("Resolve: " + resolve);
        System.out.println("Compassion: " + compassion);
        System.out.println("Has Lantern: " + hasLantern);
        System.out.println("Has Knife/Striker: " + hasKnife);
        System.out.println("Knows Truth: " + knowsTruth);
        System.out.println("Saved Child: " + savedChild);
        System.out.println("Trusts Monk: " + trustsMonk);
        System.out.println("Still Carrying Bell: " + hasBell);
    }

    public static void replayGame() {
        System.out.println("\nWould you like to play again? YES or NO");
        String choice = input.nextLine().toLowerCase();

        if (choice.equals("yes")) {
            resetGame();
            startGame();
        } else if (choice.equals("no")) {
            System.out.println("\nThe bells fall silent.");
            System.out.println("`owari` (the end).");
        } else {
            invalidChoice();
            replayGame();
        }
    }

    public static void resetGame() {
        resolve = 0;
        compassion = 0;
        hasLantern = false;
        hasKnife = false;
        knowsTruth = false;
        savedChild = false;
        hasBell = true;
        trustsMonk = false;
    }

    public static void invalidChoice() {
        System.out.println("\nInvalid choice. Type one of the choices shown.");
    }
}
