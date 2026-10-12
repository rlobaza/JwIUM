
package jwium.lab1.messageboard.model;

public class Message {
    private String content;
    
    public Message(String initialContent){
        content = initialContent;
    }
    
    public Message(){
        content = new String("");
    }
    
    public void setContent(String newContent){
        content = newContent;
    }
    
    public String getContent(){
        return content;
    }
}
