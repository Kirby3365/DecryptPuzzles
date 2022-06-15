import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class files {

  public static void write(int[] myArray) {

    try {
      BufferedWriter writer = new BufferedWriter(new FileWriter("myFile.txt", false));
      for (int i = 0; i < myArray.length; i++) {
        writer.write("" + +myArray[i]);
        writer.newLine();
      }
      writer.flush();
      System.out.println("Data Entered in to the file successfully");
    } catch (Exception e) {
      // Ignore it
    }
  }

  public static void String_write(String s, String filename) {

    try {
      BufferedWriter writer = new BufferedWriter(new FileWriter(filename, false));
            writer.write(s);
      
      writer.flush();
      System.out.println("Data Entered in to the file successfully");
    } catch (Exception e) {
      // Ignore it
    }
  }

  public static int[] read(String filename) {

    try{
    BufferedReader abc = new BufferedReader(new FileReader(filename));
    ArrayList<String> lines = new ArrayList<String>();

    String line = abc.readLine();

    do {
      lines.add(line);
      line = abc.readLine();
    } while (line != null);

    abc.close();

    // If you want to convert to a String[]
    String[] data = lines.toArray(new String[] {});
    int[] output = new int[data.length];

    for(int i =0; i < data.length; i++){
      output[i] = Integer.parseInt(data[i]);  
      }
      return output;
      }
    catch(Exception e){
      
    }


   return new int[1]; 
  }

  public static String String_read(String filename) {
String output = "";
    try{
    BufferedReader abc = new BufferedReader(new FileReader(filename));
    ArrayList<String> lines = new ArrayList<String>();

    String line = abc.readLine();

    do {
      lines.add(line);
      line = abc.readLine();
    } while (line != null);

    abc.close();

    // If you want to convert to a String[]
    

      for(String l : lines){
        output+=l;
      }
     } catch(IOException i){
      
     }
    return output;
  
}
}