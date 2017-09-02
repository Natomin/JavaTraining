package gui.reversi.game;

import java.util.Random;

public class Reversi {
	public static final int NONE = 0;	// 何も置かれていない
	public static final int BLACK = 1;	// 黒が置かれている
	public static final int WHITE = 2;	// 白が置かれている
	public static final int BOARD_SIZE = 8;	// 盤のサイズ
	
	private int currentColor;	// 現在のプレイヤーの色
	private int[][] board = new int[BOARD_SIZE][BOARD_SIZE];	// 盤の状態
	private boolean finished = false;	// ゲームが終了したかどうか
	
	/**
	 * コンストラクタ
	 */
	public Reversi()
	{
		//最初のプレイヤーをランダムに決定する
		if(new Random().nextBoolean()){
			this.currentColor = WHITE;
		}else{
			this.currentColor = BLACK;
		}
		this.initialize();
	}
	
	/**
	 * 現在のプレイヤーの色を取得します
	 */
	public int getCurrentColor()
	{
		return this.currentColor;
	}
	
	/**
	 * 盤上の(x,y)の位置の状態を取得します</br>
	 * 0 <= x,y <= BORAD_SIZE-1
	 */
	public int getStateAt(int x, int y)
	{
		return this.board[x][y];
	}
	
	/**
	 * ゲームが終了しているかどうかを取得します
	 */
	public boolean isFinished()
	{
		return this.finished;
	}
	
	/**
	 * 現在のプレイヤーの色で(x,y)の位置に駒を置きます</br>
	 * 駒を置けた場合はプレイヤーを変更します</br>
	 *  - 交代先のプレイヤーが置ける場合はプレイヤーを交代します</br>
	 *  - 交代先のプレイヤーが置けず、現在のプレイヤーが置ける場合はプレイヤー変更せずに続行します</br>
	 *  - 交代先のプレイヤーも現在のプレイヤーも置けない場合は終了状態にします
	 * @param x 置く位置のx座標(0~)
	 * @param y 置く位置のY座標(0~)
	 * @return 駒を置けた場合はtrue/置けなった場合はfalse
	 */
	public boolean putPiece(int x, int y)
	{
		if(this.tryPutPiece(this.currentColor, x, y, true))
		{
			// 交代先の色で置ける場所があれば色を交代
			if(this.canPutPieceAny(this.getReverseColor()))
			{
				this.currentColor = this.getReverseColor();
			}
			// 交代先が置けず、現在の色も置く場所が無ければ終了
			else if(!this.canPutPieceAny(this.currentColor))
			{
				this.finished = true;
			}
			
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 * 盤上のどこかに駒を置く場所があるかどうかを判定します
	 * @param color 置く駒の色 
	 * @return 駒を置ける場合はtrue/置けない場合はfalse
	 */
	private boolean canPutPieceAny(int color)
	{
		for(int x = 0; x < BOARD_SIZE; x++)
		{
			for(int y = 0; y < BOARD_SIZE; y++)
			{
				if(this.tryPutPiece(color, x, y, false))
					return true;
			}
		}
		
		return false;
	}
	
	/**
	 * 駒を置くことを試みます</br>
	 * doPutがtrueの場合は実際に駒を置き、盤の状態を更新します</br>
	 * doPutがfalseの場合は実際には駒を置かず、置けるかどうかの判定のみを行います
	 * @param x 置く位置のx座標(0~)
	 * @param y 置く位置のY座標(0~)
	 * @param doPut 実際に駒を置くかどうか
	 * @return 駒を置けた場合はtrue/置けなかった場合はfalse
	 */
	private boolean tryPutPiece(int color, int x, int y, boolean doPut)
	{
		// 指定位置が範囲外のとき
		if((x < 0) || (x >= BOARD_SIZE) || (y < 0) || (y >= BOARD_SIZE))
			return false;
		
		// 対象位置にすでに駒が置かれているとき
		if((this.board[x][y] == BLACK) || (this.board[x][y] == WHITE))
			return false;
		
		int reverseColor = (color == BLACK) ? WHITE : BLACK;	// 置く色と反対の色
		boolean isPut = false;
		
		// 8方向を探索し、反対色を裏返すことができるラインを見つける
		for(int w = -1; w <= 1; w++)
		{
			for(int h = -1; h <= 1; h++)
			{
				int revRange = 0;
				
				// どの方向にも探索しないとき
				if((w == 0) && (h == 0))
					continue;
				
				// 探索範囲が境界外のとき
				if((x + w < 0) || (x + w >= BOARD_SIZE)
					|| (y + h < 0) || (y + h >= BOARD_SIZE))
				{
					continue;
				}
				
				// 隣接駒が反対色でないとき
				if(this.board[x + w][y + h] != reverseColor)
				{
					continue;
				}
				
				// 同色が見つかるまでその方向を探索
				for(int k = 2; k < BOARD_SIZE; k++)
				{
					// 探索範囲が境界外のとき
					if((x + w * k < 0) || (x + w * k >= BOARD_SIZE)
						|| (y + h * k < 0) || (y + h * k >= BOARD_SIZE))
					{
						break;
					}
					
					// 対の同色が見つかる前に空白があったとき
					if((this.board[x + w * k][y + h * k] != BLACK)
						&& (this.board[x + w * k][y + h * k] != WHITE))
					{
						break;
					}
					
					if(this.board[x + w * k][y + h * k] == color)
					{
						// 対になる同色位置を取得
						isPut = true;
						revRange = k;
						break;
					}
				}
				
				if(doPut)
				{
					// 対象位置と挟まれた範囲の色を同色に設定
					for(int k = 0; k < revRange; k++)
					{
						this.board[x + w * k][y + h * k] = color;
					}
				}
			}
		}
		
		return isPut;
	}
	
	/**
	 * 盤の状態を初期化します
	 */
	private void initialize()
	{
		// フィールドを何も置かれていない状態にする
		for(int i = 0; i < BOARD_SIZE; i++)
		{
			for(int j = 0; j < BOARD_SIZE; j++)
			{
				this.board[i][j] = NONE;
			}
		}
		
		// 中央に2個ずつ配置する
		this.board[BOARD_SIZE / 2 - 1][BOARD_SIZE / 2 - 1] = WHITE;
		this.board[BOARD_SIZE / 2 - 1][BOARD_SIZE / 2] = BLACK;
		this.board[BOARD_SIZE / 2][BOARD_SIZE / 2 - 1] = BLACK;
		this.board[BOARD_SIZE / 2][BOARD_SIZE / 2] = WHITE;
	}
	
	/**
	 * 現在のプレイヤーの色の対になる色を取得します
	 */
	private int getReverseColor()
	{
		return (this.currentColor == WHITE) ? BLACK : WHITE;
	}

}
