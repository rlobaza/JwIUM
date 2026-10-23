
package jwium.lab1.messageboard.view;
import javax.swing.*;
import java.awt.*;

public class MainMenuPanel extends JPanel{
    
    public MainMenuPanel(CardLayout layout, JPanel panel){
        add(new JButton("View Messages"));
        
        JButton descriptionButton = new JButton("Description");
        descriptionButton.addActionListener(e -> {
            layout.show(panel, "DESCRIPTION");
        });
        add(descriptionButton);
        
        
        
        add(new JButton("New Message"));
        
        add(new JButton("Delete Message"));
        
        add(new JButton("Exit"));
    }
}
