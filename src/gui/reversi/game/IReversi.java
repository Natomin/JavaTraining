package gui.reversi.game;

public interface IReversi {
	public int getCurrentColor();
	public void setCurrentColor(int color);// デバック用
	public int getStateAt(int x, int y) ;
	public boolean isFinished();

}
