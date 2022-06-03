package gui.events;

import entities.CroppedImage;
import gui.panels.ImageCropPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SaveCroppedImage implements ActionListener {

    private final CroppedImage image;

    public SaveCroppedImage(CroppedImage image) {
        super();
        this.image = image;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.image.saveCroppedImages();
    }
}

