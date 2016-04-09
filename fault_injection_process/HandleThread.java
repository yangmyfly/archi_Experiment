import java.io.*;

public class HandleThread extends Thread{
	String fault;
	String directory;
	int totalTime;
	int updateTime;
	
	HandleThread(String ft, String dir, int t, int u){
		this.fault = ft;
		this.directory = dir;
		this.totalTime = t;
		this.updateTime = u;
	}
	
	public void showResponse(){
		try{
			BufferedReader respReader=new BufferedReader(new FileReader(this.directory + File.separator + "response.txt"));
			String line=respReader.readLine();
			while(line != null){
				System.out.println(line);
				line=respReader.readLine();
			}
			respReader.close();
			
		}catch(IOException e){
			System.out.println("No response!");
		}
	}
	
	public void run(){
			
		try{
			// create a child process to inject the fault (run .jar)
			ProcessBuilder injectPB = new ProcessBuilder("java", "-jar", this.fault);	
			// start the process
			long startTime = System.currentTimeMillis();
			Process p1 = injectPB.start();
			
			// monitor three files, response.txt, success.txt, failure.txt		
			while(System.currentTimeMillis() - startTime <= totalTime * 1000){
				try{
					FileReader success = new FileReader(this.directory + File.separator + "success.txt");
					success.close();
					// the success signal
					System.out.println("success!");
					// show the response context
					showResponse();
					break;
					
				} catch (FileNotFoundException e){
					try{
						FileReader failure = new FileReader(this.directory + File.separator + "failure.txt");
						failure.close();
						// the failure signal
						System.out.println("failure!");
						// show the response context
						showResponse();
						break;
				
					} catch (FileNotFoundException e1){
						// there is no failure or success file.
						// show the response context
						showResponse();
										
					}				
				}
				
				// sleep the update time
				sleep(this.updateTime * 1000);
			}
			
			//wait for p1 exit  
		    int exitVal = p1.waitFor();  
		    System.out.println("the return code is " + exitVal);  
			
		} catch (Throwable t){
			t.printStackTrace();
		}	
	}
	
	
}
