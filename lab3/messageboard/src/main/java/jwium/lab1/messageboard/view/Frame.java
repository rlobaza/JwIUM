
package jwium.lab1.messageboard.view;
import javax.swing.*;
import java.awt.*;
import jwium.lab1.messageboard.controller.*;

/**
 * Represents the main application window hosting multiple panels using a CardLayout.
 * 
 * <p>Documentation documented with the help of AI (Model: Gemini).
 * 
 * @author Rafal Lobaza
 * @version 1.0
 */
public class Frame extends JFrame{
    
    /** The application controller managing business logic and data. */
    private final Controller controller;
    
    /** The card layout manager used to switch between different application panels. */
    private final CardLayout cardLayout = new CardLayout();
    
    /** The main panel container holding all views under card layout. */
    private final JPanel cardPanel = new JPanel(cardLayout);
    
    /** The panel displaying the main menu options. */
    private final MainMenuPanel mainMenuPanel;
    
    /** The panel displaying the message board description. */
    private final DescriptionPanel descriptionPanel;
    
    /** The panel displaying the list of messages and management actions. */
    private final MessagesPanel messagesPanel;
    
    /**
     * Constructs a new main application Frame with the specified controller and message list model.
     * 
     * @param initialController the application controller
     * @param messagesListModel the list model holding application messages
     */
    public Frame(Controller initialController, DefaultListModel messagesListModel){
        controller = initialController;
        
        mainMenuPanel = new MainMenuPanel(cardLayout, cardPanel, this);
        descriptionPanel = new DescriptionPanel(cardLayout, cardPanel, this, controller);
        messagesPanel = new MessagesPanel(cardLayout, cardPanel, this, controller, messagesListModel);
        
        setTitle("Message Board");
        setSize(1280, 720);
        
        cardPanel.add(mainMenuPanel, "MAIN_MENU");
        cardPanel.add(descriptionPanel, "DESCRIPTION");
        cardPanel.add(messagesPanel, "MESSAGES");
        
        add(cardPanel);
        cardLayout.show(cardPanel, "MAIN_MENU");
    }
    
    /**
     * Placeholder method for switching or refreshing the description panel view.
     */
    public void setDescription(String newDescription)
    {
        descriptionPanel.setDescription(newDescription);
    }
}
