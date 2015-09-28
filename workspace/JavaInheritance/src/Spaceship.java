class Spaceship extends SpaceshipControls{
	private String name;
	public Spaceship(String name) {
		this.name = name;
	}
	public static void main(String[] args) {
		Spaceship enterprise = new Spaceship("Enterprise");
		enterprise.forward(100);
	}
}