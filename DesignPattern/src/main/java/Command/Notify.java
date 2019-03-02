package Command;

public class Notify implements Command {

	private CmdNotifier executor;
	
	public CmdExecutor getExecutor() {
		return executor;
	}

	public void setExecutor(CmdNotifier executor) {
		this.executor = executor;
	}

	public void exec() {
		System.out.println("CMD: NOTIFY");
		executor.action();
	}

}
