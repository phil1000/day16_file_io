import java.io.*;

public class CatScript {

	public void launch(String fileName) {
		this.cat(fileName);
	}
	
	public void cat(String fileName) {
		File catFile = new File("." + File.separator + fileName);
		BufferedReader in = null; // declare the buffered reader here so it can be accessed throughout the method
		
		try {
			in = new BufferedReader(new FileReader(catFile)); // typical to use a FileReader in conjunction with BufferedReader for performance
			String line;
			while ((line = in.readLine()) != null) {
				System.out.println(line);
			}	
			in.close(); // close that file 
		} catch (FileNotFoundException ex) {
			System.out.println("File " + fileName + " not found");
		}  catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		CatScript fs = new CatScript();
		if (args.length==0)  {
			System.out.println("Enter the filename to cat");
		} else {
			fs.launch(args[0]);
		}
	}
}