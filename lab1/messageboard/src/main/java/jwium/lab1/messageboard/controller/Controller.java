
package jwium.lab1.messageboard.controller;
import jwium.lab1.messageboard.view.*;
import jwium.lab1.messageboard.model.*;
import jwium.lab1.messageboard.exception.WrongIndexException;
import javax.swing.*;

/**
 * Controls the flow of the message board application.
 * Coordinates user input, displayed output, and message management.
 * 
 * <p>Documentation documented with the help of AI (Model: Gemini).
 * 
 * @author Rafal Lobaza
 * @version 1.0
 */
public class Controller {
    
    /** The display instance used to render text and menus on the console. */
    private final Display display = new Display();
    
    /** The data input instance used to capture user inputs from the console. */
    private final DataInput input = new DataInput(display);
    
    /** Flag indicating whether the main program loop should terminate. */
    private boolean shouldEnd = false;
    
    /** The messages manager handling application data and storage. */
    private final MessagesManager manager;
    
    /** Command-line arguments passed upon application startup. */
    private final String[] args;
    
    /**
     * Constructs a new Controller with the specified initial command-line arguments.
     * 
     * @param initialArgs command-line arguments provided at startup
     */
    public Controller(String[] initialArgs){
        args = initialArgs;
        manager = new MessagesManager();
    }
    
    /**
     * Starts the main program loop and handles the user's menu choices.
     * The loop continues until the user chooses to exit the application.
     */
    public void startProgram(){
        
        if(args.length >= 1){
            manager.addDescriptionFromArgs(args);
        }
        else{
            manager.changeDescription(input.askForDescription());
            display.emptyLine();
        }
        
        while(!shouldEnd){
            display.printMainMenu();
            display.emptyLine();

            int choice = input.askForMenuOption();
            display.emptyLine();
            
            switch (choice) {
                case 1 -> {
                    display.printAllMessages(manager);
                    display.emptyLine();
                }
                case 2 -> {
                    display.printDescription(manager.getDescription());
                    display.emptyLine();
                }
                case 3 -> {
                    manager.addMessage(input.askForMessageContent());
                    display.emptyLine();
                }
                case 4 -> {
                    int index = input.askForMessageIndex();
                    
                    try{
                       manager.removeMessage(index);
                       display.emptyLine();
                       display.print("Message number " + (index  + 1) + " has been deleted.");
                    }
                    catch(WrongIndexException exception){
                        display.emptyLine();
                        display.print("Message number " + (index + 1) + " cannot be deleted.");
                    }
                    finally{
                        display.emptyLine();
                    }
                }
                case 5 -> endProgram();
                default -> {
                    display.print("ERROR: Invalid option.");
                    display.emptyLine();
                }
            }
            
        }
    }
    
    public void createWindow()
    {
        if(!manager.addDescriptionFromArgs(args)){
            String description = JOptionPane.showInputDialog(null, "Please enter a description for your message board.", "Add Description", JOptionPane.PLAIN_MESSAGE);
            
            if(description == null){
                return;
            }
            
            while(description.equals(""))
            {
                description = JOptionPane.showInputDialog(null, "Invalid description. Please try again.", "Add Description", JOptionPane.ERROR_MESSAGE);
                
                if(description == null){
                    return;
                }
            }   
            
            manager.changeDescription(description);
        }
        
        Frame frame = new Frame(this, manager.getListModel());
        frame.setDefaultCloseOperation(Frame.EXIT_ON_CLOSE);
        frame.setDescription(manager.getDescription());
        frame.setVisible(true);
    }
    
    /**
     * Signals the main program loop to terminate.
     */
    private void endProgram(){
        shouldEnd = true;
    }
    
    public void changeDescription(String newDescription){
        manager.changeDescription(newDescription);
    }
}
