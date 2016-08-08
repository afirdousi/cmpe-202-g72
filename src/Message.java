
public class Message {
	
	String text;
	int level;
	
	public Message(String text, int level){
		this.text = text;
		this.level = level;
	}
	
	public String getMessage(){
		return this.text;
	}
	
	public void setMessage(String message){
		this.text = message;
	}
	
	

}
