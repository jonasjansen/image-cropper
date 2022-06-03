package gui.events;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class OpenExplorerFolder implements ActionListener {


    private final File folder;

    public OpenExplorerFolder(File folder) {
        super();
        this.folder = folder;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            Desktop.getDesktop().open(this.folder);
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(
                    null,
                    "Could open folder: " + this.folder.getPath(),
                    "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
