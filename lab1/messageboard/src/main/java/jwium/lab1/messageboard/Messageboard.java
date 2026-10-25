
package jwium.lab1.messageboard;
import jwium.lab1.messageboard.controller.Controller;
import com.formdev.flatlaf.intellijthemes.FlatNordIJTheme;

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
     * <p>
     * Command-Line Arguments Order and Specification:
     * args[0] (optional): The initial description text for the message board.
     * If passed from CMD, it is automatically assigned as the board description.
     * If no arguments are provided, the application will prompt the user to input it interactively.
     * 
     * <p>Documentation generated with the help of AI (Model: Gemini).
     * 
     * @param args command-line arguments passed to the application
     */
    public static void main(String[] args) {
        
        FlatNordIJTheme.setup();
        
        Controller controller = new Controller(args);
        controller.createWindow();
    }
}