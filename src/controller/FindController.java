/**
 *Name : Tran Van Khoi
 *MSSV : HE130007
 *Email : khoitvhe130007@fpt.edu.vn
 *Lecturer : DuongTB
 */
package controller;

import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.awt.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Selection;
import view.FindDialog;

/**
 *
 * @author khoitvhe130007@fpt.edu.vn
 */
public class FindController {

    public FindController() {
    }

    /* get start and end of find text in text area */
    public Selection getSelectionPosition(String contentText, String findText, int startPosition,
            boolean isDown, boolean matchCase, boolean cbWrap) {
        Selection selection = new Selection();
        if (!matchCase) {
            contentText = contentText.toLowerCase();
            findText = findText.toLowerCase();
        }

        if (contentText.indexOf(findText, 0) == -1) {
            return null;
        }

        int searchTextIndex;

        if (isDown) {
            searchTextIndex = contentText.indexOf(findText, startPosition);
        } else {
            searchTextIndex = contentText.lastIndexOf(findText, startPosition - 1);
        } 
        if (searchTextIndex != -1) {    // if still find the word
            selection.setStart(searchTextIndex);
            selection.setEnd(searchTextIndex + findText.length());
            return selection;
        } else {    // not find the word
            if (cbWrap) { // if user want to wrap around
                if (isDown) {
                    searchTextIndex = contentText.indexOf(findText, 0);
                } else {
                    searchTextIndex = contentText.lastIndexOf(findText, contentText.length() - 1);
                }
                selection.setStart(searchTextIndex);
                selection.setEnd(searchTextIndex + findText.length());
                return selection;
            }
            return null;    // if user doesn't want to wrap around then can't find word anymore 
        }
    }

}
