import com.formdev.flatlaf.FlatDarculaLaf;

import javax.swing.*;
import java.awt.*;

public class WindowDisplay {
    String message;
    private JFrame parent;
    public WindowDisplay(String message) {
        this.message = message;
    }

    public JFrame getJFrame(){
        return parent;
    }

    public void display() {
        FlatDarculaLaf.setup();
        parent = new JFrame("Window");
        GraphicsDevice gd = parent.getGraphicsConfiguration().getDevice();
        int width = (int) Math.round(gd.getDisplayMode().getWidth() * .2);
        int height = (int) Math.round(gd.getDisplayMode().getHeight() * .2);
        parent.setSize(width, height);
        parent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel(message);
        parent.add(label);

        parent.setVisible(true);
    }
}

