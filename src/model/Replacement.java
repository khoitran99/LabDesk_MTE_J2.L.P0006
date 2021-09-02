/**
 *Name : Tran Van Khoi
 *MSSV : HE130007
 *Email : khoitvhe130007@fpt.edu.vn
 *Lecturer : DuongTB
 */
package model;

/**
 *
 * @author khoitvhe130007@fpt.edu.vn
 */
public class Replacement {

    private int startNext;
    private int endNext;
    private String content;

    public Replacement() {
    }

    public int getStartNext() {
        return startNext;
    }

    public void setStartNext(int startNext) {
        this.startNext = startNext;
    }

    public int getEndNext() {
        return endNext;
    }

    public void setEndNext(int endNext) {
        this.endNext = endNext;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
