package programming;

import java.io.File;
import java.util.List;


public class DeleteFileAfterNDays {
	
	static String filePath = "/Users/hiteshbhardwaj/Desktop/Untitled.pdf";
	
	public static void deleteFile(long days, String fileExtension){
		
		/* File Location */
		File fileList = new File(filePath);
		if (fileList.exists()){
			File[] list_files = fileList.listFiles();
			long checkFileDeleteStatus = System.currentTimeMillis() - (days * 24 * 60 * 60 * 1000L);
			for (File listfile : list_files){
				if (listfile.getName().endsWith(fileExtension) && listfile.lastModified() < checkFileDeleteStatus){
					/*listfile.delete();*/
					if (!listfile.delete()){
						System.out.println(" Unable to delete the file SuccessFully."+listfile.getName());
					}
					else {
						System.out.println(" File SuccessFully Deleted.");
					}
				}
			}
		}
	}
	
	public static void createFolders(List<String> folderList){
		String screenshot_lacation = "/Users/hiteshbhardwaj/Desktop/Automation/workspace/SampleTest/ScreenCaptures/";
		File file = new File(screenshot_lacation);
		if (file.exists() == true){
		}
		else if (file.exists() == false){
			file.mkdir();
		}
		//Create App Name folder
		File appNameFolder = new File(screenshot_lacation+"Icelandic"+"/");
		if (appNameFolder.exists() == true){
		}
		else if (appNameFolder.exists() == false){
			appNameFolder.mkdir();
		}
		// Create language name folder inside app.
		for (int i = 0; i < folderList.size(); i++){
			File appLanguageName = new File(appNameFolder+"/"+folderList.get(i));
			if (appLanguageName.exists() == true){
			}
			else if (appLanguageName.exists() == false){
				appLanguageName.mkdir();
			}
		}
	}
	public static void main(String args[]){
	/*	List<String> list = new ArrayList<String>();
		list.add("test1");
		list.add("test2");
		list.add("test3");
		list.add("test4");
		System.out.println(File.listRoots());
		createFolders(list);*/
		
		deleteFile(1, ".pdf");
		
	}
}
