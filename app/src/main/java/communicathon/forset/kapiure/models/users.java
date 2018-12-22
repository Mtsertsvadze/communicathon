package communicathon.forset.kapiure.models;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import static android.support.constraint.Constraints.TAG;


public class users {
    private static int usersNum;
    private static int[][] grid = null;
    private static List<User>  userList = null;

    private UsersDatabase usersDatabase;

    public users(UsersDatabase usersDatabase){
        this.usersDatabase = usersDatabase;

        this.userList = usersDatabase.UserDao().getUsers().getValue();

        if(userList == null){
            this.usersNum = 0;
            userList = new ArrayList<>();
        }else{
            this.usersNum = userList.size();
        }

        this.grid = new int[usersNum][usersNum];
        for(int i = 0; i < usersNum; i++){
            for(int j = 0; j < usersNum; j++){
                this.grid[i][j] = 0;
            }
        }
    }


    public List<User> getUserList(){
        return this.getUserList();
    }

    public int getUsersNum(){
        return this.usersNum;
    }

    public boolean isRegistered(String username){
        return userList.contains(username);
    }

    //იუზერის დამატება
    public void addUser(String username, String password){
        Log.d("abgd", "akaa");
        usersNum++;
        User newUser = new User(username, password);
        usersDatabase.UserDao().insert(newUser);
        userList.add(newUser);
        addUserOnGrid();
    }

    //იუზერს ამატებს
    private void addUserOnGrid(){
        int[][] newGrid = new int[usersNum + 1][usersNum + 1];
        for(int i = 0; i< usersNum; i++){
            for(int j = 0; j < usersNum; j++){
                if(i < usersNum - 1 && j < usersNum - 1) {
                    newGrid[i][j] = newGrid[i][j];
                }else{
                    newGrid[i][j] = 0;
                }
            }
        }
    }

    //პირველი იუზერი ამბობს მეორეზე ამას ვნახავო
    public void sendRequest(User firstUser, User secondUser){
        if(grid[firstUser.getIndex()][secondUser.getIndex()] == 0){
            grid[firstUser.getIndex()][secondUser.getIndex()] = 1;
        }
    }

    //პირველი იუზერი ამბობს კონსესუს მივაღწიეო
    public void sendConsesus(User firstUser, User secondUser){
        if(grid[firstUser.getIndex()][secondUser.getIndex()] == 1){
            grid[firstUser.getIndex()][secondUser.getIndex()] = 2;
        }
    }

    //თუშეუძლიათ ერთმანეთის პროფილის ნახვა, ანუ ორივემ თუ თქვა კიო მანხოსო ამანო
    public boolean isConnected(User firstUser, User secondUser){
        return (grid[firstUser.getIndex()][secondUser.getIndex()] == 1) &&
                (grid[secondUser.getIndex()][firstUser.getIndex()] == 1);
    }

    //არის თუ არა ხაზი საჭირო, ანუ არის თუ არა კონსესუსი
    public boolean addLine(User firstUser, User secondUser){
        return (grid[firstUser.getIndex()][secondUser.getIndex()] == 2) &&
                (grid[secondUser.getIndex()][firstUser.getIndex()] == 2);
    }


    public void loginVallidation(String username, String password) throws Exception {
        checkValues(username, password);
        if(!isRegistered(username)) {
            throw new Exception("მომხმარებელი ასეთი სახელით არ არსებობს");
        }else{
            String rightPassword = usersDatabase.UserDao().getUserByName(username).getValue().getPassword();
            if(!rightPassword.equals(password)){
                throw new Exception("პაროლი არასწორია");
            }
        }
    }

    public void registrationValidation(String username, String password) throws Exception{
        checkValues(username, password);
        if(isRegistered(username)) {
            throw new Exception("მომხმარებელი ასეთი სახელით უკვე არსებობს");
        }
    }

    private void checkValues(String username, String password) throws Exception{
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
