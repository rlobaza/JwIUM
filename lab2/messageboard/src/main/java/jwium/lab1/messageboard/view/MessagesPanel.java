
package jwium.lab1.messageboard.view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import jwium.lab1.messageboard.controller.*;
import jwium.lab1.messageboard.model.Message;

public class MessagesPanel extends JPanel{
    
    private final JButton addButton = new JButton("Add");
    private final JButton deleteButton = new JButton("Delete");
    private final JButton returnButton = new JButton("Return");
    
    public MessagesPanel(CardLayout cardLayout, JPanel cardPanel, JFrame frame, Controller controller, DefaultListModel messagesListModel){
        
        setLayout(new BorderLayout());
        
        JPanel labelPanel = new JPanel();
        JLabel messagesLabel = new JLabel("Messages");
        messagesLabel.setFont(messagesLabel.getFont().deriveFont(24.0f));
        labelPanel.add(messagesLabel);
        
        JPanel buttonsPanel = new JPanel();
        GridLayout gridLayoutButtons = new GridLayout(1, 3, 30, 0);
        buttonsPanel.setLayout(gridLayoutButtons);
        
        JList<Message> messagesList = new JList<>(controller.getListModel());
        JScrollPane scrollPane = new JScrollPane(messagesList);
        
        JPanel wrapper = new JPanel(new GridBagLayout());
        wrapper.add(buttonsPanel);
        
        // ---------------------------------------------------------------------
        
        // "Add" button
        
        addButton.setFont(addButton.getFont().deriveFont(16.0f));
        addButton.addActionListener(event -> {
            String newMessageContent = JOptionPane.showInputDialog(frame, "Please enter your message.", "Add Message", JOptionPane.PLAIN_MESSAGE);
            
            if(newMessageContent == null){
                return;
            }
            
            while(newMessageContent.equals("")){
                newMessageContent = JOptionPane.showInputDialog(frame, "Please enter a valid message.", "Add Message", JOptionPane.ERROR_MESSAGE);
                
                if(newMessageContent == null){
                    return;
                }
            }
            
            String newMessageAuthor = (String)JOptionPane.showInputDialog(frame, "Please enter your nickname.", "Add Message", JOptionPane.PLAIN_MESSAGE, null, null, controller.getLastUsedAuthor());
            
            if(newMessageAuthor == null){
                return;
            }
            
            while(newMessageAuthor.equals("")){
                newMessageAuthor = (String)JOptionPane.showInputDialog(frame, "Please enter a valid nickname.", "Add Message", JOptionPane.ERROR_MESSAGE, null, null, controller.getLastUsedAuthor());
                
                if(newMessageAuthor == null){
                    return;
                }
            }
            
            controller.addMessageToListModel(newMessageContent, newMessageAuthor);
            controller.setLastUsedAuthor(newMessageAuthor);
        });
        addButton.setToolTipText("Add new message");
        addButton.getAccessibleContext().setAccessibleDescription("Add new message");
        addButton.setMnemonic(KeyEvent.VK_A);
        buttonsPanel.add(addButton);
        
        // "Delete" button
        
        deleteButton.setFont(deleteButton.getFont().deriveFont(16.0f));
        deleteButton.addActionListener(event -> {
            int index = messagesList.getSelectedIndex();
            
            if(index == -1){
                JOptionPane.showMessageDialog(frame, "Please select a message first.", "Error - No Message Selected", JOptionPane.ERROR_MESSAGE);
            }
            else{
                int choice = JOptionPane.showConfirmDialog(frame, "Are you sure you want to delete this message?", "Confirm Deletion", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
                
                if(choice == JOptionPane.YES_OPTION){
                    controller.removeMessageFromListModel(index);
                }
            }
            
        });
        deleteButton.setToolTipText("Delete selected message");
        deleteButton.getAccessibleContext().setAccessibleDescription("Delete selected message");
        deleteButton.setMnemonic(KeyEvent.VK_D);
        buttonsPanel.add(deleteButton);
        
        // "Return" button
        
        returnButton.setFont(returnButton.getFont().deriveFont(16.0f));
        returnButton.addActionListener(event -> {
            cardLayout.show(cardPanel, "MAIN_MENU");
        });
        returnButton.setToolTipText("Return to the main menu");
        returnButton.getAccessibleContext().setAccessibleDescription("Return to the main menu");
        returnButton.setMnemonic(KeyEvent.VK_R);
        buttonsPanel.add(returnButton);
                
        // ---------------------------------------------------------------------
        
        add(labelPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(wrapper, BorderLayout.SOUTH);
    }
}
