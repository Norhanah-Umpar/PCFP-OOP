// SecondPanel.java
import javax.swing.*;
import java.awt.*;

public class AboutPanel {
    private JPanel panel;

    public AboutPanel() {
        panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        JLabel trackerLabel = new JLabel("ABOUT");
        trackerLabel.setFont(new Font("SansSerif", Font.PLAIN, 40));
        trackerLabel.setForeground(new Color(0, 100, 0));

        panel.add(trackerLabel);
        // Add other components as needed
    }

    public JPanel getPanel() {
        return panel;
    }
}
