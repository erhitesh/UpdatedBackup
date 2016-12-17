package com.eduven.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class DeviceRelatedInformation{

/*	private class RuntimeExec {
		public StreamWrapper getStreamWrapper(InputStream is, String type){
			return new StreamWrapper(is, type);
		}
		private class StreamWrapper extends Thread {
			InputStream is = null;
			String type = null;
			String message = null;

			StreamWrapper(InputStream is, String type) {
				this.is = is;
				this.type = type;
			}

			public void run() {
				try {
					BufferedReader br = new BufferedReader(new InputStreamReader(is));
					StringBuffer buffer = new StringBuffer();
					String line = null;
					while ( (line = br.readLine()) != null) {
						buffer.append(line);//.append("\n");
					}
					message = buffer.toString();
				} catch (IOException ioe) {
					ioe.printStackTrace();
				}
			}  
		}
		// this is where the action is
		public void startAppium(String comand) {
			Runtime rt = Runtime.getRuntime();
			RuntimeExec rte = new RuntimeExec();
			StreamWrapper error, output;

			try {
				Process proc = rt.exec(comand);
				error = rte.getStreamWrapper(proc.getErrorStream(), "ERROR");
				output = rte.getStreamWrapper(proc.getInputStream(), "OUTPUT");
				//   int exitVal = 0;

				BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));
				String s;
				while((s = stdInput.readLine()) != null){
					System.out.println(s);
					if(s.contains("Appium REST http")){
						System.out.println("Started Appium Server");
						break;
					}
				}
				error.start();
				output.start();
				error.join(3000);
				output.join(3000);
				// exitVal = proc.waitFor();
				System.out.println("Output: "+output.message+"\nError: "+error.message);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		public void stopAppium(String comand) {
			Runtime rt = Runtime.getRuntime();
			RuntimeExec rte = new RuntimeExec();
			StreamWrapper error, output;

			try {
				Process proc = rt.exec(comand);
				error = rte.getStreamWrapper(proc.getErrorStream(), "ERROR");
				output = rte.getStreamWrapper(proc.getInputStream(), "OUTPUT");
				error.start();
				output.start();
				error.join(3000);
				output.join(3000);
				if(error.message.equals("") && output.message.equals(""))
					System.out.println("Closing Appium Server if already launched");
				else if(error.message.contains("No matching processes belonging to you were found")){
					//Display nothing as no instances of Appium Server were found running
				}
				else{
					System.out.println("Unable to Close Appium Server");
					System.out.println("Output: "+output.message+"\nError: "+error.message);
				}
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}


	public String getUDID(){
		String UDID="Could not find device!!";
		String command = "system_profiler SPUSBDataType";
		Runtime rt = Runtime.getRuntime();

		try {
			Process proc = rt.exec(command);
			BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));
			String s;
			while((s = stdInput.readLine()) != null){
				if(s.contains("Serial Number: ")){
					String temp= s.split("Serial Number: ")[1];
					if(temp.length()==40){
						UDID=temp;
						break;
					}
				}

			}
			System.out.println("UDID for device is : "+UDID);

		} catch (IOException e) {
			e.printStackTrace();
		}

		return UDID;
	}

	public String getDeviceName(){
		String UDID= getUDID();
		String DeviceName="Could not find device!!";
		String command = "xcrun instruments -s";
		Runtime rt = Runtime.getRuntime();

		try {
			Process proc = rt.exec(command);
			BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));
			String s;
			while((s = stdInput.readLine()) != null){
				if(s.contains(UDID)){
					String temp= s.split(" \\[")[0];
					DeviceName=temp;
				}

			}
			System.out.println("Device Name is : "+DeviceName);

		} catch (IOException e) {
			e.printStackTrace();
		}

		return DeviceName;
	}

	public String getUDID2(){
		String UDID="Could not find device!!";
		String command = "xcrun instruments -s";
		Runtime rt = Runtime.getRuntime();

		try {
			Process proc = rt.exec(command);
			BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));
			String s;
			while((s = stdInput.readLine()) != null){
				if(s.contains(" [")){
					String temp= s.split(" \\[")[1];
					if(!temp.contains("-")){

						UDID=temp.split("\\]")[0];
					}
				}

			}
			System.out.println("UDID for device is : "+UDID);

		} catch (IOException e) {
			e.printStackTrace();
		}

		return UDID;
	}
*/
	
	
	
	
	/* Get UDID of Device */
	public static String getUDID(){
		String UDID="Could not find device!!";
		String command = "system_profiler SPUSBDataType";
		Runtime rt = Runtime.getRuntime();

		try {
			Process proc = rt.exec(command);
			BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));
			String s;
			while((s = stdInput.readLine()) != null){
				if(s.contains("Serial Number: ")){
					String temp= s.split("Serial Number: ")[1];
					if(temp.length()==40){
						UDID=temp;
						break;
					}
			}
		}
	//System.out.println("UDID for device is : "+UDID);
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		return UDID;
	}
	
    /* Get Device Name */
	public static String getDeviceName(){
		String UDID= getUDID();
		String DeviceName="Could not find device!!";
		String command = "xcrun instruments -s";
		Runtime rt = Runtime.getRuntime();

		try {
			Process proc = rt.exec(command);
			BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));
			String s;
			while((s = stdInput.readLine()) != null){
				if(s.contains(UDID)){
					String temp= s.split(" \\[")[0];
					DeviceName=temp;
				}
			}
			//System.out.println("Device Name is : "+DeviceName);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return DeviceName;
	}

	
	public static void main(String args[]){
		System.out.println(getUDID());
		System.out.println(getDeviceName());
	}
	
}