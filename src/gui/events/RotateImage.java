package gui.events;

import gui.panels.ImageCropPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RotateImage implements ActionListener {

    private final ImageCropPanel cropPanel;
    private final double degree;

    public RotateImage(ImageCropPanel frame, double degree) {
        super();
        this.cropPanel = frame;
        this.degree = degree;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.cropPanel.rotate(this.degree);
    }
}

