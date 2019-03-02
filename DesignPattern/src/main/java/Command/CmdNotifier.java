package Command;

public class CmdNotifier extends CmdExecutor {
	
	public void action(){
		System.out.println("Notifier notify solider!");
		getCmd().exec();
	}
}
