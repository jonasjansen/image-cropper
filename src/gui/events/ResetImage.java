package gui.events;

import gui.panels.ImageCropPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResetImage implements ActionListener {

    private final ImageCropPanel cropPanel;

    public ResetImage(ImageCropPanel frame) {
        super();
        this.cropPanel = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.cropPanel.resetImage();
        this.cropPanel.repaint();
    }
}

