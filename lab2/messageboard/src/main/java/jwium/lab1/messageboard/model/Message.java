
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
    
    /** The text content of the message. */
    private String content;
    
    /** The timestamp recording when the message was created. */
    private LocalDateTime postTime;
    
    /** The author who posted the message. */
    private String author = "unknown_user";
    
    /** The formatter used to display dates and times in a readable format. */
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
    
    /**
     * Constructs a Message with the specified initial content.
     * 
     * @param initialContent the initial text content for the message
     */
    public Message(String initialContent){
        content = initialContent;
        postTime = LocalDateTime.now();
    }
    
    /**
     * Constructs a Message with the specified initial content and author.
     * 
     * @param initialContent the initial text content for the message
     * @param initialAuthor the author of the message
     */
    public Message(String initialContent, String initialAuthor){
        content = initialContent;
        author = initialAuthor;
        postTime = LocalDateTime.now();
    }
    
    /**
     * Constructs an empty Message with default blank content.
     */
    public Message(){
        content = "";
    }
    
    /**
     * Sets or updates the text content of the message.
     * 
     * @param newContent the new text content to set
     */
    public void setContent(String newContent){
        content = newContent;
    }
    
    /**
     * Retrieves the text content of the message.
     * 
     * @return the text content of the message
     */
    public String getContent(){
        return content;
    }
    
    @Override
    public String toString(){
        return postTime.format(formatter) + " - " + author + ": " + content;
    }
}
