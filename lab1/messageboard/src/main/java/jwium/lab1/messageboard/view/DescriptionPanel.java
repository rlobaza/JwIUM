
package jwium.lab1.messageboard.view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DescriptionPanel extends JPanel{
    
    public DescriptionPanel(CardLayout layout, JPanel panel, String description){
        add(new JLabel("Description:"));
        add(new JTextArea(description));
        
        JButton returnButton = new JButton("Return");
        returnButton.addActionListener(event -> {
            layout.show(panel, "MAIN_MENU");
        });
        returnButton.setToolTipText("tooltip text");
        returnButton.setMnemonic(KeyEvent.VK_R);
        returnButton.getAccessibleContext().setAccessibleDescription("accesible description");
        add(returnButton);
    }
}
