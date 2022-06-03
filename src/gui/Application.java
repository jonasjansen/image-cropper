package gui;

import gui.frames.DisplayProcessFrame;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.File;

public class Application extends JFrame {

    File baseFolder;
    JTextField folderText;

    public void start() {

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Button: Folder Chooser Button
        JButton openFolderButton = new JButton("Open Folder");
        openFolderButton.addActionListener(e -> {
            selectFile();
        });
        openFolderButton.setPreferredSize(new Dimension(200, 30));

        // Text field with folder
        this.folderText = new JTextField("Choose folder");
        this.folderText.setPreferredSize(new Dimension(200, 30));

        // Button: Start Cropping
        JButton corpDisplayButton = new JButton("Crop Displays");
        add(corpDisplayButton);
        corpDisplayButton.addActionListener(e -> {
            startDisplayCropping();
        });
        corpDisplayButton.setPreferredSize(new Dimension(200, 30));

        // Create panel
        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Add elements to panel
        panel.add(openFolderButton);
        panel.add(Box.createVerticalStrut(20));
        panel.add(this.folderText);
        panel.add(Box.createVerticalStrut(20));
        panel.add(corpDisplayButton);

        frame.add(panel, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }

    public void selectFile() {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            this.baseFolder = chooser.getSelectedFile();
            folderText.setText(baseFolder.getPath());
        } else {
            System.out.println("No folder was selected");
        }
    }

    public void startDisplayCropping() {
        DisplayProcessFrame App = new DisplayProcessFrame();
        if (this.baseFolder != null) {
            App.start(this.baseFolder);
        } else {
            JOptionPane.showMessageDialog(null, "No folder selected!", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
