import java.io.*;

public class Writer {
  private String file;

  public Writer(String _file) {
    this.file = _file;
  }

  /***
    * Method to write to a file
    * @param content
  ***/
  public void writeToFile(String content) {
    try {
      FileWriter fw = new FileWriter(this.file, true);
      BufferedWriter bw = new BufferedWriter(fw);
      bw.write(content);
      bw.close();
    } catch(Exception e) {
      e.printStackTrace();
    }
  }
}