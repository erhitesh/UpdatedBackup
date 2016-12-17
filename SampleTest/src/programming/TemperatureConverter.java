package programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TemperatureConverter {
	
	public static float getFahrenheit(float celcius){
		float fahrenheit = 0.0f;
		try {
			float dataFromKey = 0.0f;
			dataFromKey = celcius;
			fahrenheit = ((dataFromKey * 9) / (5)) + 32;
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
		return fahrenheit;
	}
	
	
	
	public static float getCelcius(float fahrenheit){
		float celcius = 0.0f;
		try {
			float dataFromKey = fahrenheit;
			celcius = ((fahrenheit-32)*5) / 9;
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
		return celcius;
	}
	
	
	
	public static void main(String args[]) throws NumberFormatException, IOException{
		System.out.println(getFahrenheit(Float.parseFloat(new BufferedReader(new InputStreamReader(System.in)).readLine())));
		System.out.println(getCelcius(Float.parseFloat(new BufferedReader(new InputStreamReader(System.in)).readLine())));
	}

}
