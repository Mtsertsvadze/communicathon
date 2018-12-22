package communicathon.forset.kapiure.models;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {User.class}, version = 1)
public abstract class UsersDatabase extends RoomDatabase {


    public abstract UserDao UserDao();

    private static volatile UsersDatabase INSTANCE;

    public static UsersDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (UsersDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            UsersDatabase.class, "user_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}