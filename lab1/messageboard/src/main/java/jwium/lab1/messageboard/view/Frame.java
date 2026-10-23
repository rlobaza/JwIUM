
package jwium.lab1.messageboard.view;
import javax.swing.*;
import java.awt.*;


public class Frame extends JFrame{
    
    private final CardLayout layout = new CardLayout();
    private final JPanel panel = new JPanel(layout);
    
    private final MainMenuPanel mainMenuPanel = new MainMenuPanel(layout, panel);
    private final DescriptionPanel descriptionPanel = new DescriptionPanel(layout, panel, "test");
    
    public Frame(){
        setTitle("Message Board");
        setSize(1080, 720);
        
        panel.add(mainMenuPanel, "MAIN_MENU");
        panel.add(descriptionPanel, "DESCRIPTION");
        
        add(panel);
        layout.show(panel, "MAIN_MENU");
    }
    
    public void openMainMenuPanel(){
        
    }
    
    public void openDescriptionPanel(){
        
    }
}
