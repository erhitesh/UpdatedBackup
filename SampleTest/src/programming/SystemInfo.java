package programming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SystemInfo {

	public String executeCommandLine(String command){
		StringBuffer strBuffer = new StringBuffer();
		Process process;
		try {
			process = Runtime.getRuntime().exec(command);
			//process.waitFor();
			BufferedReader buffer = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line = "";
			while ((line = buffer.readLine())!= null){
				strBuffer.append(line + "\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return strBuffer.toString();
	}

	public static void main(String args[]) {
		SystemInfo sys = new SystemInfo();
		System.out.println(System.getProperty("os.name"));
		//System.out.println(sys.executeCommandLine("ping -c 3 google.com"));
		//System.out.println(sys.executeCommandLine("sw_vers"));

	}
}
