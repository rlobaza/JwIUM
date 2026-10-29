
package jwium.lab1.messageboard.model;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import jwium.lab1.messageboard.exception.WrongIndexException;

/**
 * Manages the collection of messages and the board description.
 * 
 * <p>Documentation documented with the help of AI (Model: Gemini).
 * 
 * @author Rafal Lobaza
 * @version 1.0
 */
public class MessagesManager {
    
    /** The list storing all application messages. */
    private final ArrayList<Message> messages = new ArrayList<>();
    
    /** The list model storing messages for graphical components synchronization. */
    private final DefaultListModel<Message> messagesListModel = new DefaultListModel<>();
    
    /** The text description of the message board. */
    private String description = "";
    
    /** The name of the author who most recently posted a message. */
    private String lastUsedAuthor = "unknown_user";
    
    /**
     * Constructs a new MessagesManager with default values.
     */
    public MessagesManager(){
        
    }
    
    /**
     * Adds a board description extracted from command-line arguments if available.
     * 
     * @param args the command-line arguments array
     * @return true if description was successfully added, false otherwise
     */
    public boolean addDescriptionFromArgs(String[] args){
        if(args.length >= 1){
            description = args[0];
            return true;
        }
        return false;
    }
    
    /**
     * Changes the current board description to a new one.
     * 
     * @param newDescription the new description text
     */
    public void changeDescription(String newDescription){
        description = newDescription;
    }
    
    /**
     * Placeholder method for initialization or future array list operations.
     */
    public void ArrayList(){
        
    }
    
    /**
     * Adds a Message object to the collection of messages.
     * 
     * @param message the Message object to add
     */
    public void addMessage(Message message){
        messages.add(message);
    }
    
    /**
     * Creates and adds a new Message object using the specified content string.
     * 
     * @param content the text content for the new message
     */
    public void addMessage(String content){
        messages.add(new Message(content));
    }
    
    /**
     * Creates and adds a new Message with specified content and author to the list model.
     * 
     * @param content the text content of the message
     * @param author the author of the message
     */
    public void addMessageToListModel(String content, String author){
        messagesListModel.addElement(new Message(content, author));
    }
    
    /**
     * Removes a message at the specified index from the collection.
     * 
     * @param index the position of the message to remove
     * @throws WrongIndexException if the index is out of valid bounds
     */
    public void removeMessage(int index) throws WrongIndexException{
        if(index >= messages.size() || index < 0)
        {
            throw new WrongIndexException("ERROR: Index must be a valid number.");
        }
        messages.remove(index);
    }
    
    /**
     * Removes a message at the specified index from the list model.
     * 
     * @param index the position of the message to remove from the list model
     * @throws WrongIndexException if the index is out of valid bounds
     */
    public void removeMessageFromListModel(int index) throws WrongIndexException{
        if(index >= messagesListModel.size() || index < 0)
        {
            throw new WrongIndexException("ERROR: Index must be a valid number.");
        }
        messagesListModel.remove(index);
    }
    
    /**
     * Retrieves the list of all messages.
     * 
     * @return an ArrayList containing all stored messages
     */
    public ArrayList<Message> getMessages(){
        return messages;
    }
    
    /**
     * Retrieves the current board description.
     * 
     * @return the description string
     */
    public String getDescription(){
        return description;
    }
    
    /**
     * Retrieves the list model holding messages for the graphical interface.
     * 
     * @return the DefaultListModel containing Message objects
     */
    public DefaultListModel getListModel(){
        return messagesListModel;
    }
    
    /**
     * Updates the record of the author who most recently posted a message.
     * 
     * @param newLastUsedAuthor the name of the last active author
     */
    public void setLastUsedAuthor(String newLastUsedAuthor){
        lastUsedAuthor = newLastUsedAuthor;
    }
    
    /**
     * Retrieves the name of the author who most recently posted a message.
     * 
     * @return the last used author name string
     */
    public String getLastUsedAuthor(){
        return lastUsedAuthor;
    }
}
