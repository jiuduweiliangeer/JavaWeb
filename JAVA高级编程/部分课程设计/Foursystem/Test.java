package Foursystem;

import java.sql.SQLException;
import java.util.Scanner;

public abstract class Test {
    public static int Count=0;
    public static String Login() throws SQLException {
        String X = "0";
        System.out.println("请输入用户名：");
        Scanner input = new Scanner(System.in);
        String username = input.next();
        System.out.println("请输入密码：");
        int password = input.nextInt();
        User user = Demo.getUser(username, password);
        if (user == null) {
            System.out.println("登陆失败");
            Count++;
            if (Count > 2) {
                System.exit(0);
            } else {
                return Login();
            }
        } else {
            System.out.println("登陆成功");
            return username;
        }
        return X;
    }
    public abstract Test operation() throws SQLException;
}