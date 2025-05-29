package Filses;

import java.io.*;

/**
 * @author shkstart
 * @create 2022-12-26 12:07
 */
 class copy {
    String urlin;
    String urlprint;
    public copy(String urlin,String urlprint){
        this.urlin=urlin;
        this.urlprint=urlprint;
    }
    void read() throws Exception {
        File infile=new File(urlin);
        File printfile=new File(urlprint);
        BufferedReader reader=new BufferedReader(new FileReader(infile));
        BufferedWriter writer=new BufferedWriter(new FileWriter(printfile,true));
        String Inlines=null;
        while((Inlines=reader.readLine())!=null){
            writer.write(Inlines+"\n");
        }
        writer.newLine();
        writer.close();
        reader.close();
    }
}
public class fileName {
    static String s="C:\\Users\\xjh22\\Desktop\\java\\system";
    public static void main(String[] args) throws Exception {
        File f1=new File(s);
        File[] files=f1.listFiles();
        for(int i=0;i<files.length;i++){
            new copy(files[i].getPath(),"D:\\source\\s3.txt").read();
        }
    }
}
