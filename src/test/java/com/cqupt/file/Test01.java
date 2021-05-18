package com.cqupt.file;

import org.junit.Test;

import java.io.*;

public class Test01 {
    @Test
    public void testFile(){
        File srcFile=new File("E:\\java");
        File desFile=new File("C:\\");
        copy(srcFile,desFile);
    }
    public static void copy(File srcFile,File desFile){
        FileInputStream fis=null;
        FileOutputStream fos=null;
        String name=srcFile.getAbsolutePath();
        String name1=name.replace("E:\\",desFile.getAbsolutePath().endsWith("\\")?desFile.getAbsolutePath():desFile.getAbsolutePath()+"\\");
        /*System.out.println(name1);
        System.out.println(name);*/
        if (new File(name1).exists()){
            System.out.println("the file is existing！！！！！");
            return;
        }
        if (!srcFile.isDirectory()){
            try {
                fis=new FileInputStream(name);
                fos=new FileOutputStream(name1);
                byte[] bytes=new byte[1024*1024];
                int readCount;
                while ((readCount=fis.read(bytes))!=-1){
                    fos.write(bytes,0,readCount);
                }
                fos.flush();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (fis!=null){
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (fos!=null){
                    try {
                        fos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }else {
            File file1=new File(name1);
            file1.mkdirs();
            File[] files=srcFile.listFiles();
            for (File f:files){
                copy(f,desFile);
            }
        }
    }
}
