package Command;

public class Commander extends CmdExecutor {
	public void action(){
		System.out.println("Commaner send a command");
		getCmd().exec();
	}
}
