import javax.swing.*;
import java.awt.*;

public class BellsOfKuroganeGUI extends JFrame {

    private JTextArea storyArea;
    private JButton choice1;
    private JButton choice2;
    private JButton choice3;
    private JLabel statsLabel;

    private int resolve = 0;
    private int compassion = 0;
    private boolean knowsTruth = false;

    public BellsOfKuroganeGUI() {
        setTitle("The Bells of Kurogane Pass");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("The Bells of Kurogane Pass", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 24));
        add(titleLabel, BorderLayout.NORTH);

        storyArea = new JTextArea();
        storyArea.setEditable(false);
        storyArea.setLineWrap(true);
        storyArea.setWrapStyleWord(true);
        storyArea.setFont(new Font("Serif", Font.PLAIN, 18));
        storyArea.setMargin(new Insets(15, 15, 15, 15));

        JScrollPane scrollPane = new JScrollPane(storyArea);
        add(scrollPane, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new BorderLayout());

        statsLabel = new JLabel("Resolve: 0 | Compassion: 0 | Knows Truth: false");
        bottomPanel.add(statsLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 3, 10, 10));

        choice1 = new JButton();
        choice2 = new JButton();
        choice3 = new JButton();

        buttonPanel.add(choice1);
        buttonPanel.add(choice2);
        buttonPanel.add(choice3);

        bottomPanel.add(buttonPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        showIntroScene();
    }

    private void updateStats() {
        statsLabel.setText(
            "Resolve: " + resolve +
            " | Compassion: " + compassion +
            " | Knows Truth: " + knowsTruth
        );
    }

    private void setButton(JButton button, String text, Runnable action) {
        for (var listener : button.getActionListeners()) {
            button.removeActionListener(listener);
        }

        if (text == null || text.isEmpty()) {
            button.setVisible(false);
            return;
        }

        button.setVisible(true);
        button.setText(text);
        button.addActionListener(e -> action.run());
    }

    private void setScene(
            String story,
            String button1Text, Runnable button1Action,
            String button2Text, Runnable button2Action,
            String button3Text, Runnable button3Action
    ) {
        storyArea.setText(story);
        setButton(choice1, button1Text, button1Action);
        setButton(choice2, button2Text, button2Action);
        setButton(choice3, button3Text, button3Action);
        updateStats();
    }

    private void showIntroScene() {
        String story = """
                Year 1904.

                Snow gathers on the cedar roads of Kurogane Pass.
                Your grandmother presses a wrapped bronze bell into your hands.

                "Take this to Jinko Monastery before dawn," she says.
                "Do not let it ring on the road."

                At the first fork, you may take the forest trail or the river road.
                """;

        setScene(
                story,
                "Forest", () -> {
                    resolve++;
                    showForestScene();
                },
                "River", () -> {
                    compassion++;
                    showRiverScene();
                },
                "", null
        );
    }

    private void showForestScene() {
        String story = """
                You enter the cedar forest.

                Prayer paper flutters from broken branches.
                You find an overturned pack and a lantern in the snow.
                Farther ahead, someone is crying.

                What do you do?
                """;

        setScene(
                story,
                "Take Lantern", () -> {
                    resolve++;
                    showLanternScene();
                },
                "Follow Crying", () -> {
                    compassion++;
                    showChildScene();
                },
                "Go Back", this::showIntroScene
        );
    }

    private void showRiverScene() {
        String story = """
                You follow the river road.

                A collapsed bridge groans under snow.
                On the far bank, a child waves for help.

                What do you do?
                """;

        setScene(
                story,
                "Help Child", () -> {
                    compassion += 2;
                    showChildScene();
                },
                "Keep Moving", () -> {
                    resolve++;
                    showMonasteryScene();
                },
                "Go Back", this::showIntroScene
        );
    }

    private void showLanternScene() {
        String story = """
                You light the lantern.
                The flame burns blue for a moment, then settles.

                The crying leads to a roadside shrine.
                A child sits inside, shivering.

                He asks, "Did they send you because I forgot my name?"
                """;

        setScene(
                story,
                "Help Child", () -> {
                    compassion += 2;
                    showMonasteryScene();
                },
                "Ask Questions", () -> {
                    knowsTruth = true;
                    showMonasteryScene();
                },
                "Leave", this::showMonasteryScene
        );
    }

    private void showChildScene() {
        String story = """
                The child clutches a small fox mask.

                Behind the shrine, a bell rings once though nothing moves.
                The air turns bitterly cold.

                The child whispers, "The monastery lies."
                """;

        setScene(
                story,
                "Believe Him", () -> {
                    knowsTruth = true;
                    compassion++;
                    showMonasteryScene();
                },
                "Ignore Him", () -> {
                    resolve++;
                    showMonasteryScene();
                },
                "Run", this::showMonasteryScene
        );
    }

    private void showMonasteryScene() {
        String story = """
                You arrive at Jinko Monastery.

                Lanterns burn along the stone steps.
                Monks wait in silence beneath the falling snow.

                The abbot raises one hand.
                "Bring the bell inside," he says.

                Final choice:
                """;

        setScene(
                story,
                "Ring the Bell", this::showEndingOne,
                "Break the Altar", this::showEndingTwo,
                "Descend Below", this::showEndingThree
        );
    }

    private void showEndingOne() {
        String story = """
                ENDING: THE QUIET NAME

                You ring the bell.
                The mountain falls silent.

                By morning, the villages are peaceful.
                No one remembers who carried the bell.
                """;

        setScene(
                story,
                "Play Again", this::resetGame,
                "Quit", () -> System.exit(0),
                "", null
        );
    }

    private void showEndingTwo() {
        String story = """
                ENDING: THE BROKEN ALTAR

                You shatter the altar stone.
                All seven bells scream at once.

                The truth returns to the mountain.
                The pass is no longer quiet, but it is honest.
                """;

        setScene(
                story,
                "Play Again", this::resetGame,
                "Quit", () -> System.exit(0),
                "", null
        );
    }

    private void showEndingThree() {
        String story = """
                ENDING: KEEPER OF ECHOES

                You descend beneath the monastery and face the voices bound below.
                They do not ask for blood.
                They ask to be remembered.

                At dawn, the monastery stands empty.
                """;

        setScene(
                story,
                "Play Again", this::resetGame,
                "Quit", () -> System.exit(0),
                "", null
        );
    }

    private void resetGame() {
        resolve = 0;
        compassion = 0;
        knowsTruth = false;
        showIntroScene();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BellsOfKuroganeGUI game = new BellsOfKuroganeGUI();
            game.setVisible(true);
        });
    }
}
