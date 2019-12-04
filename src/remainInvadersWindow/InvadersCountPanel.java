/*
Damon Vu
11261393
bav965
 */

package remainInvadersWindow;

import model.GameInfoProvider;
import model.GameObserver;
import util.PropertiesDiskStorage;
import view.GraphicsPanel;
import java.awt.*;
import java.util.List;

public class InvadersCountPanel extends GraphicsPanel implements GameObserver {
    private GameInfoProvider gameInfo;
    private List<String> imageNames;
    private String currentImage;
    private int imageIndex;
    private int remainInvadersCount;


    public InvadersCountPanel(GameInfoProvider gameInfo) {
        this.gameInfo = gameInfo;
        setDoubleBuffered(true);
        imageNames = PropertiesDiskStorage.getInstance().getProperties("invader");
        imageIndex = 1;
        currentImage = imageNames.get(imageIndex);
        remainInvadersCount = gameInfo.getRemainInvaders();
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

        if (gameInfo.getRemainInvaders() != remainInvadersCount){
            imageIndex = (imageIndex + 1) % imageNames.size();
            currentImage = imageNames.get(imageIndex);
            remainInvadersCount = gameInfo.getRemainInvaders();
        }
        drawImage(120, 30, 150, 150,
                currentImage, bufferedGraphics);

        bufferedGraphics.setPaint(Color.GREEN);
        drawString(100, 250, "Remaining Invaders: "+ remainInvadersCount,
                15, bufferedGraphics);

    }

}
