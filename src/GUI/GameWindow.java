package GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameWindow{
    static JFrame frame;
    // IMPORTANT This is a Prototype for the GUI. It is neither connected to the rest of the program
    GameWindow() throws IOException {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BufferedImage img = ImageIO.read(this.getClass().getResourceAsStream("/ScaledMap.png"));
        ImageIcon icon = new ImageIcon(img);
        frame.setLayout(new FlowLayout());
        frame.setSize(900, 615);
        JLabel label = new JLabel();
        label.setIcon(icon);
        frame.add(label);
        frame.setVisible(true);
    }
    //This was my first try of creatin the GUI, not working, therefore commented out
    /*public static void createGUI(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        ImageIcon icon = new ImageIcon("Map.png");

        JLabel label = new JLabel();
        label.setIcon(icon);


        frame.add(label);
        frame.pack();
        frame.setSize(1280, 800);
        frame.setVisible(true);


    }*/
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                try {
                    new GameWindow();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

    }
}