
package jwium.lab1.messageboard.view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import jwium.lab1.messageboard.controller.*;

public class DescriptionPanel extends JPanel{
    
    private final JTextArea descriptionText;
    private final JButton returnButton;
    private final JButton modifyButton;
    
    public DescriptionPanel(CardLayout cardLayout, JPanel cardPanel, JFrame frame, Controller controller){
        
        setLayout(new BorderLayout());
        
        JPanel labelPanel = new JPanel();
        JLabel descriptionLabel = new JLabel("Description:");
        descriptionLabel.setFont(descriptionLabel.getFont().deriveFont(24.0f));
        labelPanel.add(descriptionLabel);
        
        descriptionText = new JTextArea();
        descriptionText.setFont(descriptionText.getFont().deriveFont(14.0f));
        JScrollPane scrollPane = new JScrollPane(descriptionText);
        
        JPanel buttonsPanel = new JPanel();
        GridLayout gridLayoutButtons = new GridLayout(1, 2, 30, 0);
        buttonsPanel.setLayout(gridLayoutButtons);
        
        JPanel wrapper = new JPanel(new GridBagLayout());
        wrapper.add(buttonsPanel);
        
        // ---------------------------------------------------------------------
        
        // description text
        
        descriptionText.setLineWrap(true);
        descriptionText.setWrapStyleWord(true);
        descriptionText.setEditable(false);
        
        // "Return" button
        
        returnButton = new JButton("Return");
        returnButton.setFont(returnButton.getFont().deriveFont(16.0f));
        returnButton.addActionListener(event -> {
            cardLayout.show(cardPanel, "MAIN_MENU");
        });
        returnButton.setToolTipText("tooltip text");
        returnButton.setMnemonic(KeyEvent.VK_R);
        returnButton.getAccessibleContext().setAccessibleDescription("accesible description");
        buttonsPanel.add(returnButton);
        
        // "Modify" button
        
        modifyButton = new JButton("Modify");
        modifyButton.setFont(modifyButton.getFont().deriveFont(16.0f));
        modifyButton.addActionListener(event -> {
            String description = JOptionPane.showInputDialog(frame, "Please enter a description for your message board.", "Add Description", JOptionPane.QUESTION_MESSAGE);
            
            if(!description.equals("")){
                controller.changeDescription(description);
                descriptionText.setText(description);
            }
        });
        modifyButton.setToolTipText("tooltip text");
        modifyButton.setMnemonic(KeyEvent.VK_M);
        modifyButton.getAccessibleContext().setAccessibleDescription("accesible description");
        buttonsPanel.add(modifyButton);
        
        // ---------------------------------------------------------------------
        
        add(labelPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(wrapper, BorderLayout.SOUTH);
    }
    
    public void setDescription(String newDescription){
        descriptionText.setText(newDescription);
    }
}
