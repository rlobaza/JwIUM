
package jwium.lab1.messageboard.model;

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
    
    /**
     * Constructs a Message with the specified initial content.
     * 
     * @param initialContent the initial text content for the message
     */
    public Message(String initialContent){
        content = initialContent;
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
}
