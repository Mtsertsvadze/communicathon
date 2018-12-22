package communicathon.forset.kapiure.models;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM user")
    LiveData<List<User>> getUsers();

    @Query("SELECT * FROM user WHERE `index` IN (:userIds)")
    LiveData<List<User>> loadAllByIds(int[] userIds);


    @Query("SELECT * FROM user WHERE username LIKE :first LIMIT 1")
    LiveData<User> getUserByName(String first);


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(User... users);


}