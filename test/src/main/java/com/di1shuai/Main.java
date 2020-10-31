package com.di1shuai;

import java.io.File;
import java.io.IOException;
import java.nio.channels.Selector;
import java.util.*;

/**
 * @author Bruce
 * @date 10/13/16
 */
public class Main {


    public static void main(String[] args) throws IOException {
        String path = "/Users/shuai/Documents/GitRepo/mine/back-end";
        File parentFile = new File(path);
        if (!parentFile.isDirectory()){
            throw new RuntimeException();
        }

        renameFiles(parentFile,"diyishuai","di1shuai");

    }

    public static void renameFiles(File directory,String source,String traget){
        if (directory.isFile()){
            return;
        }
        File[] files = directory.listFiles();
        if (files.length==0){
            return;
        }
        File file = null;
        for (int i = 0; i < files.length; i++) {
            file = files[i];
            if (source.equals(file.getName())){
                File targetFile = new File(file.getParent()+File.separator+traget);
                boolean renameOK = file.renameTo(targetFile);
                if (renameOK){
                    file = targetFile;
                }else {
                    throw new RuntimeException();
                }
                System.out.println(file.getAbsolutePath());
            }
            if (file.isDirectory()){
                renameFiles(file,source,traget);
            }
        }
    }


}
