package communicathon.forset.kapiure.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class User  {
    @PrimaryKey
    private int index;

    @ColumnInfo(name = "username")
    private String username;

    @ColumnInfo(name = "password")
    private String password;

    @ColumnInfo(name = "personal")
    private String personal;

    @ColumnInfo(name = "political")
    private String political;


    public User(String username, String password){
        this.username = username;
        this.password = password;
        this.personal = "";
        this.political = "";
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getIndex(){
        return this.index;
    }

    public void setPersonal(String personal) {
        this.personal = personal;
    }

    public String getPersonal() {
        return personal;
    }

    public void setPolitical(String political) {
        this.political = political;
    }

    public String getPolitical() {
        return political;
    }

    public String getUsername() {
        return username;
    }

}
