package net.penguincoders.doit;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class UtilsRec {
    private static final String BUTTON_PAGE = "button_page";
    private static final String FIRST_AID = "first_aid";

    private static UtilsRec instance;
    private SharedPreferences sharedPreferences;

    private UtilsRec(Context context) {

        sharedPreferences = context.getSharedPreferences("alternate DB", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();

        if (null == getAllButtons()) {
            initButtonData();
        }
        if (null == getAllFirstAid()) {
            initFirstAidData();
        }
    }

    public ArrayList<RecItem> getAllButtons() {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<RecItem>>() {}.getType(); //To create the arraylist<Book> type in which we want to recieve gson.
        ArrayList<RecItem> books = gson.fromJson(sharedPreferences.getString(BUTTON_PAGE,null), type);
        return books;
    }

    public ArrayList<RecItem> getAllFirstAid() {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<RecItem>>() {}.getType(); //To create the arraylist<Book> type in which we want to recieve gson.
        ArrayList<RecItem> books = gson.fromJson(sharedPreferences.getString(FIRST_AID,null), type);
        return books;
    }

    private void initButtonData() {
        //TODO: add initial data

        ArrayList<RecItem> recItems = new ArrayList<>();
        recItems.add(new RecItem(1,"Med Reminder",R.drawable.pill_reminder));
        recItems.add(new RecItem(2,"Know Your Med",R.drawable.know_your_med));
        recItems.add(new RecItem(3,"First Aid Tips",R.drawable.first_aid_tips));
        recItems.add(new RecItem(4,"Health Tips",R.drawable.health_tips));
        recItems.add(new RecItem(5,"Corona Self-Help",R.drawable.coronap));
        recItems.add(new RecItem(6,"Nearby Hospitals",R.drawable.hospital_clipart));

        /*ArrayList<Books> book = new ArrayList<>();
        book.add(new Books(1,"1Q84", "Haruki MuraKami","https://i.pinimg.com/originals/e5/b4/b9/e5b4b9fbf5c1d77960097eaa3bff9706.jpg",1350,
                "A work of maddening brilliance","This is a long description"));
        book.add(new Books(2,"Fight Club", "Chuck Palahniuk","https://i.pinimg.com/originals/69/72/b6/6972b66737e687cf60ff02737272bc4b.jpg",1350,
                "A work of maddening brilliance inspiration of FIGHT CLUB movie","This is a long description"));
        book.add(new Books(3,"1984", "George Orwell","https://mir-s3-cdn-cf.behance.net/project_modules/max_1200/a1d99b64356877.5acf68ed796de.jpg",1350,
                "A work of maddening brilliance","This is a long description"));
        book.add(new Books(4,"The Great Gatesby", "F. Scott Fitzgerald","https://cdn.lifehack.org/wp-content/uploads/2015/03/Penguin-2.jpg",1350,
                "A work of maddening brilliance and a famous book","This is a long description"));
        book.add(new Books(5,"The Diary of a Young Girl", "Anne Frank","https://cdn.lifehack.org/wp-content/uploads/2015/03/diary-of-anne-frank-postcard-front_0.jpg",1350,
                "A work of maddening brilliance and a famous book","This is a long description"));
        book.add(new Books(6,"The Hobbit", "J.R.R. Tolkien","https://cdn.lifehack.org/wp-content/uploads/2015/03/Hobbit_book.jpg",1350,
                "A work of maddening brilliance and a famous book","This is a long description"));*/

        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        editor.putString(BUTTON_PAGE, gson.toJson(recItems));
        editor.commit(); //to persist the history, recieve it and modify it, we use sharedpreference.
    }
    private void initFirstAidData() {
        ArrayList<RecItem> recItems = new ArrayList<>();
        recItems.add(new RecItem(1,"Check List",1));
        recItems.add(new RecItem(2,"Check List",1));
        recItems.add(new RecItem(3,"Check List",1));
        recItems.add(new RecItem(4,"Check List",1));

        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        editor.putString(FIRST_AID, gson.toJson(recItems));
        editor.commit(); //to persist the history, recieve it and modify it, we use sharedpreference.
    }

    public static UtilsRec getInstance(Context context) {
        if (null != instance) {
            return instance;
        }else {
            instance = new UtilsRec(context);
            return instance;
        }
    }
}
