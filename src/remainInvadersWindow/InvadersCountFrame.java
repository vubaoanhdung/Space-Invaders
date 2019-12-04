package remainInvadersWindow;

import model.GameInfoProvider;

import javax.swing.*;
import java.awt.*;

public class InvadersCountFrame extends JFrame{
    public static final int DEFAULT_WIDTH = 800;
    public static final int DEFAULT_HEIGHT = 600;
    private GameInfoProvider gameInfo;

    public InvadersCountFrame() {
        setTitle("Remaining Invaders");
        setSize(DEFAULT_WIDTH/2,DEFAULT_HEIGHT/2);
        setFocusableWindowState(false);
        setLocation(DEFAULT_WIDTH+5, 0);

        InvadersCountPanel panel = new InvadersCountPanel(gameInfo);
        add(panel);
    }

}
