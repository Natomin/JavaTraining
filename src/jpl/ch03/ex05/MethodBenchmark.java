package jpl.ch03.ex05;
//他のベンチマークを行う新たな拡張クラスを作成
//0からパラメータで渡された値までループするのに要する時間を測るとか
public class MethodBenchmark extends Benchmark{
	private int loopNum = 0;

	@Override
	void benchmark() {
		for(int i = 0; i < loopNum; i++){
		}
	}
	
	public void setLoopNum(int loopNum){
		this.loopNum = loopNum;
	}
	

}
