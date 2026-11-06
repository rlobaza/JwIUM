
package jwium.lab1.messageboard.view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import jwium.lab1.messageboard.controller.*;

public class DescriptionPanel extends JPanel{
    
    /** The text area displaying the board description. */
    private final JTextArea descriptionText;
    
    /** The button used to return to the main menu. */
    private final JButton returnButton;
    
    /** The button used to modify the board description. */
    private final JButton modifyButton;
    
    /**
     * Constructs a new DescriptionPanel with specified card layout, frame, and controller references.
     * 
     * @param cardLayout the card layout manager for switching views
     * @param cardPanel the panel containing multiple card views
     * @param frame the parent frame for dialogs
     * @param controller the application controller handling data flow
     */
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
        returnButton.setToolTipText("Return to the main menu");
        returnButton.getAccessibleContext().setAccessibleDescription("Return to the main menu");
        returnButton.setMnemonic(KeyEvent.VK_R);
        buttonsPanel.add(returnButton);
        
        // "Modify" button
        
        modifyButton = new JButton("Modify");
        modifyButton.setFont(modifyButton.getFont().deriveFont(16.0f));
        modifyButton.addActionListener(event -> {
            String oldDescription = controller.getDescription();
            String description = (String)JOptionPane.showInputDialog(frame, "Please enter a description for your message board.", "Add Description", JOptionPane.QUESTION_MESSAGE, null, null, oldDescription);
            if(!description.equals("") && description != null){
                controller.changeDescription(description);
                descriptionText.setText(description);
            }
        });
        modifyButton.setToolTipText("Modify message board description");
        modifyButton.getAccessibleContext().setAccessibleDescription("Modify message board description");
        modifyButton.setMnemonic(KeyEvent.VK_M);
        buttonsPanel.add(modifyButton);
        
        // ---------------------------------------------------------------------
        
        add(labelPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(wrapper, BorderLayout.SOUTH);
    }
    
    /**
     * Updates the text displayed in the description text area.
     * 
     * @param newDescription the new description string to set
     */
    public void setDescription(String newDescription){
        descriptionText.setText(newDescription);
    }
}
