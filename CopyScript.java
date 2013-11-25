import java.io.*;

public class CopyScript {

	public void launch(String from, String to) {
		this.copy(from, to);
	}
	
	public void copy(String from, String to) {
		File fromFile = new File("." + File.separator + from);
		File toFile = new File("." + File.separator + to);
		
		if (fromFile.exists()==false) {
			System.out.println("File " + from + " does not exist");
			return;
		}

		if (toFile.exists()) {
			System.out.println("File " + to + " exists, do you want to overwrite it (Y/N)?");
			String response=System.console().readLine();
			if (!response.equals("Y")) {
				System.out.println("Nothing done");
				return;
			}
		}
		
		BufferedReader in = null; // declare the buffered reader here so it can be accessed throughout the method
		PrintWriter out = null;
		
		try {
			in = new BufferedReader(new FileReader(fromFile)); // typical to use a FileReader in conjunction with BufferedReader for performance
			out = new PrintWriter(toFile);
			String line;
			while ((line = in.readLine()) != null) {
				out.println(line);
			}	
			in.close(); // close that file 
			out.close();
		} catch (FileNotFoundException ex) {
			System.out.println("The file to copy from " + toFile + " was not found");
		}  catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			out.close();
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
		CopyScript fs = new CopyScript();
		if (args.length<2)  {
			System.out.println("Please enter the from and to file names");
		} else {
			fs.launch(args[0], args[1]);
		}
	}
}