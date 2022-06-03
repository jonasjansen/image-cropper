package gui.events;

import gui.frames.DigitProcessFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class OpenDigitProcessFrame implements ActionListener {


    private final File baseFolder;

    public OpenDigitProcessFrame(File baseFolder) {
        super();
        this.baseFolder = baseFolder;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        DigitProcessFrame frame = new DigitProcessFrame();
        if (this.baseFolder != null) {
            frame.start(this.baseFolder);
        } else {
            JOptionPane.showMessageDialog(null, "No folder selected!", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}

