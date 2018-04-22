import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
	public static void main(String[] args) {
		try {
			Scanner scan = new Scanner();
			File file = new File("input.txt");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			//output
            File outputFile = new File("output.txt");
            if (!outputFile.exists())
                outputFile.createNewFile();
            BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile, false));
            
            bw.write("Source Program:");
            bw.newLine();
			while((line=bufferedReader.readLine()) != null){
				System.out.println(line);
				bw.write(line);
                bw.newLine();
			}
            bw.newLine();
            bw.newLine();

			
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);

			bw.write("All Tokens: ");
			bw.newLine();
			while ((line = bufferedReader.readLine()) != null) {
	            if(line.charAt(0) == '#')
	            	continue;
				Token input = new Token(line);
				State s;
				Token out;				
	            
				while(input.hasNext()){
		            out = scan.scan(input);
		            if(input.ifSkip()){
		            	break;
		            }
		            if(out != null){
		            	System.out.println(out);
		            	bw.write(out.toString());
		            	bw.newLine();
		            }
		            
		        }
			}
			bw.newLine();
			bw.newLine();
			bw.newLine();
			bw.write("SYMTAB: ");
			bw.newLine();
			
			for(Token a : scan.getBookkeeper().getSymtab()){
				bw.write(a.getValue() + "\t\t\t" + a.getTag());
				bw.newLine();
			}
			bw.flush();
            bw.close();
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
