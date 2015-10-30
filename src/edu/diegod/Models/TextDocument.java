package edu.diegod.Models;

import javax.swing.*;
import java.io.*;

/**
 * Created by diego-d on 10/28/15.
 */
public class TextDocument {
    private String fileName;
    private String contents;
    private File file;

    public TextDocument() {
    }

    public void saveFileAs(String pathname) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(pathname);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "El fichero no puede ser guardado");
        }
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(this.contents);
            bufferedWriter.close();
            JOptionPane.showMessageDialog(null, "El fichero ha sido guardado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "El fichero no puede ser guardado");
        }
    }

    public void saveFile() {
        String pathname = file.getPath();
        saveFileAs(pathname);
    }

    public void openFile() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(null);
        this.file = fileChooser.getSelectedFile();
        this.fileName = file.getName();
        try {
            FileReader fileReader = new FileReader(this.file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String fileText = "";
            String fileLine = "";
            while (((fileLine = bufferedReader.readLine()) != null)) {
                fileText += fileLine + "\n";
            }
            this.contents = fileText;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "El fichero no se ha podido abrir");
        }
    }

    public void renameFile(String newName) {
        String newFilePathName = file.getParent() + "/" + newName;
        File newFile = new File(newFilePathName);
        if (file.renameTo(newFile)) {
            JOptionPane.showMessageDialog(null, "El fichero ha sido renombrado");
            this.file = newFile;
            this.fileName = newFile.getName();
        } else
            JOptionPane.showMessageDialog(null, "El fichero no puede ser renombrado");
    }

    public void deleteFile() {
        if (file.delete())
            JOptionPane.showMessageDialog(null, "El fichero ha sido borrado");
        else
            JOptionPane.showMessageDialog(null, "El fichero no puede ser borrado");
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
