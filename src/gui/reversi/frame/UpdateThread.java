package gui.reversi.frame;

public class UpdateThread extends Thread{
	private IReversiFrame reversi;
	private boolean running = true;
	public UpdateThread(IReversiFrame reversi){
		this.reversi = reversi;
	}
	
	public void run(){
		while(running){
			reversi.update();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
	}
	
	public void stopRunning(){
		running = false;
	}

}
