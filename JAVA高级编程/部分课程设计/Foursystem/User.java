package Foursystem;

public class User {
    private int UserNumber;
    private String UserName;
    private int Password;
    public User(){
        super();
    }
    public User(int UserNumber,String UserName,int Password){
        super();
        this.UserNumber=UserNumber;
        this.UserName=UserName;
        this.Password=Password;
    }
    public int getUserNumber(){
        return UserNumber;
    }
    public void setUserNumber(int userNumber){
        this.UserNumber=UserNumber;
    }
    public String getUserName(){
        return UserName;
    }
    public void setUserName(String UserName){
        this.UserName=UserName;
    }
    public int getPassword(){
        return Password;
    }
    public void setPassword(int Password){
        this.Password=Password;
    }


}