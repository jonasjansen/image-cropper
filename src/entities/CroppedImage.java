package entities;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CroppedImage {

    BufferedImage originalFirstImage;
    BufferedImage currentFirstImage;
    BufferedImage croppedFirstImage;

    BufferedImage originalLastImage;
    BufferedImage currentLastImage;
    BufferedImage croppedLastImage;

    List<String> imageNames;
    File imageFolder;
    File newImageFolder;
    private String newImagePrefix;
    private String baseFolder;

    int start_x = 0;
    int start_y = 0;

    int width = 0;
    int height = 0;

    double angle = 0;

    public CroppedImage() {
    }

    public void setImageFolder(File imageFolder, File newImageFolder, String newImagePrefix, String baseFolder) {
        this.imageFolder = imageFolder;
        this.newImageFolder = newImageFolder;
        this.newImagePrefix = newImagePrefix;
        this.baseFolder = baseFolder;
        this.saveImageNames();
        try {
            int lastImagePosition = this.imageNames.size();
            this.setFirstImage(ImageIO.read(new File(imageFolder.getPath() + "\\" + this.imageNames.get(0))));
            this.setLastImage(ImageIO.read(new File(imageFolder.getPath() + "\\" + this.imageNames.get(lastImagePosition - 1))));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(
                    null,
                    "Could open first image of folder: " + imageFolder.getPath(),
                    "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void saveImageNames() {
        this.imageNames = new ArrayList<>();
        File[] files = this.imageFolder.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(".jpg");
            }
        });

        if (files != null) {
            for (final File fileEntry : files) {
                if (fileEntry.isFile()) {
                    this.imageNames.add(fileEntry.getName());
                }
            }
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "Could not process image folder: " + this.imageFolder.getPath(),
                    "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void setFirstImage(BufferedImage image) {
        this.setOriginalFirstImage(image);
        this.setCurrentFirstImage(image);
        this.setCroppedFirstImage(image);
    }

    public void setLastImage(BufferedImage image) {
        this.setOriginalLastImage(image);
        this.setCurrentLastImage(image);
        this.setCroppedLastImage(image);
    }

    public void setOriginalFirstImage(BufferedImage image) {
        this.originalFirstImage = image;
    }

    public void setCurrentFirstImage(BufferedImage image) {
        this.currentFirstImage = image;
    }

    public void setCroppedFirstImage(BufferedImage image) {
        this.croppedFirstImage = image;
    }

    public void setOriginalLastImage(BufferedImage image) {
        this.originalLastImage = image;
    }

    public void setCurrentLastImage(BufferedImage image) {
        this.currentLastImage = image;
    }

    public void setCroppedLastImage(BufferedImage image) {
        this.croppedLastImage = image;
    }

    public void setAngle(double angle) {
        angle = angle % 360;
        if (angle < 0) {
            angle = 360 + angle;
        }
        this.angle = angle;
    }

    public BufferedImage getOriginalFirstImage() {
        return this.originalFirstImage;
    }

    public BufferedImage getCurrentFirstImage() {
        return this.currentFirstImage;
    }

    public BufferedImage getCroppedFirstImage() {
        return this.croppedFirstImage;
    }

    public BufferedImage getCroppedLastImage() {
        return this.croppedLastImage;
    }

    public double getAngle() {
        return this.angle;
    }

    public void updateCroppedArea(int x, int y, int width, int height) {
        this.setArea(x, y, width, height);
        if (width > 0 && height > 0) {
            this.setCroppedFirstImage(this.currentFirstImage.getSubimage(this.start_x, this.start_y, this.width, this.height));
            this.setCroppedLastImage(this.currentLastImage.getSubimage(this.start_x, this.start_y, this.width, this.height));
        }
    }

    public void setArea(int x, int y, int width, int height) {
        this.start_x = x;
        this.start_y = y;
        this.width = width;
        this.height = height;
    }

    public BufferedImage getRotatedImage(double angle, BufferedImage originalImage) {
        JFrame observer = new JFrame();

        double full_angle = this.getAngle() + angle;
        this.setAngle(full_angle);

        double rads = Math.toRadians(full_angle);
        double sin = Math.abs(Math.sin(rads)), cos = Math.abs(Math.cos(rads));
        int w = originalImage.getWidth();
        int h = originalImage.getHeight();
        int newWidth = (int) Math.floor(w * cos + h * sin);
        int newHeight = (int) Math.floor(h * cos + w * sin);

        BufferedImage rotated = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = rotated.createGraphics();
        AffineTransform at = new AffineTransform();
        at.translate((int) ((newWidth - w) / 2), (int) ((newHeight - h) / 2));

        int x = w / 2;
        int y = h / 2;

        at.rotate(rads, x, y);
        g2d.setTransform(at);
        g2d.drawImage(originalImage, 0, 0, observer);
        g2d.setColor(Color.RED);
        g2d.drawRect(0, 0, newWidth - 1, newHeight - 1);
        g2d.dispose();
        return rotated;
    }

    public void rotateImageByDegrees(double angle) {
        this.setCurrentFirstImage(this.getRotatedImage(angle, this.getOriginalFirstImage()));
    }

    private BufferedImage getScaledImage(BufferedImage image, double scale) {
        int w = image.getWidth();
        int h = image.getHeight();
        BufferedImage after = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        AffineTransform at = new AffineTransform();
        at.scale(scale, scale);
        AffineTransformOp scaleOp =
                new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
        after = scaleOp.filter(image, after);
        return after;
    }

    public void saveCroppedImages() {
        for (String imageName : this.imageNames) {
            try {
                String newImageName = this.buildNewImageName(imageName);
                BufferedImage originalImage = ImageIO.read(new File(this.imageFolder.getPath() + "\\" + imageName));
                BufferedImage rotatedImage = this.getRotatedImage(this.angle, originalImage);
                BufferedImage croppedImage = rotatedImage.getSubimage(this.start_x, this.start_y, this.width, this.height);
                File newFile = new File(this.newImageFolder.getPath() + "\\" + newImageName);
                ImageIO.write(
                        croppedImage,
                        "jpg",
                        newFile);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(
                        null,
                        "Could save image " + imageName + " | " + ex.getLocalizedMessage(),
                        "Error", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        try (PrintWriter out = new PrintWriter(this.baseFolder + "\\crop_info.txt")) {
            out.println("start_x=" + Integer.toString(this.start_x));
            out.println("start_y=" + Integer.toString(this.start_y));
            out.println("width=" + Integer.toString(this.width));
            out.println("height=" + Integer.toString(this.height));
            out.println("angle=" + Double.toString(this.getAngle()));
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(
                    null,
                    "Could save cropping information | " + ex.getLocalizedMessage(),
                    "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public String buildNewImageName(String imageName) {
        StringBuilder newName = new StringBuilder();
        List<String> test =  new LinkedList<String>(Arrays.asList(imageName.split("_")));

        String lastEntry = test.get(test.size() - 1);
        test.remove(test.size() - 1);
        String secondLastEntry = test.get(test.size() - 1);
        test.remove(test.size() - 1);

        for(String part:test) {
            newName.append((String) (part + "_"));
        }

        for(String newPart:this.newImagePrefix.split("_")) {
            newName.append((String) (newPart + "_"));
        }
        newName.append((String) (secondLastEntry + "_"));
        newName.append((String) (lastEntry));
        return newName.toString();
    }
}
