package interfaz;

public class StateFactory{
	static GameState nivel = null;

	public static GameState getState(int select, GameStateContext director, ImageLoader loader){
		switch(select){
			case 1: return new GameStateReady(director, loader);
			case 2:
				if(nivel == null){
					nivel = new GameStateNivel(director, loader);
				}
				return nivel;
			case 3: return new GameStatePaused(director, loader);
			case 4:
				nivel = null;
				return new GameStateOver(director, loader);
		}
		return null;
	}
}
