
package jwium.lab1.messageboard.view;
import jwium.lab1.messageboard.model.*;

/**
 * Handles the presentation of information to the user.
 * Displays messages, menu options, and other text in the console.
 */
public class Display {
    
    /**
     * Creates a new Display object.
     */
    public Display(){
        
    }
    
    /**
     * Prints all messages stored in the message manager.
     * Each message is preceded by its position in the list,
     * starting from 1.
     *
     * @param manager the manager containing the messages to display
     */
    public void printAllMessages(MessagesManager manager){
        for(int i = 0; i < manager.getMessages().size(); i++){
            System.out.print(String.valueOf(i + 1) + " ");
            System.out.println(manager.getMessages().get(i).getContent());
        }
    }
    
    /**
     * Prints the specified text followed by a new line.
     *
     * @param text the text to print
     */
    public void print(String text){
        System.out.println(text);
    }
    
    /**
     * Prints an empty line to the console.
     */
    public void emptyLine(){
        System.out.println();
    }
    
    /**
     * Displays the main menu with the available application options.
     */
    public void printMainMenu()
    {
        print("---------- MESSAGE BOARD ----------");
        print("1 - View all messages");
        print("2 - Post a new message");
        print("3 - Delete a message");
        print("4 - Exit");
    }
}
