package Facade;

public class Computer {
	private CPU cpu;
	private Disk disk;
	private Memory memory;
	
	
	
	public Computer() {
		super();
		cpu = new CPU();
		disk = new Disk();
		memory = new Memory();
	}
	public void startup(){
		cpu.startup();
		memory.startup();
		disk.startup();
	}
	public void shutdown(){
		cpu.shutdown();
		memory.shutdown();
		disk.shutdown();
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Computer computer = new Computer();
		computer.startup();
		computer.shutdown();
	}

}
