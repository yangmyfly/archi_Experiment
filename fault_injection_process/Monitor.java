
public class Monitor {
	public static void main(String[] args){
		String directory;
		String fault;
		int responseTime;
		int updateTime;
		
		//start  thread1
		directory = "";
		fault = "";
		responseTime = 120;
		updateTime = 5;
		HandleThread template1 = new HandleThread(fault, directory,  responseTime,  updateTime);
		template1.start();
		
		//start thread2
		directory = "";
		fault = "";
		responseTime = 120;
		updateTime = 5;
		HandleThread template2 = new HandleThread(fault, directory,  responseTime,  updateTime);
		template2.start();
		
		//start thread3
		//...
	}

}
