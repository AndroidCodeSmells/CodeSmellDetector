package codesmell.entity;

import codesmell.AbstractSmell;

import java.util.ArrayList;
import java.util.List;

public class File {
    private String app, filePath;
    private List<AbstractSmell> codeSmells;

    public String getApp() {
        return app;
    }

    public List<AbstractSmell> getCodeSmells() {
        return codeSmells;
    }

    public String getFilePath() {
        return filePath;//((filePath != null && !filePath.isEmpty()));
    }

    public File(String app, String filePath) {
        this.app = app;
        this.filePath = filePath;
        this.codeSmells = new ArrayList<>();
    }

    public FileType getFileType(){
        String ext = this.filePath.substring(this.filePath.lastIndexOf("."));
        if(ext.toLowerCase().equals("xml"))
            return FileType.XML;
        else
            return FileType.JAVA;
    }

    public void addSmell(AbstractSmell smell) {
        codeSmells.add(smell);
    }

    public enum FileType{
        JAVA,
        XML
    }
}
