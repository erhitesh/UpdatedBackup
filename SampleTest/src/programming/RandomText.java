package programming;

import java.util.Random;
import java.util.UUID;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.text.WordUtils;
import org.openqa.selenium.NoSuchElementException;

public class RandomText {
	
	public static String randomTextGen(int wordlenght){
		StringBuffer strBuffer = new StringBuffer();
		Random ran = new Random();
		String str = "123456781@#$%^&*(9abcmsdownerpsdahnSJDIOSDMeojdondaldn57667wqwe9";
		char [] chars = str.toCharArray();
		for (int i = 0; i < wordlenght; i++){
			char charValue = chars[ran.nextInt(chars.length)];
			strBuffer.append(charValue);
		}
		//System.out.println(sb.toString());
		
		return strBuffer.toString();
	}
	
	public static int randomNumber(int number){
		int randomNumber = 0;
		try{
			Random ran = new Random();
			randomNumber = ran.nextInt(number);
		}catch(NoSuchElementException e){
			e.printStackTrace();
		}
		
		return randomNumber;
	}
	
	
	public static String getRandomStringUsingUUID(){
		String ran = UUID.randomUUID().toString();
		
		return ran;
	}
	
	
	public static String getRandomNumberUsingStringUtils(){
		String str = RandomStringUtils.randomAlphanumeric(12);//RandomStringUtils.randomAlphabetic(11).toLowerCase();
		RandomStringUtils.randomAscii(12);
		RandomStringUtils.randomNumeric(12);
	
		return str;
	}
	
	public static void main(String args[]){
		/*String text = "hitesh bjasdbad bajdbajd buabda";
		System.out.println(WordUtils.capitalize("Hitesh bhardwaj"));
		System.out.println(text.substring(0, 1).toUpperCase() + text.substring(1));*/
		/*String str = "Tomato And Bean Soup";
		for (int i = 0;i < str.length(); i++){
			char c = str.charAt(i);
			if (c == ' '){
				System.out.println("White Space");
			}
		}*/
		System.out.println(getRandomNumberUsingStringUtils());
		System.out.println(WordUtils.capitalize("hitesh bhardwaj sdklasnkda akndkidna nbaidbnakd bnadbakd mnkasnbdka"));
		System.out.println(WordUtils.capitalizeFully("hasjd asbdaj aba", 'a'));
	}

}
