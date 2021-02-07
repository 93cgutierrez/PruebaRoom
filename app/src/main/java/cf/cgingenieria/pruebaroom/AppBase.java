package cf.cgingenieria.pruebaroom;

import android.app.Application;
import android.content.Context;

import androidx.room.Room;

import cf.cgingenieria.pruebaroom.model.PersonDatabase;

/**
 * Created by CGIngenieria on 07/02/2021.
 */
public class AppBase extends Application {
    private static Application application;


    public static  Application getApplication(){
        return application;
    }

    public static Context getContext(){
        return getApplication().getApplicationContext();
    }

    public static PersonDatabase getPersonDatabase(){
        return Room.databaseBuilder(
                getContext(),
                PersonDatabase.class, "database-person")
                .build();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
    }

}
