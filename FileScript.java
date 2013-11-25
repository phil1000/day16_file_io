import java.io.*;

public class FileScript {

	public void launch(String newDirectory) {
		this.ls(); // lists all the names of the files in the current directory
		if (newDirectory!="") this.mkdir(newDirectory);
	}
	
	public void ls() {
		File directory = new File(".");
		File[] files = directory.listFiles();
		for (int i=0;i<files.length;i++) {
			System.out.println(files[i].getName());
		}
	}
	
	public void mkdir(String directoryName) {
		File currentDirectory = new File("." + File.separator + directoryName);
		currentDirectory.mkdirs();
		this.ls();
	}
	
	public static void main(String[] args) {
		FileScript fs = new FileScript();
		String newDirectory="";
		if (args.length>0)  newDirectory=args[0];
		fs.launch(newDirectory);
	}
}