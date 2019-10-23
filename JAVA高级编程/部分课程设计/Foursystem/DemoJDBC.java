package Foursystem;

import java.sql.SQLException;
import java.util.Scanner;

public class DemoJDBC {
    public static void main(String []args) throws SQLException {
        System.out.println("--------------------------------");
        System.out.println("欢迎来到图书管理系统！");
        ManageJudge manageJudge=new ManageJudge();
        String Judge=manageJudge.ManageJudge();
        Judge=Judge.trim();
        String s="管理员";
        while(true){
            System.out.println("1.图书维护\n2.读者维护\n3.借书\n4.还书");
            System.out.println("--------------------------------");
            Scanner input=new Scanner(System.in);
            System.out.println("请输入您要执行的操作：");
            int type=input.nextInt();
            Factory factory=new Factory();
            if(type==1||type==2){
                if(Judge.equals(s)){
                    factory.operationdemo(type);
                }else{
                    System.out.println("您不是管理员，没有此项权限");
                }
            }else{
                factory.operationdemo(type);
            }
            System.out.println("是否继续进行相关操作(1.Y/2.N)：");
            int m=input.nextInt();
            if(m==1){
                System.out.println("请继续操作");
            }else{
                System.exit(0);
            }
        }
    }
}