
package jwium.lab1.messageboard.model;
import java.util.ArrayList;

public class MessagesManager {
    private final ArrayList<Message> messages = new ArrayList<>();
    
    public void ArrayList(){
        
    }
    
    public void addMessage(Message message){
        messages.add(message);
    }
    
    public void addMessage(String content){
        messages.add(new Message(content));
    }
    
    // returns true if message exists and false when it doesn't
    public boolean removeMessage(int index){
        if(index >= messages.size())
        {
            return false;
        }
        
        messages.remove(index);
        return true;
    }
    
    public ArrayList<Message> getMessages(){
        return messages;
    }
}
