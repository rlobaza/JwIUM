
package jwium.lab1.messageboard;
import jwium.lab1.messageboard.controller.Controller;

/**
 * The main entry point for the Messageboard application.
 * Initializes the controller and starts the program execution.
 * 
 * <p>Documentation generated with the help of AI (Model: Gemini).
 * 
 * @author Rafal Lobaza
 * @version 1.0
 */
public class Messageboard{
    
    /**
     * Creates a new Messageboard object.
     */
    public Messageboard(){
    
    }
    
    /**
     * Main method that serves as the application's entry point.
     * 
     * <p><strong>Command-Line Arguments Order & Specification:</strong>
     * <ul>
     *   <li>{@code args[0]} (optional): The initial description text for the message board. 
     *       If passed from CMD, it is automatically assigned as the board description. 
     *       If no arguments are provided, the application will prompt the user to input the description interactively.</li>
     * </ul>
     * 
     * <p>Documentation generated with the help of AI (Model: Gemini).
     * 
     * @author Rafal Lobaza
     * @version 1.0
     * @param args command-line arguments passed to the application (expects 0 or 1 argument: {@code args[0]} as description)
     */
    public static void main(String[] args) {
        
        Controller controller = new Controller(args);
        controller.startProgram();
        
    }
}