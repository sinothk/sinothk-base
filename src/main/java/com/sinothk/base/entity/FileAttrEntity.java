package com.sinothk.base.entity;

public class FileAttrEntity {

    private String fileAllName;
    private String fileName;
    private String fileType;

    private String absolutePath;

    private long fileSize;

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileAllName() {
        return fileAllName;
    }

    public void setFileAllName(String fileAllName) {
        this.fileAllName = fileAllName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getAbsolutePath() {
        return absolutePath;
    }

    public void setAbsolutePath(String absolutePath) {
        this.absolutePath = absolutePath;
    }

    @Override
    public String toString() {
        return "FileAttrEntity{" +
                "fileAllName='" + fileAllName + '\'' +
                ", fileName='" + fileName + '\'' +
                ", fileType='" + fileType + '\'' +
                ", absolutePath='" + absolutePath + '\'' +
                ", fileSize=" + fileSize +
                '}';
    }
}
