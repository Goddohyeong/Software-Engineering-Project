import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DBManager {
	
	FileLoader loader;
	FileAnalyzer analyzer;
	
	
	public void make()
	{
		loader=new FileLoader();
		analyzer=new FileAnalyzer();
		 for(int i=0;i<loader.getFileNumber();i++){
			 
			RGB rgb=analyzer.getRGB(loader.getFile(i));
			 try {
				 BufferedWriter out= new BufferedWriter(new FileWriter("database.txt",true));
				 out.write(loader.getFileName(i)+";"+String.valueOf(rgb.get_red())+";"
						 +String.valueOf(rgb.get_blue())+";"+String.valueOf(rgb.get_green())+";");
				 out.newLine();
				 
				 out.flush();
				 out.close();
			 	 } catch (IOException e) {
			 		 System.err.println(e); // 에러가 있다면 메시지 출력
			 		 System.exit(1);
			 	   }
		 }	
	}
	public void insert(File file)
	{	
		//pictures 폴더에 file 추가
		
		analyzer=new FileAnalyzer();
		RGB rgb=analyzer.getRGB(file);
		 try {
			BufferedWriter out= new BufferedWriter(new FileWriter("database.txt",true));
			out.write(file.getName()+";"+String.valueOf(rgb.get_red())+";"
					 +String.valueOf(rgb.get_blue())+";"+String.valueOf(rgb.get_green())+";");
		} catch (IOException e) {
			// TODO Auto-generated catch block
	 		 System.err.println(e); // 에러가 있다면 메시지 출력
	 		 System.exit(1);
		}
	}
	
	public void delete(File file)
	{
		file.delete();
		this.make();
	}
	
}
