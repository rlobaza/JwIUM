
package jwium.lab1.messageboard.exception;

/**
 * Custom exception thrown when an invalid message index is provided.
 * 
 * <p>Documentation documented with the help of AI (Model: Gemini).
 * 
 * @author Rafal Lobaza
 * @version 1.0
 */
public class WrongIndexException extends Exception {
    
    /**
     * Constructs a new WrongIndexException with the specified detail message.
     * 
     * @param message the detail message explaining the reason for the exception
     */
    public WrongIndexException(String message){
        super(message);
    }
}
