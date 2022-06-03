package gui.events;

import entities.CroppedImage;
import gui.frames.ImageCropFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OpenCropPanel implements ActionListener {

    private final CroppedImage image;
    private final ImageCropFrame imageCropFrame;

    public OpenCropPanel(CroppedImage image) {
        super();
        this.imageCropFrame = new ImageCropFrame(image);
        this.image = image;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(this.image != null) {
            System.out.println("Process image");
            this.imageCropFrame.show();
        } else {
            System.out.println("No image was provided!");
        }
    }
}

