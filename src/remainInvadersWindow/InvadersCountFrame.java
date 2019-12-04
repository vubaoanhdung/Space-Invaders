/*
Damon Vu
11261393
bav965
 */

package remainInvadersWindow;

import model.GameInfoProvider;
import javax.swing.*;

/**
 * The view of the model-view controller architecture. This view is a frame used to display the images
 * of invaders as well as the number of remaining invaders in the game. The new window will appear
 * beside the game window.
 */
public class InvadersCountFrame extends JFrame{
    public static final int DEFAULT_WIDTH = 800;
    public static final int DEFAULT_HEIGHT = 600;

    /**
     * An interface to the game with the methods that the Controller can apply to the game.
     */
    private GameInfoProvider gameInfo;

    /**
     * Initialize the frame of the new window, where width and height are half of width and height of the
     * game window
     * @param gameInfo An interface to the game with the methods that the Controller can apply to the game.
     */
    public InvadersCountFrame(GameInfoProvider gameInfo) {
        setTitle("Remaining Invaders");
        setSize(DEFAULT_WIDTH/2,DEFAULT_HEIGHT/2);
        setFocusableWindowState(false);
        setLocation(DEFAULT_WIDTH + 5, 0);
        this.gameInfo = gameInfo;

        // create the InvadersCountPanel and add it to the frame
        InvadersCountPanel invadersCountPanel = new InvadersCountPanel(gameInfo);
        // the invadersCountPanel panel is to be informed when the game changes so that it can be updated
        gameInfo.addObserver(invadersCountPanel);
        this.add(invadersCountPanel);
        this.setVisible(true);
    }
}
