
package jwium.lab1.messageboard.model;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import jwium.lab1.messageboard.exception.WrongIndexException;
import lombok.*;

/**
 * Manages the collection of messages and the board description.
 * 
 * <p>Documentation documented with the help of AI (Model: Gemini).
 * 
 * @author Rafal Lobaza
 * @version 2.2
 */
public class MessagesManager {
    
    /** The list storing all application messages. */
    @Getter
    private final ArrayList<Message> messages = new ArrayList<>();
    
    /** The list model storing messages for graphical components synchronization. */
    @Getter
    private final DefaultListModel<Message> messagesListModel = new DefaultListModel<>();
    
    /** The text description of the message board. */
    @Getter
    @Setter
    private String description = "";
    
    /** The name of the author who most recently posted a message. */
    @Getter
    @Setter
    private String lastUsedAuthor = "unknown_user";
    
    /**
     * Adds a board description extracted from command-line arguments if available.
     * 
     * @param args the command-line arguments array
     * @return true if description was successfully added, false otherwise
     */
    public boolean addDescriptionFromArgs(ArrayList<String> args){
        if(args.size() >= 1){
            description = args.get(0);
            return true;
        }
        return false;
    }
    
    /**
     * Adds a Message object to the collection of messages.
     * 
     * @param message the Message object to add
     */
    public void addMessage(Message message){
        messages.add(message);
        refreshVisibleMessagesListModel();
    }
    
    /**
     * Creates and adds a new Message object using the specified content string.
     * 
     * @param content the text content for the new message
     */
    public void addMessage(String content){
        messages.add(new Message(content));
        refreshVisibleMessagesListModel();
    }
    
    /**
     * Creates and adds a new Message object using the specified content string.
     * 
     * @param content the text content for the new message
     * @param author the author of the message
     */
    public void addMessage(String content, String author){
        messages.add(new Message(content, author));
        refreshVisibleMessagesListModel();
    }
    
    /**
     * Creates and adds a new Message with specified content and author to the list model.
     * 
     * @param content the text content of the message
     * @param author the author of the message
     */
    @Deprecated
    public void addMessageToListModel(String content, String author){
        messagesListModel.addElement(new Message(content, author));
    }
    
    /**
     * Removes a message at the specified index from the collection.
     * 
     * @param index the position of the message to remove
     * @throws WrongIndexException if the index is out of valid bounds
     */
    @Deprecated
    public void removeMessage(int index) throws WrongIndexException{
        if(index >= messages.size() || index < 0)
        {
            throw new WrongIndexException("ERROR: Index must be a valid number.");
        }
        messages.remove(index);
        refreshVisibleMessagesListModel();
    }
    
    /**
     * Removes the specified Message object from the collection and refreshes visible messages.
     *
     * @param message the Message object to remove
     * @return true if the message was found and removed, false otherwise
     */
    public boolean removeMessage(Message message) {
        if (message == null) {
            return false;
        }
        boolean removed = messages.remove(message);
        if (removed) {
            refreshVisibleMessagesListModel();
        }
        return removed;
    }
    
    /**
     * Removes a message at the specified index from the list model.
     * 
     * @param index the position of the message to remove from the list model
     * @throws WrongIndexException if the index is out of valid bounds
     */
    @Deprecated
    public void removeMessageFromListModel(int index) throws WrongIndexException{
        if(index >= messagesListModel.size() || index < 0)
        {
            throw new WrongIndexException("ERROR: Index must be a valid number.");
        }
        messagesListModel.remove(index);
    }
    
    /**
     * Filters messages by author case-sensitively using the given query.
     *
     * @param author the author name or fragment to filter by
     */
    public void filterMessagesByAuthor(String author) {
        String query = author == null ? "" : author.trim();

        for (Message message : messages) {
            String msgAuthor = message.getAuthor() == null ? "" : message.getAuthor();
            if (msgAuthor.contains(query)) {
                message.setStatus(MessageStatus.VISIBLE);
            } else {
                message.setStatus(MessageStatus.HIDDEN);
            }
        }

        refreshVisibleMessagesListModel();
    }
    
    /**
     * Restores visibility status for all messages in the collection and list model.
     */
    public void stopFilteringMessages()
    {
        for(Message message : messages)
        {
            message.setStatus(MessageStatus.VISIBLE);
        }
        
        refreshVisibleMessagesListModel();
    }
    
    /**
    * Refreshes the list model so that only visible messages are displayed.
    */
    private void refreshVisibleMessagesListModel() {
        messagesListModel.clear();
        messages.stream()
                .filter(message -> message.getStatus() == MessageStatus.VISIBLE)
                .forEach(messagesListModel::addElement);
    }
}
