package colan.com.learnshapes.common;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by KEERTHINI on 7/18/2016.
 */

public class SharedPref {

    private static String MY_STRING_PREF = "LearnShapes";
    SharedPreferences shared;
    SharedPreferences.Editor editor;

    public SharedPref(Context context) {
        shared = context.getSharedPreferences(MY_STRING_PREF, Context.MODE_PRIVATE);

    }

    public void setString(String key,String currentShape) {
        editor = shared.edit();
        editor.putString(key, currentShape);
        editor.apply();
    }

    public String getString(String key) {
        return shared.getString(key, null);
    }

    public void setInt(String key,int shapeCount) {
        editor = shared.edit();
        editor.putInt(key, shapeCount);
        editor.apply();
    }

    public int getInt(String key) {
        return shared.getInt(key, 0);
    }

    public void clearAll()
    {
        editor = shared.edit();
        editor.clear().commit();
    }
}
