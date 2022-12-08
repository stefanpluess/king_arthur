package GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.File;


public class GameWindow {
    private static void createAndShowGUI(Game.GameControl gameControl, ,  board.GameState state) {
        //Create and set up the window.
        JFrame frame = new JFrame("King Arthur");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);

        // create a layout panel
        JPanel layout = new JPanel(new BorderLayout());

        // Board Component
        StateBoardComponent boardComponent = StateBoardComponent.initialize(gameControl, board, state);
        BufferedImage myPicture = ImageIO.read(new File("path-to-file"));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        add(picLabel);

        // Button Highlight
        JToggleButton button = new JToggleButton("Highlight Destinations: On");
        button.setPreferredSize(new Dimension(40, 40));
        ItemListener toggleListener = new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                boardComponent.toggleHighlightedDestination();
                if (button.isSelected()) {
                    button.setText("Highlight Destinations: Off");
                }
                else {
                    button.setText("Highlight Destinations: On");
                }
                boardComponent.doClick();
            }
        };
        button.addItemListener(toggleListener);
        layout.add(button, BorderLayout.NORTH);

        // Add layout to frame
        frame.add(layout);

        //Display the window
        frame.setTitle("Checkers Game");
        frame.setSize(600, 715);
        frame.setBounds(500, 100, 600, 715);
        frame.setVisible(true);
        frame.setResizable(false);
    }
}
