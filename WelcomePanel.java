// WelcomePanel.java
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class WelcomePanel extends JPanel {

    private JPanel cardPanel;
    private CardLayout cardLayout;

    public WelcomePanel() {
        setBackground(new Color(144, 238, 144));

        JPanel welcomePanel = new JPanel(new BorderLayout());
        welcomePanel.setBackground(new Color(157, 181, 103));
        welcomePanel.setPreferredSize(new Dimension(welcomePanel.getWidth(), 100));

        JLabel welcomeLabel = new JLabel("Personal Carbon Footprint Tracker");
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("SansSerif", Font.PLAIN, 40));
        welcomeLabel.setForeground(Color.WHITE);
        
        welcomePanel.add(welcomeLabel, BorderLayout.CENTER);
        UserPanel userPanel = new UserPanel();
        TrackerPanel trackerPanel = new TrackerPanel();
        MemberPanel memberPanel = new MemberPanel();
        AboutPanel aboutPanel = new AboutPanel();
        
        //Set the preferred size for both buttons
        Dimension buttonSize = new Dimension(100, 200);
        Dimension imageSize = new Dimension(50, 50);

        // Create buttons
        JButton userButton = createHoverButton("User", "user.png", buttonSize, imageSize);
        JButton trackerButton = createHoverButton("Tracker", "radar.png", buttonSize, imageSize);
        JButton memberButton = createHoverButton("Members","group.png", buttonSize, imageSize);
        JButton aboutButton = createHoverButton("About","info.png", buttonSize, imageSize);

        // Add action listeners to the buttons
        trackerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Tracker");
            }
        });

        memberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Member");
            }
        });
        
        aboutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "About");
            }
        });
        
        userButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "User");
            }
        });



        // Create a panel to hold the buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(0, 100, 0));
        buttonPanel.setPreferredSize(new Dimension(100, 200));

        buttonPanel.add(userButton);
        buttonPanel.add(trackerButton);
        buttonPanel.add(memberButton);
        buttonPanel.add(aboutButton);

        // Create a card layout for switching between panels
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        cardPanel.add(userPanel.getPanel(), "User");
        cardPanel.add(trackerPanel.getPanel(), "Tracker");
        cardPanel.add(memberPanel.getPanel(), "Member");
        cardPanel.add(aboutPanel.getPanel(), "About");

        // Set the layout and add components
        setLayout(new BorderLayout());
        add(welcomePanel, BorderLayout.NORTH);
           
        add(buttonPanel, BorderLayout.WEST);
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

        add(cardPanel, BorderLayout.CENTER);
        setVisible(true);
    }

private JButton createHoverButton(String text, String imagePath, Dimension buttonSize, Dimension imageSize) {
    JButton button = new JButton();

    button.setOpaque(false);
    button.setContentAreaFilled(false);
    button.setBorderPainted(false);

    button.setForeground(Color.WHITE);

    // Set the icon with custom size
    ImageIcon icon = new ImageIcon(new ImageIcon(imagePath).getImage().getScaledInstance(imageSize.width, imageSize.height, Image.SCALE_DEFAULT));
    button.setIcon(icon);

    // Set text and icon alignment
    button.setHorizontalTextPosition(SwingConstants.CENTER);
    button.setVerticalTextPosition(SwingConstants.BOTTOM);

    // Set the preferred size for the button
    button.setPreferredSize(buttonSize);

    // Set the HTML content for the button
    button.setText("<html><center>" + text + "</center></html>");

    button.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseEntered(MouseEvent e) {
            button.setBackground(new Color(0, 150, 0)); // Change background color on hover
        }

        @Override
        public void mouseExited(MouseEvent e) {
            button.setBackground(null); // Reset background color when not hovered
        }
    });

    return button;
}



    //temporary
      public static void main(String[] args) {
         JFrame frame = new JFrame("WelcomePanel Example");
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setSize(800, 600);
         frame.setContentPane(new WelcomePanel());
         frame.setVisible(true);
     }
}
