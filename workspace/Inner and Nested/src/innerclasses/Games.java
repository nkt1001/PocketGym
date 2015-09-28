package innerclasses;

interface Game{
	boolean move();
}
interface GameFactory{
	Game getGame();
}
class Checkers implements Game{
	private int moves = 0;
	private static final int MOVES = 3;
	@Override
	public boolean move() {
		System.out.println("Chekers move " + moves);
		return ++moves != MOVES;
	}
	public static GameFactory factory = new GameFactory() {
		
		@Override
		public Game getGame() {
			// TODO Auto-generated method stub
			return new Checkers();
		}
	};
}

class Chess implements Game{
	private int moves = 0;
	private static final int MOVES = 4;
	@Override
	public boolean move() {
		System.out.println("Chess move " + moves);
		return ++moves != MOVES;
	}
public static GameFactory factory = new GameFactory() {
		
		@Override
		public Game getGame() {
			// TODO Auto-generated method stub
			return new Chess();
		}
	};
}

public class Games {
	private static Game game;
	public static void gamesConsumer(GameFactory factory){
		game = factory.getGame();
		while(game.move());
	}
	public static void main(String[] args) {
		gamesConsumer(Checkers.factory);
		gamesConsumer(Chess.factory);
	}
}