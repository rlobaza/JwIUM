
package jwium.lab1.messageboard.controller;
import jwium.lab1.messageboard.view.*;
import jwium.lab1.messageboard.model.*;

/**
 * Controls the flow of the message board application.
 * Coordinates user input, displayed output, and message management.
 */
public class Controller {
    private final Display display = new Display();
    private final DataInput input = new DataInput(display);
    private boolean shouldEnd = false;
    private final MessagesManager manager = new MessagesManager();
    
    /**
     * Creates a new controller and initializes the components
     * required to run the application.
     */
    public Controller(){
        
    }
    
    /**
     * Starts the main program loop and handles the user's menu choices.
     * The loop continues until the user chooses to exit the application.
     */
    public void startProgram(){
        while(!shouldEnd){
            display.printMainMenu();
            display.emptyLine();
            int choice = input.inputInteger();
            display.emptyLine();
            
            if(choice == 1){
                display.printAllMessages(manager);
                display.emptyLine();
            }
            if(choice == 2){
                String content = input.askForMessageContent();
                display.emptyLine();
                manager.addMessage(content);
            }
            if(choice == 3){
                display.print("ERROR: Not implemented.");
                display.emptyLine();
            }
            
            if(choice == 4){
                endProgram();
            }
            
            
        }
    }
    
    /**
     * Signals the main program loop to terminate.
     */
    private void endProgram(){
        shouldEnd = true;
    }
}
