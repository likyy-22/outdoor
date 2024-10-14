import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class CatchTheAnimal extends JFrame {
    private static final int FRAME_WIDTH = 800;
    private static final int FRAME_HEIGHT = 600;
    private JButton animalButton;
    private int score = 0;
    private JLabel scoreLabel;
    private Random random;

    public CatchTheAnimal() {
        setTitle("Catch the Animal Game");
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        random = new Random();

        scoreLabel = new JLabel("Score: " + score);
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 24));
        scoreLabel.setBounds(10, 10, 200, 30);
        add(scoreLabel);

        animalButton = new JButton(new ImageIcon("dog.png"));
        animalButton.setBounds(randomX(), randomY(), 100, 100);
        animalButton.setBorderPainted(false);
        animalButton.setContentAreaFilled(false);
        animalButton.setFocusPainted(false);
        animalButton.addActionListener(new AnimalClickListener());
        add(animalButton);

        Timer timer = new Timer(1000, e -> moveAnimal());
        timer.start();
    }

    private void moveAnimal() {
        animalButton.setBounds(randomX(), randomY(), 100, 100);
        if (random.nextBoolean()) {
            animalButton.setIcon(new ImageIcon("dog.png"));
        } else {
            animalButton.setIcon(new ImageIcon("cat.png"));
        }
    }

    private int randomX() {
        return random.nextInt(FRAME_WIDTH - 100);
    }

    private int randomY() {
        return random.nextInt(FRAME_HEIGHT - 100);
    }

    private class AnimalClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            score++;
            scoreLabel.setText("Score: " + score);
            moveAnimal();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CatchTheAnimal game = new CatchTheAnimal();
            game.setVisible(true);
        });
    }
}
