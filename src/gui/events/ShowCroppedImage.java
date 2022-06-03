package gui.events;

import entities.CroppedImage;
import gui.panels.ImagePanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShowCroppedImage implements ActionListener {

    private final CroppedImage image;
    private final String mode;

    public ShowCroppedImage(CroppedImage image, String mode) {
        super();
        this.image = image;
        this.mode = mode;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.image != null) {
            System.out.println("Process image");
            openImageCropPanel();
        } else {
            System.out.println("No image was provided!");
        }
    }

    private void openImageCropPanel() {
        JFrame f = new JFrame("Cropped Image");
        if (this.mode.equals("FIRST")) {
            f.setContentPane(new ImagePanel(this.image.getCroppedFirstImage()));
        } else if (this.mode.equals("LAST")) {
            f.setContentPane(new ImagePanel(this.image.getCroppedLastImage()));
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "Unknown mode : " + this.mode,
                    "Error", JOptionPane.INFORMATION_MESSAGE);
        }
        f.setSize(1920, 1080);
        f.setVisible(true);
    }
}

