
package jwium.lab1.messageboard.view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Represents the main menu panel containing navigation options and application exit controls.
 * 
 * <p>Documentation documented with the help of AI (Model: Gemini).
 * 
 * @author Rafal Lobaza
 * @version 1.0
 */
public class MainMenuPanel extends JPanel{
    
    /**
     * Constructs a new MainMenuPanel with specified card layout, card panel container, and parent frame.
     * 
     * @param cardLayout the card layout manager for switching views
     * @param cardPanel the panel containing multiple card views
     * @param frame the parent application frame
     */
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
        messagesButton.setToolTipText("View, add and remove messages");
        messagesButton.getAccessibleContext().setAccessibleDescription("View, add and remove messages");
        messagesButton.setMnemonic(KeyEvent.VK_M);
        buttonsPanel.add(messagesButton);
        
        // "Description" button
        JButton descriptionButton = new JButton("Description");
        descriptionButton.setFont(descriptionButton.getFont().deriveFont(16.0f));
        descriptionButton.addActionListener(event -> {
            cardLayout.show(cardPanel, "DESCRIPTION");
        });
        descriptionButton.setToolTipText("View and modify message board description");
        descriptionButton.getAccessibleContext().setAccessibleDescription("View and modify message board description");
        descriptionButton.setMnemonic(KeyEvent.VK_D);
        buttonsPanel.add(descriptionButton);
        
        // "Exit" button
        JButton exitButton = new JButton("Exit");
        exitButton.setFont(exitButton.getFont().deriveFont(16.0f));
        exitButton.addActionListener(event -> {
            frame.dispose();
        });
        exitButton.setToolTipText("Exit the application");
        exitButton.getAccessibleContext().setAccessibleDescription("Exit the application");
        exitButton.setMnemonic(KeyEvent.VK_E);
        buttonsPanel.add(exitButton);
        
        
        add(wrapper, BorderLayout.CENTER);
    }
}
