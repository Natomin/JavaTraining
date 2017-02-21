package jpl.ch14.ex02;

import java.util.logging.Level;
import java.util.logging.Logger;

//テキストの最初のPrintServerクラスを修正して、スレッドの識別により
//コンストラクタで生成されたスレッドだけがrunを実行できるようにする。
public class PrintServer implements Runnable {
	private final PrintQueue requests = new PrintQueue();
	private Thread privateThread;
	private static final Logger logger = Logger.getLogger("PrintServer");

	public PrintServer() {
		privateThread = new Thread(this);
		privateThread.start();
	}

	public void print(PrintJob job) {
		requests.add(job);
	}

	@Override
	public void run() {
		if (Thread.currentThread() == privateThread) {
			for (;;) {
				realPrint(requests.remove());
			}
		}else{
			logger.log(Level.WARNING, "Access from external thread");
		}
	}

	public void realPrint(PrintJob job) {
		// 実際の印刷処理
	}

}
