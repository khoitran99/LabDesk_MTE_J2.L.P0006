/**
 *Name : Tran Van Khoi
 *MSSV : HE130007
 *Email : khoitvhe130007@fpt.edu.vn
 *Lecturer : DuongTB
 */
package view;

import controller.MainController;
import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;

/**
 *
 * @author khoitvhe130007@fpt.edu.vn
 */
public class MainView extends javax.swing.JFrame {

    File currentFile;           //  file is used in program
    String fileContent = "";    //  store content of file 
    JFileChooser chooser;       //  save file as dialog , open file 
    UndoManager undoManager;
    MainController mainController;

    /**
     * Creates new form View
     */
    public MainView() {
        initComponents();
        chooser = new JFileChooser();
        undoManager = new UndoManager();
        txtArea.getDocument().addUndoableEditListener(undoManager);  // add undoManager to txtArea
        mainController = new MainController();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtArea = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuFile = new javax.swing.JMenu();
        fileNew = new javax.swing.JMenuItem();
        fileOpen = new javax.swing.JMenuItem();
        fileSave = new javax.swing.JMenuItem();
        fileSaveAs = new javax.swing.JMenuItem();
        fileExit = new javax.swing.JMenuItem();
        menuEdit = new javax.swing.JMenu();
        editUndo = new javax.swing.JMenuItem();
        editRedo = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        editCut = new javax.swing.JMenuItem();
        editCopy = new javax.swing.JMenuItem();
        editPaste = new javax.swing.JMenuItem();
        editSelectAll = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        editFind = new javax.swing.JMenuItem();
        editReplace = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        editFont = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        txtArea.setColumns(20);
        txtArea.setRows(5);
        txtArea.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtAreaCaretUpdate(evt);
            }
        });
        jScrollPane1.setViewportView(txtArea);

        menuFile.setText("File");

        fileNew.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        fileNew.setText("New");
        fileNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileNewActionPerformed(evt);
            }
        });
        menuFile.add(fileNew);

        fileOpen.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        fileOpen.setText("Open");
        fileOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileOpenActionPerformed(evt);
            }
        });
        menuFile.add(fileOpen);

        fileSave.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        fileSave.setText("Save");
        fileSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileSaveActionPerformed(evt);
            }
        });
        menuFile.add(fileSave);

        fileSaveAs.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        fileSaveAs.setText("Save As");
        fileSaveAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileSaveAsActionPerformed(evt);
            }
        });
        menuFile.add(fileSaveAs);

        fileExit.setText("Exit");
        fileExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileExitActionPerformed(evt);
            }
        });
        menuFile.add(fileExit);

        jMenuBar1.add(menuFile);

        menuEdit.setText("Edit");

        editUndo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
        editUndo.setText("Undo");
        editUndo.setEnabled(false);
        editUndo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editUndoActionPerformed(evt);
            }
        });
        menuEdit.add(editUndo);

        editRedo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.CTRL_MASK));
        editRedo.setText("Redo");
        editRedo.setEnabled(false);
        editRedo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editRedoActionPerformed(evt);
            }
        });
        menuEdit.add(editRedo);
        menuEdit.add(jSeparator1);

        editCut.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        editCut.setText("Cut");
        editCut.setEnabled(false);
        editCut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editCutActionPerformed(evt);
            }
        });
        menuEdit.add(editCut);

        editCopy.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        editCopy.setText("Copy");
        editCopy.setEnabled(false);
        editCopy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editCopyActionPerformed(evt);
            }
        });
        menuEdit.add(editCopy);

        editPaste.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        editPaste.setText("Paste");
        editPaste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editPasteActionPerformed(evt);
            }
        });
        menuEdit.add(editPaste);

        editSelectAll.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        editSelectAll.setText("Select All");
        editSelectAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editSelectAllActionPerformed(evt);
            }
        });
        menuEdit.add(editSelectAll);
        menuEdit.add(jSeparator2);

        editFind.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        editFind.setText("Find");
        editFind.setEnabled(false);
        editFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editFindActionPerformed(evt);
            }
        });
        menuEdit.add(editFind);

        editReplace.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        editReplace.setText("Replace");
        editReplace.setEnabled(false);
        editReplace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editReplaceActionPerformed(evt);
            }
        });
        menuEdit.add(editReplace);

        jMenuBar1.add(menuEdit);

        jMenu3.setText("Format");

        editFont.setText("Font...");
        editFont.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editFontActionPerformed(evt);
            }
        });
        jMenu3.add(editFont);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void editRedoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editRedoActionPerformed
        try {
            if (undoManager.canRedo()) {
                undoManager.redo();
            }
        } catch (CannotRedoException e) {
            JOptionPane.showMessageDialog(this, "Can't redo");
        }
    }//GEN-LAST:event_editRedoActionPerformed

    private void fileNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileNewActionPerformed
        createNewFile();
    }//GEN-LAST:event_fileNewActionPerformed

    private void fileSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileSaveActionPerformed
        writeTextAreaToFile();
    }//GEN-LAST:event_fileSaveActionPerformed

    private void fileSaveAsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileSaveAsActionPerformed
        saveAsToFile();
    }//GEN-LAST:event_fileSaveAsActionPerformed

    private void fileOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileOpenActionPerformed
        openFile();
    }//GEN-LAST:event_fileOpenActionPerformed

    private void fileExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileExitActionPerformed
        checkClose(false);
    }//GEN-LAST:event_fileExitActionPerformed

    private void editUndoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editUndoActionPerformed
        try {
            if (undoManager.canUndo()) {
                undoManager.undo();
            }
        } catch (CannotUndoException e) {
            JOptionPane.showMessageDialog(this, "Can't undo");
        }
    }//GEN-LAST:event_editUndoActionPerformed

    private void editCutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editCutActionPerformed
        txtArea.cut();
    }//GEN-LAST:event_editCutActionPerformed

    private void editCopyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editCopyActionPerformed
        txtArea.copy();
    }//GEN-LAST:event_editCopyActionPerformed

    private void editPasteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editPasteActionPerformed
        txtArea.paste();
    }//GEN-LAST:event_editPasteActionPerformed

    private void editSelectAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editSelectAllActionPerformed
        txtArea.selectAll();
    }//GEN-LAST:event_editSelectAllActionPerformed

    private void editFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editFindActionPerformed
        FindDialog findDialog = new FindDialog(this);
        findDialog.setLocationRelativeTo(null);
        findDialog.setResizable(false);
        findDialog.setVisible(true);
    }//GEN-LAST:event_editFindActionPerformed

    private void editReplaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editReplaceActionPerformed
        ReplaceDialog replaceDialog = new ReplaceDialog(this);
        replaceDialog.setLocationRelativeTo(null);
        replaceDialog.setResizable(false);
        replaceDialog.setVisible(true);
    }//GEN-LAST:event_editReplaceActionPerformed

    private void editFontActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editFontActionPerformed
        FontDialog fontDialog = new FontDialog(this);
        fontDialog.setLocationRelativeTo(null);
        fontDialog.setResizable(false);
        fontDialog.setVisible(true);
        fontDialog.initFontData(this);
    }//GEN-LAST:event_editFontActionPerformed

    private void txtAreaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtAreaCaretUpdate
        canUndoRedo();
        canEdit();
    }//GEN-LAST:event_txtAreaCaretUpdate

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        checkClose(true);
    }//GEN-LAST:event_formWindowClosing

    /* check if content in file is modified or not */
    public boolean checkFileSaved() {
        boolean isSaved = fileContent.equals(txtArea.getText());
        /* check user choose yes or no */
        if (isSaved == false) {
            int option = JOptionPane.showConfirmDialog(this,
                    "Do you want to save the changes to file",
                    "Confirm",
                    JOptionPane.YES_NO_CANCEL_OPTION);

            if (option == JOptionPane.YES_OPTION) { // user choose yes
                if (currentFile == null) {  // user doesn't have current file 
                    saveAsToFile();
                } else {                    // user is in exist file
                    writeTextAreaToFile();
                }
            }
            if (option == JOptionPane.CANCEL_OPTION) {  // user choose cancel
                return true;
            }
        }
        return false; // user choose no option or file is not modified
    }

    /* save to file function*/
    public void saveAsToFile() {
        File checkFile = null;
        while (true) {
            try {
                chooser.showSaveDialog(this);
            } catch (HeadlessException e) {
                return;
            }
            checkFile = chooser.getSelectedFile();
            if (!checkFile.exists()) {  // if file doesn't exist 
                break;
            }
            int option = JOptionPane.showConfirmDialog(this,
                    "Do you want to replace it?", "Save As", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {   // user choose yes
                break;
            } else {                                  // user choose no
                return;
            }
        }
        currentFile = checkFile;
        fileContent = "";
        writeTextAreaToFile();
    }

    /* write text from textarea to file  */
    public void writeTextAreaToFile() {
        try {
             /* if user don't have current file then save as to a folder */
            if (currentFile == null) {
                saveAsToFile();
                return;
            }
            /* write content of text area to file */
            mainController.writeToFile(currentFile, txtArea.getText());
            fileContent = txtArea.getText();
        } catch (IOException e) {
            showErrorMessage(e.toString());
        }
    }
     
    /* create new file */
    public void createNewFile() {
        /* check if user save file or not */
        if (checkFileSaved()) {
            return;
        }
        currentFile = null;
        fileContent = "";
        txtArea.setText("");
    }

    /* open file dialog to open file in computer */
    public void openFile() {
        /* check user save file or not */
        if (checkFileSaved()) {
            return;
        }
        currentFile = mainController.openFile(chooser, this);
        txtArea.setText("");
        readFile();
        
    }
    
    /* read file in computor and display to text area */
    public void readFile() {
        try {
            FileInputStream inputStream = new FileInputStream(currentFile);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream)); //Java BufferedReader class is used to read the text from a character-based input stream. It can be used to read data line by line by readLine() method.
            txtArea.setText(mainController.readFile(currentFile));
            fileContent = txtArea.getText();
            txtArea.setCaretPosition(0);
        } catch (IOException e) {
            showErrorMessage(e.toString());
        }
    }

    /* show error message if there are any exceptions */
    public void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(this, "Error : " + message, "Error", 2);
    }

    /* check if user can undo or redo */
    public void canUndoRedo() {
        /* if text can undo */
        if (undoManager.canUndo()) {
            editUndo.setEnabled(true);
        } else {
            editUndo.setEnabled(false);
        }
        /* if text can redo */
        if (undoManager.canRedo()) {
            editRedo.setEnabled(true);
        } else {
            editRedo.setEnabled(false);
        }
    }

    /* Check if content in text area is empty or not , if empty , disable Find and Replace function */
    public void canEdit() {
        String content = txtArea.getText();
        /* if text area doesn't have any words */
        if (content.isEmpty()) {
            editFind.setEnabled(false);
            editReplace.setEnabled(false);
        } else {
            editFind.setEnabled(true);
            editReplace.setEnabled(true);
        }
        /*if user selects any words in text area*/
        if (txtArea.getSelectedText() != null) {
            editCut.setEnabled(true);
            editCopy.setEnabled(true);
        } else {
            editCut.setEnabled(false);
            editCopy.setEnabled(false);
        }
    }

    /* Close when user click X icon or exit */
    public void checkClose(boolean isXButton) {
        if (isXButton) {
            this.setDefaultCloseOperation(MainView.DO_NOTHING_ON_CLOSE); // when close , if user click cancel , user still stay in program .
        }
        /* check user save file or not */
        if (checkFileSaved()) {
            return;
        }
        System.exit(0);
    }

    public JTextArea getTxtArea() {
        return txtArea;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem editCopy;
    private javax.swing.JMenuItem editCut;
    private javax.swing.JMenuItem editFind;
    private javax.swing.JMenuItem editFont;
    private javax.swing.JMenuItem editPaste;
    private javax.swing.JMenuItem editRedo;
    private javax.swing.JMenuItem editReplace;
    private javax.swing.JMenuItem editSelectAll;
    private javax.swing.JMenuItem editUndo;
    private javax.swing.JMenuItem fileExit;
    private javax.swing.JMenuItem fileNew;
    private javax.swing.JMenuItem fileOpen;
    private javax.swing.JMenuItem fileSave;
    private javax.swing.JMenuItem fileSaveAs;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JMenu menuEdit;
    private javax.swing.JMenu menuFile;
    private javax.swing.JTextArea txtArea;
    // End of variables declaration//GEN-END:variables
}
