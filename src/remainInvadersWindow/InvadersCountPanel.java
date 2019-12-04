package remainInvadersWindow;

import model.GameInfoProvider;
import model.GameObserver;
import util.PropertiesDiskStorage;
import view.GraphicsPanel;
import view.ImageCache;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;

public class InvadersCountPanel extends GraphicsPanel implements GameObserver {
    public static final int DEFAULT_WIDTH = 800;
    public static final int DEFAULT_HEIGHT = 600;

    private GameInfoProvider gameInfo;
    private String remainInvaders;
    private List<String> imageNames;
    BufferedImage currentImage;


    public InvadersCountPanel(GameInfoProvider gameInfo) {
        JPanel invadersCountPanel = new JPanel();
        setBackground(Color.BLACK);
        this.gameInfo = gameInfo;
        imageNames = PropertiesDiskStorage.getInstance().getProperties("invader");
        currentImage = ImageCache.getInstance().getImage(imageNames.get(1));
    }
    public synchronized void gameChanged() {
    }

}
