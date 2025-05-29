package points3chess.chess3_points;

import java.util.Scanner;

/**
 * @author shkstart
 * @create 2022-11-04 19:01
 */
public class chess {
    static int counter=0;
    public static void main(String[] args) {
       char[][]cBoard=new char[3][3];
       for(int i=0;i<3;i++){
           for(int j=0;j<3;j++){
               cBoard[i][j]=' ';
           }
       }
       int flag2=0;
       boolean flag=true;
       run:while(flag){

           Scanner sc=new Scanner(System.in);
           chess c1=new chess();
           c1.showScenery(cBoard);
           System.out.println("where you wanna place your piece");
           int row=sc.nextInt();
           int column= sc.nextInt();
           if(cBoard[row-1][column-1]!=' '){
               System.out.println("you can't depoly here");
               continue ;
           }
           else{
               counter++;
               cBoard[row-1][column-1]='*';
           }
           System.out.println("the Artificial Intelligence goes as");
           c1.AIprocess(cBoard);
           String str=c1.judges(cBoard);
           System.out.println(c1.judges(cBoard));
           if(str=="the player wins"||str=="the AI wins"){
               c1.reNew(cBoard);
           }
           System.out.println("the next round");
       }
    }
    private void showScenery(char [][]a){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print("|"+a[i][j]+"|");
            }
            System.out.println();
        }
    }
    private String judges(char [][]a){
        if(a[0][0]==a[0][1]&&(a[0][1]==a[0][2]&&a[0][1]=='*')){
            return "the player wins";
        }
        else if(a[1][0]==a[1][1]&&(a[1][1]==a[1][2]&&a[1][1]=='*')){
            return "the player wins";
        }
        else if(a[2][0]==a[2][1]&&(a[2][1]==a[2][2]&&a[2][1]=='*')){
            return "the player wins";
        }
        else if(a[0][0]==a[1][1]&&(a[1][1]==a[2][2]&&a[2][2]=='*')){
            return "the player wins";
        }
        else if(a[0][2]==a[1][1]&&(a[1][1]==a[2][0]&&a[2][0]=='*')){
            return "the player wins";
        }
        else if(a[0][0]==a[1][0]&&(a[1][0]==a[2][0])&&a[0][0]=='*'){
            return "the player wins";
        }
        else if(a[0][1]==a[1][1]&&(a[1][1]==a[2][1])&&a[0][1]=='*'){
            return "the player wins";
        }
        else if(a[0][2]==a[1][2]&&(a[1][2]==a[2][2])&&a[0][2]=='*'){
            return "the player wins";
        }
        else if(a[0][0]==a[1][0]&&(a[1][0]==a[2][0])&&a[0][0]=='$'){
            return "the AI wins";
        }
        else if(a[0][1]==a[1][1]&&(a[1][1]==a[2][1])&&a[0][1]=='$'){
            return "the AI wins";
        }
        else if(a[0][2]==a[1][2]&&(a[1][2]==a[2][2])&&a[0][2]=='$'){
            return "the AI wins";
        }
        else if(a[0][0]==a[0][1]&&(a[0][1]==a[0][2]&&a[0][1]=='$')){
            return "the AI wins";
        }
        else if(a[1][0]==a[1][1]&&(a[1][1]==a[1][2]&&a[1][1]=='$')){
            return "the AI wins";
        }
        else if(a[2][0]==a[2][1]&&(a[2][1]==a[2][2]&&a[2][1]=='$')){
            return "the AI wins";
        }
        else if(a[0][0]==a[1][1]&&(a[1][1]==a[2][2]&&a[2][2]=='$')){
            return "the AI wins";
        }
        else if(a[0][2]==a[1][1]&&(a[1][1]==a[2][0]&&a[2][0]=='$')){
            return "the AI wins";
        }
        else{
            return " ";
        }
        }
    private void AIprocess(char[][]a){
        boolean flag=true;
        int flag1=2;
        while(flag){
            int row=(int)(3* Math.random());
            int column=(int)(3* Math.random());
            if(isFull(a)){
                judges(a);
                showScenery(a);
                flag=false;
            }
            else{
            if(a[row][column]==' '){
                a[row][column]='$';
                counter++;
                showScenery(a);
                flag=false;
            }
            }
        }
    }
    private void reNew(char[][]a){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                a[i][j]=' ';
            }
        }
    }
    private boolean isFull(char[][]a){
        int flag=0;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(a[i][j]==' '){
                    flag=1;
                }
            }
        }
        if(flag==1){
            return false;
        }
        else{
            return true;
        }
    }
}
