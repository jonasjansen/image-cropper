package gui.frames;

import entities.CroppedImage;
import gui.events.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.File;

public class DisplayProcessFrame extends JFrame {

    private final CroppedImage image1 = new CroppedImage();
    private final CroppedImage image2 = new CroppedImage();
    private final CroppedImage image3 = new CroppedImage();
    private final CroppedImage image4 = new CroppedImage();
    private final CroppedImage image5 = new CroppedImage();
    private File baseFolder;

    public void start(File baseFolder) {
        this.baseFolder = baseFolder;

        try {
            image1.setImageFolder(
                    new File(baseFolder.getPath() + "\\bilder") ,
                    new File(baseFolder.getPath() + "\\displays\\display_1\\bilder"),
                    "display_1",
                    baseFolder.getPath()+ "\\displays\\display_1"
            );
            image2.setImageFolder(
                    new File(baseFolder.getPath() + "\\bilder") ,
                    new File(baseFolder.getPath() + "\\displays\\display_2\\bilder"),
                    "display_2",
                    baseFolder.getPath()+ "\\displays\\display_2"
            );
            image3.setImageFolder(
                    new File(baseFolder.getPath() + "\\bilder") ,
                    new File(baseFolder.getPath() + "\\displays\\display_3\\bilder"),
                    "display_3",
                    baseFolder.getPath()+ "\\displays\\display_3"
            );
            image4.setImageFolder(
                    new File(baseFolder.getPath() + "\\bilder") ,
                    new File(baseFolder.getPath() + "\\displays\\display_4\\bilder"),
                    "display_4",
                    baseFolder.getPath()+ "\\displays\\display_4"
            );
            image5.setImageFolder(
                    new File(baseFolder.getPath() + "\\bilder") ,
                    new File(baseFolder.getPath() + "\\displays\\display_5\\bilder"),
                    "display_5",
                    baseFolder.getPath()+ "\\displays\\display_5"
            );
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        this.createLayout();
    }

    private void createLayout() {
        // Display 1
        JLabel title1 = new JLabel();
        title1.setText("DISPLAY 1");

        // Elements
        JLabel status1 = new JLabel();
        // Can be "Crop Dispay" "Crop Digits" "OK"
        status1.setText("STATUS: Crop Displays");
        status1.setForeground(Color.RED);

        JButton buttonStatus1 = new JButton("Check Status");
        buttonStatus1.setPreferredSize(new Dimension(150, 30));
        buttonStatus1.addActionListener(new CheckDisplayStatus(
                new File(this.baseFolder.getPath() + "\\displays\\display_1\\bilder"),
                new File(this.baseFolder.getPath() + "\\displays\\display_1\\digits\\digit_1\\bilder"),
                status1));

        JButton buttonCrop1 = new JButton("Select Crop");
        buttonCrop1.setPreferredSize(new Dimension(150, 30));
        buttonCrop1.addActionListener(new OpenCropPanel(image1));


        JButton buttonShowFirst1 = new JButton("Show First Image");
        buttonShowFirst1.setPreferredSize(new Dimension(150, 30));
        buttonShowFirst1.addActionListener(new ShowCroppedImage(image1, "FIRST"));

        JButton buttonShowLast1 = new JButton("Show Last Image");
        buttonShowLast1.setPreferredSize(new Dimension(150, 30));
        buttonShowLast1.addActionListener(new ShowCroppedImage(image1, "LAST"));

        JButton buttonSave1 = new JButton("Save");
        buttonSave1.setPreferredSize(new Dimension(150, 30));
        buttonSave1.addActionListener(new SaveCroppedImage(image1));

        JButton buttonOpenFolder1 = new JButton("Open Folder");
        buttonOpenFolder1.setPreferredSize(new Dimension(150, 30));
        buttonOpenFolder1.addActionListener(
                new OpenExplorerFolder(new File(baseFolder.getPath() + "\\displays\\display_1\\bilder"))
        );

        JButton buttonDigits1 = new JButton("Digits");
        buttonDigits1.setPreferredSize(new Dimension(150, 30));
        buttonDigits1.addActionListener(
                new OpenDigitProcessFrame(new File(baseFolder.getPath() + "\\displays\\display_1"))
        );

        // Layout
        JPanel panelLeft1 = new JPanel();
        JPanel panelRight1 = new JPanel();
        panelLeft1.setLayout( new GridLayout( 7, 1 ) );
        panelRight1.setLayout( new GridLayout( 7, 1 ) );

        panelLeft1.add(title1);
        panelLeft1.add(status1);
        panelLeft1.add(buttonCrop1);
        panelLeft1.add(buttonShowFirst1);
        panelLeft1.add(buttonSave1);
        panelLeft1.add(buttonDigits1);

        panelRight1.add(new JLabel());
        panelRight1.add(buttonStatus1);
        panelRight1.add(new JLabel());
        panelRight1.add(buttonShowLast1);
        panelRight1.add(buttonOpenFolder1);
        panelRight1.add(new JLabel());

        // Display 2
        JLabel title2 = new JLabel();
        title2.setText("DISPLAY 2");

        // Elements
        JLabel status2 = new JLabel();
        // Can be "Crop Dispay" "Crop Digits" "OK"
        status2.setText("STATUS: Crop Displays");
        status2.setForeground(Color.RED);

        JButton buttonStatus2 = new JButton("Check Status");
        buttonStatus2.setPreferredSize(new Dimension(150, 30));
        buttonStatus2.addActionListener(new CheckDisplayStatus(
                new File(this.baseFolder.getPath() + "\\displays\\display_2\\bilder"),
                new File(this.baseFolder.getPath() + "\\displays\\display_2\\digits\\digit_1\\bilder"),
                status2));

        JButton buttonCrop2 = new JButton("Select Crop");
        buttonCrop2.setPreferredSize(new Dimension(150, 30));
        buttonCrop2.addActionListener(new OpenCropPanel(image2));


        JButton buttonShowFirst2 = new JButton("Show First Image");
        buttonShowFirst2.setPreferredSize(new Dimension(150, 30));
        buttonShowFirst2.addActionListener(new ShowCroppedImage(image2, "FIRST"));

        JButton buttonShowLast2 = new JButton("Show Last Image");
        buttonShowLast2.setPreferredSize(new Dimension(150, 30));
        buttonShowLast2.addActionListener(new ShowCroppedImage(image2, "LAST"));

        JButton buttonSave2 = new JButton("Save");
        buttonSave2.setPreferredSize(new Dimension(150, 30));
        buttonSave2.addActionListener(new SaveCroppedImage(image2));

        JButton buttonOpenFolder2 = new JButton("Open Folder");
        buttonOpenFolder2.setPreferredSize(new Dimension(150, 30));
        buttonOpenFolder2.addActionListener(
                new OpenExplorerFolder(new File(baseFolder.getPath() + "\\displays\\display_2\\bilder"))
        );

        JButton buttonDigits2 = new JButton("Digits");
        buttonDigits2.setPreferredSize(new Dimension(150, 30));
        buttonDigits2.addActionListener(
                new OpenDigitProcessFrame(new File(baseFolder.getPath() + "\\displays\\display_2"))
        );

        // Layout

        JPanel panelLeft2 = new JPanel();
        JPanel panelRight2 = new JPanel();
        panelLeft2.setLayout( new GridLayout( 7, 1 ) );
        panelRight2.setLayout( new GridLayout( 7, 1 ) );

        panelLeft2.add(title2);
        panelLeft2.add(status2);
        panelLeft2.add(buttonCrop2);
        panelLeft2.add(buttonShowFirst2);
        panelLeft2.add(buttonSave2);
        panelLeft2.add(buttonDigits2);

        panelRight2.add(new JLabel());
        panelRight2.add(buttonStatus2);
        panelRight2.add(new JLabel());
        panelRight2.add(buttonShowLast2);
        panelRight2.add(buttonOpenFolder2);
        panelRight2.add(new JLabel());

        // Display 3
        JLabel title3 = new JLabel();
        title3.setText("DISPLAY 3");

        // Elements
        JLabel status3 = new JLabel();
        // Can be "Crop Dispay" "Crop Digits" "OK"
        status3.setText("STATUS: Crop Displays");
        status3.setForeground(Color.RED);

        JButton buttonStatus3 = new JButton("Check Status");
        buttonStatus3.setPreferredSize(new Dimension(150, 30));
        buttonStatus3.addActionListener(new CheckDisplayStatus(
                new File(this.baseFolder.getPath() + "\\displays\\display_3\\bilder"),
                new File(this.baseFolder.getPath() + "\\displays\\display_3\\digits\\digit_1\\bilder"),
                status3));

        JButton buttonCrop3 = new JButton("Select Crop");
        buttonCrop3.setPreferredSize(new Dimension(150, 30));
        buttonCrop3.addActionListener(new OpenCropPanel(image3));


        JButton buttonShowFirst3 = new JButton("Show First Image");
        buttonShowFirst3.setPreferredSize(new Dimension(150, 30));
        buttonShowFirst3.addActionListener(new ShowCroppedImage(image3, "FIRST"));

        JButton buttonShowLast3 = new JButton("Show Last Image");
        buttonShowLast3.setPreferredSize(new Dimension(150, 30));
        buttonShowLast3.addActionListener(new ShowCroppedImage(image3, "LAST"));

        JButton buttonSave3 = new JButton("Save");
        buttonSave3.setPreferredSize(new Dimension(150, 30));
        buttonSave3.addActionListener(new SaveCroppedImage(image3));

        JButton buttonOpenFolder3 = new JButton("Open Folder");
        buttonOpenFolder3.setPreferredSize(new Dimension(150, 30));
        buttonOpenFolder3.addActionListener(
                new OpenExplorerFolder(new File(baseFolder.getPath() + "\\displays\\display_3\\bilder"))
        );

        JButton buttonDigits3 = new JButton("Digits");
        buttonDigits3.setPreferredSize(new Dimension(150, 30));
        buttonDigits3.addActionListener(
                new OpenDigitProcessFrame(new File(baseFolder.getPath() + "\\displays\\display_3"))
        );

        // Layout

        JPanel panelLeft3 = new JPanel();
        JPanel panelRight3 = new JPanel();
        panelLeft3.setLayout( new GridLayout( 7, 1 ) );
        panelRight3.setLayout( new GridLayout( 7, 1 ) );

        panelLeft3.add(title3);
        panelLeft3.add(status3);
        panelLeft3.add(buttonCrop3);
        panelLeft3.add(buttonShowFirst3);
        panelLeft3.add(buttonSave3);
        panelLeft3.add(buttonDigits3);

        panelRight3.add(new JLabel());
        panelRight3.add(buttonStatus3);
        panelRight3.add(new JLabel());
        panelRight3.add(buttonShowLast3);
        panelRight3.add(buttonOpenFolder3);
        panelRight3.add(new JLabel());

        // Display 4
        JLabel title4 = new JLabel();
        title4.setText("DISPLAY 4");

        // Elements
        JLabel status4 = new JLabel();
        // Can be "Crop Dispay" "Crop Digits" "OK"
        status4.setText("STATUS: Crop Displays");
        status4.setForeground(Color.RED);

        JButton buttonStatus4 = new JButton("Check Status");
        buttonStatus4.setPreferredSize(new Dimension(150, 30));
        buttonStatus4.addActionListener(new CheckDisplayStatus(
                new File(this.baseFolder.getPath() + "\\displays\\display_4\\bilder"),
                new File(this.baseFolder.getPath() + "\\displays\\display_4\\digits\\digit_1\\bilder"),
                status4));

        JButton buttonCrop4 = new JButton("Select Crop");
        buttonCrop4.setPreferredSize(new Dimension(150, 30));
        buttonCrop4.addActionListener(new OpenCropPanel(image4));


        JButton buttonShowFirst4 = new JButton("Show First Image");
        buttonShowFirst4.setPreferredSize(new Dimension(150, 30));
        buttonShowFirst4.addActionListener(new ShowCroppedImage(image4, "FIRST"));

        JButton buttonShowLast4 = new JButton("Show Last Image");
        buttonShowLast4.setPreferredSize(new Dimension(150, 30));
        buttonShowLast4.addActionListener(new ShowCroppedImage(image4, "LAST"));

        JButton buttonSave4 = new JButton("Save");
        buttonSave4.setPreferredSize(new Dimension(150, 30));
        buttonSave4.addActionListener(new SaveCroppedImage(image4));

        JButton buttonOpenFolder4 = new JButton("Open Folder");
        buttonOpenFolder4.setPreferredSize(new Dimension(150, 30));
        buttonOpenFolder4.addActionListener(
                new OpenExplorerFolder(new File(baseFolder.getPath() + "\\displays\\display_4\\bilder"))
        );

        JButton buttonDigits4 = new JButton("Digits");
        buttonDigits4.setPreferredSize(new Dimension(150, 30));
        buttonDigits4.addActionListener(
                new OpenDigitProcessFrame(new File(baseFolder.getPath() + "\\displays\\display_4"))
        );

        // Layout

        JPanel panelLeft4 = new JPanel();
        JPanel panelRight4 = new JPanel();
        panelLeft4.setLayout( new GridLayout( 7, 1 ) );
        panelRight4.setLayout( new GridLayout( 7, 1 ) );

        panelLeft4.add(title4);
        panelLeft4.add(status4);
        panelLeft4.add(buttonCrop4);
        panelLeft4.add(buttonShowFirst4);
        panelLeft4.add(buttonSave4);
        panelLeft4.add(buttonDigits4);

        panelRight4.add(new JLabel());
        panelRight4.add(buttonStatus4);
        panelRight4.add(new JLabel());
        panelRight4.add(buttonShowLast4);
        panelRight4.add(buttonOpenFolder4);
        panelRight4.add(new JLabel());

        // Display 5
        JLabel title5 = new JLabel();
        title5.setText("DISPLAY 5");

        // Elements
        JLabel status5 = new JLabel();
        // Can be "Crop Dispay" "Crop Digits" "OK"
        status5.setText("STATUS: Crop Displays");
        status5.setForeground(Color.RED);

        JButton buttonStatus5 = new JButton("Check Status");
        buttonStatus5.setPreferredSize(new Dimension(150, 30));
        buttonStatus5.addActionListener(new CheckDisplayStatus(
                new File(this.baseFolder.getPath() + "\\displays\\display_5\\bilder"),
                new File(this.baseFolder.getPath() + "\\displays\\display_5\\digits\\digit_1\\bilder"),
                status5));

        JButton buttonCrop5 = new JButton("Select Crop");
        buttonCrop5.setPreferredSize(new Dimension(150, 30));
        buttonCrop5.addActionListener(new OpenCropPanel(image5));

        JButton buttonShowFirst5 = new JButton("Show First Image");
        buttonShowFirst5.setPreferredSize(new Dimension(150, 30));
        buttonShowFirst5.addActionListener(new ShowCroppedImage(image5, "FIRST"));

        JButton buttonShowLast5 = new JButton("Show Last Image");
        buttonShowLast5.setPreferredSize(new Dimension(150, 30));
        buttonShowLast5.addActionListener(new ShowCroppedImage(image5, "LAST"));

        JButton buttonSave5 = new JButton("Save");
        buttonSave5.setPreferredSize(new Dimension(150, 30));
        buttonSave5.addActionListener(new SaveCroppedImage(image5));

        JButton buttonOpenFolder5 = new JButton("Open Folder");
        buttonOpenFolder5.setPreferredSize(new Dimension(150, 30));
        buttonOpenFolder5.addActionListener(
                new OpenExplorerFolder(new File(baseFolder.getPath() + "\\displays\\display_5\\bilder"))
        );

        JButton buttonDigits5 = new JButton("Digits");
        buttonDigits5.setPreferredSize(new Dimension(150, 30));
        buttonDigits5.addActionListener(
                new OpenDigitProcessFrame(new File(baseFolder.getPath() + "\\displays\\display_5"))
        );

        // Layout

        JPanel panelLeft5 = new JPanel();
        JPanel panelRight5 = new JPanel();
        panelLeft5.setLayout( new GridLayout( 7, 1 ) );
        panelRight5.setLayout( new GridLayout( 7, 1 ) );

        panelLeft5.add(title5);
        panelLeft5.add(status5);
        panelLeft5.add(buttonCrop5);
        panelLeft5.add(buttonShowFirst5);
        panelLeft5.add(buttonSave5);
        panelLeft5.add(buttonDigits5);

        panelRight5.add(new JLabel());
        panelRight5.add(buttonStatus5);
        panelRight5.add(new JLabel());
        panelRight5.add(buttonShowLast5);
        panelRight5.add(buttonOpenFolder5);
        panelRight5.add(new JLabel());

        // Main Layout
        JFrame frame = new EscapableFrame() {
        };
        JPanel panel = new JPanel();

        panel.add(panelLeft1);
        panel.add(panelRight1);
        panel.add(new JLabel());
        panel.add(panelLeft2);
        panel.add(panelRight2);
        panel.add(new JLabel());
        panel.add(panelLeft3);
        panel.add(panelRight3);
        panel.add(new JLabel());
        panel.add(panelLeft4);
        panel.add(panelRight4);
        panel.add(new JLabel());
        panel.add(panelLeft5);
        panel.add(panelRight5);

        panel.setBorder(new EmptyBorder(20, 20, 20, 20));
        frame.add(panel, BorderLayout.CENTER);
        frame.setTitle("Crop Displays");
        frame.pack();
        frame.setVisible(true);
    }
}
