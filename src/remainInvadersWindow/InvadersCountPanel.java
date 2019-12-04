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

/**
 * The panel to show the number of remaining invaders and its images
 * It is an observer of the game model in order to be notified of changes,
 * and it accesses information from the game via the GameInfoProvider interface.
 */
public class InvadersCountPanel extends GraphicsPanel implements GameObserver {
    /**
     * The object that provides information about the game.
     */
    private GameInfoProvider gameInfo;

    /**
     * List of all images of the invaders
     */
    private List<String> imageNames;

    /**
     * The name of the image (in the imageName list) that is being used
     */
    private String currentImage;

    /**
     * The index of the image (in the imageNames list) that is being used
     */
    private int imageIndex;

    /**
     * The number of remaining invaders in the game
     */
    private int remainInvadersCount;

    /**
     * Initialize the invadersCount panel, including setting it up for double buffering.
     * @param gameInfo the source for information about the game
     */
    public InvadersCountPanel(GameInfoProvider gameInfo) {
        this.gameInfo = gameInfo;
        setDoubleBuffered(true);
        imageNames = PropertiesDiskStorage.getInstance().getProperties("invader"); // list of all images of the invaders
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

    /**
     * Paint the image of the invaders as well as the number of remaining invaders on the panel
     * @param g the graphics to use to paint the view
     */
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

        bufferedGraphics.setPaint(Color.RED);
        drawString(100, 250, "Remaining Invaders: ",
                16, bufferedGraphics);
        drawString(285, 250, Integer.toString(remainInvadersCount),
                25, bufferedGraphics);
    }
}
