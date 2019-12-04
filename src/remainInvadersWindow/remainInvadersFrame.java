package remainInvadersWindow;

import model.Game;
import model.GameInfoProvider;

import java.util.*;
import javax.swing.*;
import java.awt.*;

public class remainInvadersFrame extends JFrame{
    public static final int DEFAULT_WIDTH = 400;
    public static final int DEFAULT_HEIGHT = 300;

    public remainInvadersFrame() {
        setTitle("Remaining Invaders");
        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
        setBackground(Color.GREEN);
        remainInvadersPanel panel = new remainInvadersPanel();
        setFocusableWindowState(false);
        // add(panel)
    }

}
