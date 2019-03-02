package Command;

public abstract class CmdExecutor {
	protected Command cmd;

	public Command getCmd() {
		return cmd;
	}

	public void setCmd(Command cmd) {
		this.cmd = cmd;
	}
	
	public abstract void action();
}
