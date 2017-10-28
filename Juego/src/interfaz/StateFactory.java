package interfaz;

public class StateFactory{
	static GameState nivel = null;

	public static GameState getState(int select, GameStateContext director){
		switch(select){
			case 1: return new GameStateReady(director);
			case 2:
				if(nivel == null){
					nivel = new GameStateNivel(director);
				}
				return nivel;
			case 3: return new GameStatePaused(director);
			case 4:
				nivel = null;
				return new GameStateOver(director);
		}
		return null;
	}
}
