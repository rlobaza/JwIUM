
package jwium.lab1.messageboard.model;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents a single message entity containing text content.
 * 
 * <p>Documentation documented with the help of AI (Model: Gemini).
 * 
 * @author Rafal Lobaza
 * @version 1.0
 */
public class Message {
    
    /** The underlying data container holding message content, author, and timestamp. */
    private final MessageData messageData;
    
    /** The formatter used to display dates and times in a readable format. */
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
    
    /**
     * Constructs a Message with the specified initial content.
     * 
     * @param initialContent the initial text content for the message
     */
    public Message(String initialContent){
        messageData = new MessageData(initialContent, "unknown_user", LocalDateTime.now());
    }
    
    /**
     * Constructs a Message with the specified initial content and author.
     * 
     * @param initialContent the initial text content for the message
     * @param initialAuthor the author of the message
     */
    public Message(String initialContent, String initialAuthor){
        messageData = new MessageData(initialContent, initialAuthor, LocalDateTime.now());
    }
    
    /**
     * Constructs an empty Message with default blank content.
     */
    public Message(){
        messageData = new MessageData("", "unknown_user", LocalDateTime.now());
    }
    
    /**
     * Retrieves the text content of the message.
     * 
     * @return the text content of the message
     */
    public String getContent(){
        return messageData.content();
    }
    
    /**
     * Returns a formatted string representation of the message including timestamp, author, and content.
     * 
     * @return a formatted string representing the message
     */
    @Override
    public String toString(){
        return messageData.postTime().format(formatter) + " - " + messageData.author() + ": " + messageData.content();
    }
}
