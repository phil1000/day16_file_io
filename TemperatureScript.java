import java.io.*;

public class TemperatureScript {

	public void launch(String temperatureFile) {
		this.temperature(temperatureFile);
	}
	
	public void temperature(String temperatureFile) {
		File tempFile = new File("." + File.separator + temperatureFile);
		
		BufferedReader in = null; // declare the buffered reader here so it can be accessed throughout the method
		
		try {
			in = new BufferedReader(new FileReader(tempFile)); // typical to use a FileReader in conjunction with BufferedReader for performance
			double overallAverage=0;
			String line;
			int numberOfLines=0;
			while ((line = in.readLine()) != null) {
				String[] strArray = line.split(",");
				double lineAverage=0;
				for (int i=0; i<strArray.length; i++) {
					lineAverage=lineAverage+Double.parseDouble(strArray[i]);
				}
				lineAverage=lineAverage/strArray.length;
				System.out.println("line average for line " + line + " is " + lineAverage);
				numberOfLines++;
				overallAverage=overallAverage+lineAverage;
			}	
			overallAverage=overallAverage/numberOfLines;
			System.out.println("overall average is " + overallAverage);
			in.close(); // close that file 
		} catch (FileNotFoundException ex) {
			System.out.println("File " + temperatureFile + " was not found");
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
		TemperatureScript fs = new TemperatureScript();
		if (args.length<1)  {
			System.out.println("Please enter the temperature filename");
		} else {
			fs.launch(args[0]);
		}
	}
}