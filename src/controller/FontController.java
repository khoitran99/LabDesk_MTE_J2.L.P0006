/**
 *Name : Tran Van Khoi
 *MSSV : HE130007
 *Email : khoitvhe130007@fpt.edu.vn
 *Lecturer : DuongTB
 */
package controller;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import view.FontDialog;
import view.MainView;

/**
 *
 * @author khoitvhe130007@fpt.edu.vn
 */
public class FontController {

    private final String styles[] = {"Regular", "Bold", "Italic", "Bold Italic"};
    private final String fonts[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames(); // get list font family
    private final String sizes[] = {
        "8", "9", "10", "11", "12", "14", "16", "18", "20", "22", "24", "26", "28", "36", "48", "72"
    };
    public FontController() {
    }

    public String[] getStyles() {
        return styles;
    }

    public String[] getFonts() {
        return fonts;
    }

    public String[] getSizes() {
        return sizes;
    }

    /* style from int value to string value . 0 - regular , 1 - Bold , 2 - Italic , 3 - Bold Italic */
    public String styleToString(int style) {
        String result = "";
        switch (style) {
            case 0:
                result = "Regular";
                break;
            case 1:
                result = "Bold";
                break;
            case 2:
                result = "Italic";
                break;
            case 3:
                result = "Bold Italic";
                break;
        }
        return result;
    }

    /* change font of text area in main view */
    public void changeMainViewFont(String font, int style, String size, MainView mainView, FontDialog fontDialog) {
        /* regex for number and can repeat 0 or more times */
        String regexSize = "^[0-9]*$";
        Pattern pattern = Pattern.compile(regexSize);
        Matcher matcher = pattern.matcher(size);
        /*check size is not empty*/
        if (!size.isEmpty()) {
            /* check size is a number */
            if (matcher.find()) {   // if txtSize is match pattern
                mainView.getTxtArea().setFont(new Font(font, style, Integer.parseInt(size)));
                fontDialog.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(fontDialog, "Size must be a number", "Font", 2);
            }
        } else {
            JOptionPane.showMessageDialog(fontDialog, "Size can't be null", "Font", 2);
        }
    }

    /* get value from txtSize */
    public int getTextSize(String size, FontDialog fontDialog) {
        if (size.isEmpty()) {
            return -1;
        }
        try {
            int sizeNumber = Integer.parseInt(size);
            if (sizeNumber <= 0) {
                JOptionPane.showMessageDialog(fontDialog, "Size can't be empty!");
            }
            return sizeNumber;
        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(fontDialog, "Can't input string!");
        }
        return -1;
    }
}
