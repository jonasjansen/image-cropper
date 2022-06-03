package gui.frames;

import entities.CroppedImage;
import gui.events.ResetImage;
import gui.events.RotateImage;
import gui.panels.ImageCropPanel;

import javax.swing.*;
import java.awt.*;

public class ImageCropFrame {

    private final JFrame frame;
    private final CroppedImage image;

    public ImageCropFrame(CroppedImage image) {
        this.frame =  new JFrame("Draw Box Mouse 2");
        this.frame.setSize(500, 500);
        this.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.image = image;

        // Create toolbar
        JToolBar toolbar = new JToolBar();
        toolbar.setRollover(true);

        // Create ImageCropPanel
        ImageCropPanel panel = new ImageCropPanel(this.image);
        panel.setBorder(BorderFactory.createLineBorder(Color.red));
        panel.setPreferredSize(new Dimension(this.image.getOriginalFirstImage().getWidth(), this.image.getOriginalFirstImage().getHeight()));

        // Add buttons to toolbar
        JButton rotateLeft90 = new JButton("Rotate Left 90");
        rotateLeft90.addActionListener(new RotateImage(panel, -90));
        toolbar.add(rotateLeft90);

        toolbar.addSeparator();

        JButton rotateLeft1 = new JButton("Rotate Left 1");
        rotateLeft1.addActionListener(new RotateImage(panel, -1));
        toolbar.add(rotateLeft1);

        toolbar.addSeparator();

        JButton rotateLeft01 = new JButton("Rotate Left 0.1");
        rotateLeft01.addActionListener(new RotateImage(panel, -0.1));
        toolbar.add(rotateLeft01);

        toolbar.addSeparator();
        toolbar.addSeparator();
        toolbar.addSeparator();

        JButton rotateRight01 = new JButton("Rotate Right 0.1");
        rotateRight01.addActionListener(new RotateImage(panel, 0.1));
        toolbar.add(rotateRight01);

        toolbar.addSeparator();

        JButton rotateRight1 = new JButton("Rotate Right 1");
        rotateRight1.addActionListener(new RotateImage(panel, 1));
        toolbar.add(rotateRight1);

        toolbar.addSeparator();

        JButton rotateRight90 = new JButton("Rotate Right 90");
        rotateRight90.addActionListener(new RotateImage(panel, 90));
        toolbar.add(rotateRight90);

        toolbar.addSeparator();
        toolbar.addSeparator();
        toolbar.addSeparator();

        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(new ResetImage(panel));
        toolbar.add(resetButton);

        // Add ImageCropPanel to a new scroll pane
        JScrollPane scroll = new JScrollPane(panel);

        // Add toolbar and scroll pane to frame
        Container contentPane = this.frame.getContentPane();
        contentPane.add(toolbar, BorderLayout.NORTH);
        contentPane.add(scroll, BorderLayout.CENTER);
    }

    public void show() {
        this.frame.setVisible(true);
    }
}
