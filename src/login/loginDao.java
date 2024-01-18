package login;

public interface loginDao 
{
    boolean signUp(String username,String password ,String phone);
    boolean login(String username,String password);
    
}
