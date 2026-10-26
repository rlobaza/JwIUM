
package jwium.lab1.messageboard.view;
import javax.swing.*;
import java.awt.*;
import jwium.lab1.messageboard.controller.*;


public class Frame extends JFrame{
    
    private final Controller controller;
    
    private final CardLayout cardLayout = new CardLayout();
    private final JPanel cardPanel = new JPanel(cardLayout);
    
    private final MainMenuPanel mainMenuPanel;
    private final DescriptionPanel descriptionPanel;
    private final MessagesPanel messagesPanel;
    
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
    
    public void openMainMenuPanel(){
        
    }
    
    public void openDescriptionPanel(){
        
    }
    
    public void setDescription(String newDescription)
    {
        descriptionPanel.setDescription(newDescription);
    }
}
