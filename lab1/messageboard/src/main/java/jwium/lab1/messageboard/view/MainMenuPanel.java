
package jwium.lab1.messageboard.view;
import javax.swing.*;
import java.awt.*;

public class MainMenuPanel extends JPanel{
    
    public MainMenuPanel(CardLayout cardLayout, JPanel cardPanel, JFrame frame){
        
        setLayout(new BorderLayout());
        JPanel buttonsPanel = new JPanel();
        GridLayout gridLayout = new GridLayout(5, 1, 0, 10);
        JPanel wrapper = new JPanel(new GridBagLayout());
        wrapper.add(buttonsPanel);
        buttonsPanel.setLayout(gridLayout);
        
        // ---------------------------------------------------------------------
        
        // "Messages" button
        JButton messagesButton = new JButton("Messages");
        messagesButton.setFont(messagesButton.getFont().deriveFont(16.0f));
        messagesButton.addActionListener(event -> {
            cardLayout.show(cardPanel, "MESSAGES");
        });
        buttonsPanel.add(messagesButton);
        
        // "Description" button
        JButton descriptionButton = new JButton("Description");
        descriptionButton.setFont(descriptionButton.getFont().deriveFont(16.0f));
        descriptionButton.addActionListener(event -> {
            cardLayout.show(cardPanel, "DESCRIPTION");
        });
        buttonsPanel.add(descriptionButton);
        
        // "Exit" button
        JButton exitButton = new JButton("Exit");
        exitButton.setFont(exitButton.getFont().deriveFont(16.0f));
        exitButton.addActionListener(event -> {
            frame.dispose();
        });
        buttonsPanel.add(exitButton);
        
        
        add(wrapper, BorderLayout.CENTER);
    }
}
