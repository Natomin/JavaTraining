package gui.reversi.game;

public class ReversiWrapper implements IReversi{
	private Reversi reversi = new Reversi();
	public static final int NONE = 0; // 何も置かれていない
	public static final int BLACK = 1; // 黒が置かれている
	public static final int WHITE = 2; // 白が置かれている
	public static final int BOARD_SIZE = 8; // 盤のサイズ

	/**
	 * コンストラクタ
	 */
	public ReversiWrapper() {
	}

	/**
	 * 現在のプレイヤーの色を取得します
	 */
	public int getCurrentColor() {
		return reversi.getCurrentColor();
	}


	// デバック用
	public void setCurrentColor(int color) {
		reversi.setCurrentColor(color);
	}

	/**
	 * 盤上の(x,y)の位置の状態を取得します</br>
	 * 0 <= x,y <= BORAD_SIZE-1
	 */
	public int getStateAt(int x, int y) {
		return reversi.getStateAt(x, y);
	}

	/**
	 * ゲームが終了しているかどうかを取得します
	 */
	public boolean isFinished() {
		return reversi.isFinished();
	}

	/**
	 * 現在のプレイヤーの色で(x,y)の位置に駒を置きます</br>
	 * 駒を置けた場合はプレイヤーを変更します</br>
	 * - 交代先のプレイヤーが置ける場合はプレイヤーを交代します</br>
	 * - 交代先のプレイヤーが置けず、現在のプレイヤーが置ける場合はプレイヤー変更せずに続行します</br>
	 * - 交代先のプレイヤーも現在のプレイヤーも置けない場合は終了状態にします
	 * 
	 * @param x
	 *            置く位置のx座標(0~)
	 * @param y
	 *            置く位置のY座標(0~)
	 * @return 駒を置けた場合はtrue/置けなった場合はfalse
	 */
	public boolean putPiece(int x, int y, int color) {
		if (color == reversi.getCurrentColor()) {
			return reversi.putPiece(x, y);
		} else {
			return false;
		}
	}

}
