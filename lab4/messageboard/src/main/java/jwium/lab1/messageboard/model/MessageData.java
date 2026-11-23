
package jwium.lab1.messageboard.model;
import java.time.LocalDateTime;

/**
 * Represents the raw data container for a message, holding its core content, author, and timestamp.
 * 
 * <p>Documentation documented with the help of AI (Model: Gemini).
 * 
 * @param content the text content of the message
 * @param author the name of the user who posted the message
 * @param postTime the exact timestamp when the message was created
 * 
 * @author Rafal Lobaza
 * @version 1.0
 */
public record MessageData(String content, String author, LocalDateTime postTime) {
    
}
