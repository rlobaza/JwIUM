
package jwium.lab1.messageboard.view;
import javax.swing.*;
import java.awt.*;
import jwium.lab1.messageboard.controller.*;


public class MessagesPanel extends JPanel{
    
    private final JButton addButton = new JButton("Add");
    private final JButton deleteButton = new JButton("Delete");
    private final JButton returnButton = new JButton("Return");
    
    private final JList messagesList = new JList();
    
    public MessagesPanel(CardLayout cardLayout, JPanel cardPanel, JFrame frame, Controller controller, DefaultListModel messagesListModel){
        
        setLayout(new BorderLayout());
        
        JPanel labelPanel = new JPanel();
        JLabel messagesLabel = new JLabel("Messages");
        messagesLabel.setFont(messagesLabel.getFont().deriveFont(24.0f));
        labelPanel.add(messagesLabel);
        
        JPanel buttonsPanel = new JPanel();
        GridLayout gridLayoutButtons = new GridLayout(1, 3, 30, 0);
        buttonsPanel.setLayout(gridLayoutButtons);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.add(messagesList);
        
        JPanel wrapper = new JPanel(new GridBagLayout());
        wrapper.add(buttonsPanel);
        
        // ---------------------------------------------------------------------
        
        // "Add" button
        
        addButton.setFont(addButton.getFont().deriveFont(16.0f));
        addButton.addActionListener(event -> {
            String newMessageContent = JOptionPane.showInputDialog(frame, "Please enter your message.", "Add Message", JOptionPane.PLAIN_MESSAGE);
            if(newMessageContent != null){
                
            }
        });
        buttonsPanel.add(addButton);
        
        // "Delete" button
        
        deleteButton.setFont(deleteButton.getFont().deriveFont(16.0f));
        deleteButton.addActionListener(event -> {
            
        });
        buttonsPanel.add(deleteButton);
        
        // "Return" button
        
        returnButton.setFont(returnButton.getFont().deriveFont(16.0f));
        returnButton.addActionListener(event -> {
            cardLayout.show(cardPanel, "MAIN_MENU");
        });
        buttonsPanel.add(returnButton);
                
        // ---------------------------------------------------------------------
        
        add(labelPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(wrapper, BorderLayout.SOUTH);
    }
}
