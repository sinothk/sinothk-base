package com.sinothk.base.utils;

import com.sinothk.base.entity.FileAttrEntity;

import java.io.File;

public class FileUtil {

    /**
     * 获取文件属性
     *
     * @param file
     * @return
     */
    public static FileAttrEntity getFileInfo(File file) {

        FileAttrEntity fileAttr = new FileAttrEntity();

        String fileAllName = file.getName();
        fileAttr.setFileAllName(fileAllName);
        fileAttr.setFileSize(file.length());

        String fileType = fileAllName.substring(fileAllName.lastIndexOf(".") + 1);
        fileAttr.setFileType(fileType);

        fileAttr.setFileName(fileAllName.replace("." + fileType, ""));

        fileAttr.setAbsolutePath(file.getAbsolutePath());

        return fileAttr;
    }

//    public static void main(String[] args) {
//        FileAttrEntity fileAttr = FileUtil.getFileInfo(new File("E:\\Tools\\Finder_Setup_v2.2.2.0_sem_007.exe"));
//        System.out.println(fileAttr.toString());
//    }
}
