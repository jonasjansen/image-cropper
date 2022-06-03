package gui.panels;

import entities.CroppedImage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ImageCropPanel extends JPanel {

    int x, y, x2, y2;
    private CroppedImage croppedImage;

    public ImageCropPanel(CroppedImage croppedImage) {
        x = y = x2 = y2 = 0; //
        MyMouseListener listener = new MyMouseListener();
        addMouseListener(listener);
        addMouseMotionListener(listener);
        this.croppedImage = croppedImage;
    }

    public void setCroppedImage(CroppedImage image) {
        this.croppedImage = image;
    }

    public void setStartPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setEndPoint(int x, int y) {
        x2 = (x);
        y2 = (y);
    }

    public void drawPerfectRect(Graphics g, int x, int y, int x2, int y2) {
        int px = Math.min(x,x2);
        int py = Math.min(y,y2);
        int pw=Math.abs(x-x2);
        int ph=Math.abs(y-y2);
        g.drawRect(px, py, pw, ph);
        this.croppedImage.updateCroppedArea(px, py, pw, ph);
    }

    class MyMouseListener extends MouseAdapter {

        public void mousePressed(MouseEvent e) {
            setStartPoint(e.getX(), e.getY());
        }

        public void mouseDragged(MouseEvent e) {
            setEndPoint(e.getX(), e.getY());
            repaint();
        }

        public void mouseReleased(MouseEvent e) {
            setEndPoint(e.getX(), e.getY());
            repaint();
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(croppedImage.getCurrentFirstImage(), 0, 0, this);
        g.setColor(Color.RED);
        drawPerfectRect(g, x, y, x2, y2);
    }

    public void rotate(double angle) {
        this.croppedImage.rotateImageByDegrees(angle);
        this.setPreferredSize(new Dimension(this.croppedImage.getCurrentFirstImage().getWidth(), this.croppedImage.getCurrentFirstImage().getHeight()));
        this.repaint();
    }

    public void resetImage() {
        this.croppedImage.setCurrentFirstImage(this.croppedImage.getOriginalFirstImage());
        this.croppedImage.setCroppedFirstImage(this.croppedImage.getOriginalFirstImage());
    }
}