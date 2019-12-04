package remainInvadersWindow;

import model.GameInfoProvider;
import model.GameObject;
import model.GameObserver;
import util.PropertiesDiskStorage;
import view.GraphicsPanel;
import view.ImageCache;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;

public class InvadersCountPanel extends GraphicsPanel implements GameObserver {
    private GameInfoProvider gameInfo;
    private int remainInvaders;
    private List<String> imageNames;
    BufferedImage currentImage;


    public InvadersCountPanel(GameInfoProvider gameInfo) {
        this.gameInfo = gameInfo;
        setDoubleBuffered(true);
    }
    /**
     * When the game changes, repaint
     */
    public synchronized void gameChanged() {
        repaint();
    }

    @Override
    public synchronized void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D bufferedGraphics = (Graphics2D) g;
        bufferedGraphics.setPaint(Color.BLACK);
        bufferedGraphics.fillRect(0, 0, getWidth(), getHeight());

//        for (String imageName : imageNames)
//            drawImage(object.getX(), object.getY(), object.getWidth(), object.getHeight(),
//                    object.getCurrentImageName(), bufferedGraphics);

        bufferedGraphics.setPaint(Color.GREEN);
        drawString(100, 250, "Remaining Invaders: "+ gameInfo.getRemainInvaders(),
                15, bufferedGraphics);

    }

}
