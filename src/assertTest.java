
public class assertTest {
	static int val=3;
	static int getValue(){
		val--;
		return val;
	}
	public static void main(String args[]){
		int state = 0;
		for (int i=1;i<10;i++){
			state=getValue();
		}
		assert state>0;
	}
}
