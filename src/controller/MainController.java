/**
 *Name : Tran Van Khoi
 *MSSV : HE130007
 *Email : khoitvhe130007@fpt.edu.vn
 *Lecturer : DuongTB
 */
package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import view.MainView;

/**
 *
 * @author khoitvhe130007@fpt.edu.vn
 */
public class MainController {

    public MainController() {
    }
    
    /* read file and return content of the file */
    public String readFile(File file) throws FileNotFoundException, IOException {
        FileInputStream inputStream = new FileInputStream(file);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream)); //Java BufferedReader class is used to read the text from a character-based input stream. It can be used to read data line by line by readLine() method.
        String str = "";
        String result = "";
        while (str != null) {
            str = reader.readLine();
            if (str == null) {
                break;
            }
            result += str + "\n";
        }
        return result;
    }

    /* open file in computer and return File */
    public File openFile(JFileChooser chooser, MainView mainView) {
        File fileCheck = null;
        while (true) {
            chooser.showOpenDialog(mainView);
            fileCheck = chooser.getSelectedFile();
            if (fileCheck.exists()) {
                break;
            }
            JOptionPane.showConfirmDialog(mainView,
                    "File not found", "Open", JOptionPane.INFORMATION_MESSAGE);
        }
        return fileCheck;
    }

    /* write data from text area in main view to selected file in computer */
    public void writeToFile(File file, String content) throws IOException {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            fileWriter.write(content);
        } catch (IOException e) {
            throw e;
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException ex) {
                    throw ex;
                }
            }
        }
    }
}
