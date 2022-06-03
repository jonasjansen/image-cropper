package gui.events;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FilenameFilter;

public class CheckDigitStatus implements ActionListener {


    private final File digitImageFolder;
    private final JLabel statusLabel;

    public CheckDigitStatus(File digitImageFolder, JLabel statusLabel) {
        super();
        this.digitImageFolder = digitImageFolder;
        this.statusLabel = statusLabel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean hasDigitImages = this.hasImageFiles(this.digitImageFolder);

        if(hasDigitImages) {
            this.statusLabel.setText("STATUS: OK");
            this.statusLabel.setForeground(Color.GREEN);
        } else {
            this.statusLabel.setText("STATUS: Crop Digits");
            this.statusLabel.setForeground(Color.RED);
        }
    }

    public boolean hasImageFiles(File folder) {
        File[] files = folder.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(".jpg");
            }
        });

        if (files != null) {
            for (final File fileEntry : files) {
                if (fileEntry.isFile()) {
                    return true;
                }
            }
        }
        return false;
    }
}

