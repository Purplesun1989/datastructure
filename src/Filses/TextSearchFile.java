package Filses;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author shkstart
 * @create 2023-05-26 13:55
 */
public class TextSearchFile {
    public static List<File> searchFiles(File folder, final String keyword) {
        List<File> result = new ArrayList<File>();
        if (folder.isFile())
            result.add(folder);

        File[] subFolders = folder.listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                if (file.isDirectory()) {
                    return true;
                }
                if (file.getName().toLowerCase().contains(keyword)) {
                    return true;
                }
                return false;
            }
        });

        if (subFolders != null) {
            for (File file : subFolders) {
                if (file.isFile()) {
                    result.add(file);
                } else {
                    result.addAll(searchFiles(file, keyword));
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String keyword="bootstrap";
        List<File> files = searchFiles(new File("C:\\Users\\xjh22\\Desktop\\Template\\Deal"), keyword);
        for (File file : files) {
            if(file!=null){
                File tempt=file;
                while(!tempt.getParentFile().getName().equals("Deal")){
                    tempt=tempt.getParentFile();
                }
                new deleteDic().deleteDirectory(tempt.getPath());
            }
            else{
                continue;
            }
        }
        List<File> filesJS = searchFiles(new File("C:\\Users\\xjh22\\Desktop\\Template\\Deal"), "js");
        for (File file : filesJS) {
            if(file!=null){
                File tempt=file;
                tempt.delete();
            }
            else{
                continue;
            }
        }
        System.out.println("共找到:"+filesJS.size()+files.size() + "个含有"+keyword+"或者js的文件,已为您全部删除！");
        deSolo deso=new deSolo();
        deso.desolo("C:\\Users\\xjh22\\Desktop\\Template\\Deal");
        System.out.println("为您删除了"+deso.getNum()+"个不合格的网页模板！");
    }
}
class deleteDic{
    public boolean deleteDirectory(String sPath) {
        if (!sPath.endsWith(File.separator)) {
            sPath = sPath + File.separator;
        }
        File dirFile = new File(sPath);
        if (!dirFile.exists() || !dirFile.isDirectory()) {
            return false;
        }
        boolean flag = true;
        File[] files = dirFile.listFiles();
        for (int i = 0; i < files.length; i++) {
            if (files[i].isFile()) {
                flag = deleteFile(files[i].getAbsolutePath());
                if (!flag) break;
            }
            else {
                flag = deleteDirectory(files[i].getAbsolutePath());
                if (!flag) break;
            }
        }
        if (!flag) return false;
        if (dirFile.delete()) {
            return true;
        } else {
            return false;
        }
    }
    boolean deleteFile(String sPath) {
        boolean flag = false;
        File file = new File(sPath);
        if (file.isFile() && file.exists()) {
            file.delete();
            flag = true;
        }
        return flag;
    }
}
class deSolo{
    int num=0;

    public int getNum() {
        return num;
    }

    void desolo(String sPath){
        if (!sPath.endsWith(File.separator)) {
            sPath = sPath + File.separator;
        }
        File foldder=new File(sPath);
        File[] tempt=new File[20];
        File[]files=foldder.listFiles();
        int count=0;
        for(int i=0;i<files.length;i++){
            tempt=files[i].listFiles();
            if(tempt.length>=20){
                continue;
            }
            else{
                for(int j=0;j<tempt.length;j++){
                    if(tempt[j].isDirectory()){
                        count++;
                    }
                }
            }
            if(tempt.length-count<=5){
                new deleteDic().deleteDirectory(files[i].getPath());
                num++;
            }
        }
    }
}