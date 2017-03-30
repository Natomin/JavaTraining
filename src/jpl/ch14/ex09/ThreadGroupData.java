package jpl.ch14.ex09;
//スレッドグループを引数に取り、そのグループ内のスレッドとスレッドグループの階層を定期的に表示するメソッドを書く。
//そのメソッドを、様々なグループないでいくつかの短命なスレッドを生成するプログラムでテストする。
import java.util.ArrayList;

public class ThreadGroupData {
	private Thread[] threadInGroup;
	private ThreadGroup parentThreadGroup;
	
	public void startThread(ThreadGroup threadGroup){
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true){
					showParentThread(threadGroup);
					showThreadData(threadGroup);
					System.out.println();
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		thread.start();
	}

	public void showParentThread(ThreadGroup threadGroup){
		parentThreadGroup = threadGroup;
		ArrayList<ThreadGroup> parentList = new ArrayList<ThreadGroup>();
		while(parentThreadGroup.getParent() != null){
			parentList.add(parentThreadGroup.getParent());
			parentThreadGroup = parentThreadGroup.getParent();
		}
		for(int i = (parentList.size() - 1); i >= 0 ; i--){
			System.out.println("ParentThread:" + parentList.get(i).getName());
		}
	}
	
	public void showThreadData(ThreadGroup threadGroup){
		threadGroup.enumerate(threadInGroup = new Thread[threadGroup.activeCount()], false);
		for(int i = 0; i < threadInGroup.length; i++){
			if(threadInGroup[i] != null){
				System.out.println("Thread:" + threadInGroup[i].getName());
			}
		}
	}
}
