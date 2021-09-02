/**
 *Name : Tran Van Khoi
 *MSSV : HE130007
 *Email : khoitvhe130007@fpt.edu.vn
 *Lecturer : DuongTB
 */
package controller;

import javax.swing.JOptionPane;
import model.Replacement;
import model.Selection;
import view.MainView;
import view.ReplaceDialog;

/**
 *
 * @author khoitvhe130007@fpt.edu.vn
 */
public class ReplaceController {

    public ReplaceController() {
    }

    /* replace selection word and move selection to next word */
    public Replacement replaceWord(String contentText, String findText, String replaceText, int startPosition,
            boolean isMatchCase, boolean isWrap) {
        Replacement replacement = new Replacement();
        String contentCopy = contentText;
        replacement.setContent(contentCopy);

        FindController findController = new FindController();
        Selection selection = findController.getSelectionPosition(contentText, findText, startPosition, true, isMatchCase, isWrap); // get current selected word

        if (selection == null) {
            return replacement;
        }
        contentCopy = contentCopy.substring(0, selection.getStart()) + replaceText + contentCopy.substring(selection.getStart() + findText.length(), contentCopy.length()); // replaced word
        replacement.setContent(contentCopy);

        Selection selectionNext = findController.getSelectionPosition(contentCopy, findText, selection.getStart() + replaceText.length(), true, isMatchCase, isWrap); // find next word
        if (selectionNext == null) {
            return replacement;
        }
        replacement.setStartNext(selectionNext.getStart());
        replacement.setEndNext(selectionNext.getEnd());

        return replacement;

    }

    /* replace all words that match the word user finds and replace them by replace word */
    public String replaceAllWord(String contentText, String findText, String replaceText, ReplaceDialog replaceDialog, boolean matchCase) {
        String contentCopy = contentText;
        if (contentText.isEmpty()) {     // if text area is empty 
            JOptionPane.showMessageDialog(replaceDialog, "No text field found", "Error", 2);
        } else {
            if (!matchCase) {
                contentText = contentText.replaceAll("(?i)" + findText, replaceText);
            } else {
                contentText = contentText.replaceAll(findText, replaceText);
            }
            if (contentText.equals(contentCopy)) {
                JOptionPane.showMessageDialog(replaceDialog, "Can't find \"" + findText + "\"", "Find", 2);
            }
        }
        return contentText;
    }

}
