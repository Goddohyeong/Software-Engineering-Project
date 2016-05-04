import java.io.File;
import java.io.FileReader;

public class FileLoader {
	
	private File pictures = new File("pictures"); //Æú´õ¸í picture
	private String[] filenames = pictures.list();
	FileLoader() {
		
	}
	
	 public int getFileNumber(){
		return 	filenames.length;
	}
	 public String getFileName(int i){
		 return filenames[i];
	 }
	 public void insertFile(String name)
	 {
		 filenames[filenames.length+1]=name;
	 }
	 public File getFile(int i)
	 {
		 String fileName="filenames[i]+.jpg";
		 File file = new File("fileName");
		 return file;
	 }
}

