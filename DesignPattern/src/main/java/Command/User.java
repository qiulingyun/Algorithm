package Command;

public class User {
	public static void main(String[] args){
		CmdExecutor commander = new Commander();
		CmdNotifier notifier = new CmdNotifier();
		Solider solider = new Solider();
		Notify cmdNotify = new Notify();
		Attack cmdAttack = new Attack();
		commander.setCmd(cmdNotify);
		notifier.setCmd(cmdAttack);
		cmdNotify.setExecutor(notifier);
		cmdAttack.setSolider(solider);
		
		
		commander.action();
	}
}
