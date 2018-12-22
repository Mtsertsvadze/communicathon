package communicathon.forset.kapiure.models;

public class User implements ModelContract.UserInterface {
    private String username;
    private String password;

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }


    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPpassword() {
        return password;
    }

    @Override
    public void vallidation() throws Exception {
        if(username.length() != 0){
            if(password.length() == 0){
                throw new Exception("გთხოვთ შეიყვანოთ პაროლი");
            }else if(username.length() < 3){
                if(password == null){
                    throw new Exception("მომხმარებლის სახელი არ უდნა იყოს 3 სიმბოლზე ნაკლები, ხოლო პაროლი ცარიელი");
                }else if(password.length() < 3){
                    throw new Exception("მომხმარებლის სახელი და პაროლი არ უნდა იყოს 3 სიმბოლოზე ნაკლები");
                }else{
                    throw new Exception("მომხმარებლის სახელი არ უნდა იყოს სამ სიმბოლოზე ნაკლები");
                }
            }else if (password.length() < 3){
                throw new Exception("პაროლი არ უნდა იყოს 3 სიმბოლოზე ნაკლები");
            }
        }else{
            throw new Exception("გთხოვთ მიუთითოთ მომხმარებლის სახელი");
        }
    }
}
