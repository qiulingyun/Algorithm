package Command;

public class Attack implements Command {

	private Solider solider;
	
	
	public Solider getSolider() {
		return solider;
	}


	public void setSolider(Solider solider) {
		this.solider = solider;
	}


	public void exec() {
		System.out.println("CMD: ATTACK");
		if(solider != null){
			solider.action();
		}
	}

}
