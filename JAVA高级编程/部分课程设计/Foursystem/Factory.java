package Foursystem;

import java.sql.SQLException;
import java.util.Scanner;

public class Factory {
    public void  operationdemo(int type)throws SQLException {
        Test factory=null;
        Scanner input=new Scanner(System.in);
        switch(type){
            case 1:
                System.out.println("1.增加图书\n2.修改图书\n3.删除图书");
                System.out.println("请输入您要执行的操作：");
                int s=input.nextInt();
                switch (s){
                    case 1:
                        Test test=new AddBook();
                        test.operation();
                        ((AddBook) test).operation1();
                        break;
                    case 2:
                        Test test1=new AlterBook();
                        test1.operation();
                        ((AlterBook) test1).operation1();
                        break;
                    case 3:
                        Test test2=new DeleteBook();
                        test2.operation();
                        ((DeleteBook) test2).operation1();
                        break;
                }
                break;
            case 2:
                System.out.println("1.增加读者\n2.修改读者\n3.删除读者");
                System.out.println("请输入您要执行的操作：");
                int select=input.nextInt();
                switch (select){
                    case 1:
                        Test test=new AddReader();
                        test.operation();
                        ((AddReader) test).operation2();
                        break;
                    case 2:
                        Test test1=new AlterReader();
                        test1.operation();
                        ((AlterReader) test1).operation2();
                        break;
                    case 3:
                        Test test2=new DeleteReader();
                        test2.operation();
                        ((DeleteReader) test2).operation2();
                        break;
                }
                break;
            case 3:
                Test test=new Borrow();
                test.operation();
                break;
            case 4:
                Test test1=new ReturnBook();
                test1.operation();
                break;
        }
    }
}