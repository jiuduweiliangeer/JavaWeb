package Foursystem;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
public class Borrow extends Test{
    public Test operation() throws SQLException{
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
        String url = "jdbc:sqlserver://localhost:1433;DatabaseName=BookManage1;";
        Connection connection = DriverManager.getConnection(url, "sa", "lj000000");
        Scanner input = new Scanner(System.in);
        System.out.println("请输入你要借阅的书籍：");
        String name = input.next();
        System.out.println("请输入你需要的书籍数目：");
        int number = input.nextInt();
        System.out.println("请输入你的归还日期：");
        String returnDay=input.next();
        System.out.println("请输入你的读者号：");
        String readernumber=input.next();//输入一系列需要的数据
        Statement statement6 = connection.createStatement();
        String sql6 = "select Count FROM BOOK WHERE BookName='" + name + "'";
        ResultSet Count = statement6.executeQuery(sql6);//查找书的总量并将结果集返回Count
        Count.next();//指针指向第一行
        Statement statement = connection.createStatement();
        try {
            String sql = "update BOOK set Count=" + Count.getInt("Count") + "-" + number + " where BookName='" + name + "'";
            statement.executeUpdate(sql);
        }catch (SQLException e){
            System.out.println("存书不足");
            return operation();
        }//检测存书
        Statement statement2 = connection.createStatement();
        String sql2 = "select BookNumber FROM BOOK WHERE BookName='" + name + "'";
        ResultSet booknumber = statement2.executeQuery(sql2);//通过书名称查找书号并将结果集返回
        booknumber.next();
        Statement statement4 = connection.createStatement();
        Statement statement8=connection.createStatement();
        String sql8="SELECT BorrowCount FROM READER WHERE ReaderNumber="+readernumber+"";
        ResultSet reader=statement8.executeQuery(sql8);
     //检测读者号是否正确
        if(reader.next()==false){
            System.out.println("不存在该读者号");
            System.out.println("是否继续借书（1.Y/2.N）：");
            int s=input.nextInt();
            if(s==1){
                return operation();
            }else{
                System.exit(0);
            }
        }
        try{
            Statement statement7=connection.createStatement();
            String sql7="UPDATE READER SET BorrowCount="+number+"+"+reader.getInt("BorrowCount")+" WHERE ReaderNumber="+readernumber+"";
            statement7.executeUpdate(sql7);
            String sql4 = "INSERT INTO BORROW VALUES ("+readernumber+","+booknumber.getInt("BookNumber")+",'"+dateFormat.format(date)+"',"+number+",'"+returnDay+"')";
            statement4.executeUpdate(sql4);
        }catch (SQLException e){
            System.out.println("您的借书总量已经超过五本，不能继续借书！");
            System.exit(0);
        }//检测已经借书总量
        Statement statement9=connection.createStatement();
        String sql9="SELECT DATEDIFF(DAY,'2019-4-29','"+returnDay+"')AS dd";
        ResultSet day=statement9.executeQuery(sql9);
        day.next();
        int days=day.getInt("dd");
        if(days>30){
            double finace=(days-30)*0.5;
            Statement statement10=connection.createStatement();
            String sql10="UPDATE READER SET  Finace="+finace+" WHERE ReaderNumber="+readernumber+"";//总罚金相加，暂时还没有更改
            statement10.executeUpdate(sql10);
        }
        Statement statement5 = connection.createStatement();
        String sql5 = "select * FROM BORROW WHERE BookNumber="+booknumber.getInt("BookNumber")+" AND ReaderNumber="+readernumber+"";
        ResultSet rs = statement5.executeQuery(sql5);
        while (rs.next()) {
            int BookNumber = rs.getInt("BookNumber");
            int ReaderNumber = rs.getInt("ReaderNumber");
            String getDay = rs.getString("GetDay");
            int GetCount = rs.getInt("GetCount");
            String ReturnDay = rs.getString("ReturnDay");
            System.out.println("ReaderNumber:" + ReaderNumber + "\tBookNumber" + BookNumber + "\tGetDay" + getDay + "\tGetCount" + GetCount + "\tReturnDay" + ReturnDay);
        }

        return null;

    }
}