package remainInvadersWindow;

import model.GameInfoProvider;
import view.GameInfoPanel;
import view.GamePanel;
import view.ViewPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;

public class InvadersCountFrame extends JFrame{
    public static final int DEFAULT_WIDTH = 800;
    public static final int DEFAULT_HEIGHT = 600;
    private GameInfoProvider gameInfo;

    public InvadersCountFrame(GameInfoProvider gameInfo) {
        setTitle("Remaining Invaders");
        setSize(DEFAULT_WIDTH/2,DEFAULT_HEIGHT/2);
        setFocusableWindowState(false);
        setLocation(DEFAULT_WIDTH + 5, 0);
        this.gameInfo = gameInfo;

        InvadersCountPanel invadersCountPanel = new InvadersCountPanel(gameInfo);
        this.add(invadersCountPanel);
        this.setVisible(true);
        gameInfo.addObserver(invadersCountPanel);
    }
}
