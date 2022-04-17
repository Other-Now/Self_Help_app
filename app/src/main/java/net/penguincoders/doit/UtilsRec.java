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
    private static final String CORONA_HELP = "corona_help";
    private static final String HEALTH_TIPS = "health_tips";

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
        if (null == getAllCoronaHelp()) {
            initCoronaHelp();
        }
        if (null == getAllHealthTips()) {
            initHealthTips();
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

    public ArrayList<RecItem> getAllCoronaHelp() {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<RecItem>>() {}.getType(); //To create the arraylist<Book> type in which we want to recieve gson.
        ArrayList<RecItem> books = gson.fromJson(sharedPreferences.getString(CORONA_HELP,null), type);
        return books;
    }

    public ArrayList<RecItem> getAllHealthTips() {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<RecItem>>() {}.getType(); //To create the arraylist<Book> type in which we want to recieve gson.
        ArrayList<RecItem> books = gson.fromJson(sharedPreferences.getString(HEALTH_TIPS,null), type);
        return books;
    }

    private void initButtonData() {
        //TODO: add initial data

        ArrayList<RecItem> recItems = new ArrayList<>();
        recItems.add(new RecItem(1,"Med Reminder",R.drawable.remindersicon));
        recItems.add(new RecItem(2,"Know Your Med",R.drawable.knowyourmeds));
        recItems.add(new RecItem(3,"First Aid Tips",R.drawable.firstaid));
        recItems.add(new RecItem(4,"Health Tips",R.drawable.tips));
        recItems.add(new RecItem(5,"Corona Self-Help",R.drawable.corono));
        recItems.add(new RecItem(6,"Look for Hospitals in map",R.drawable.hospital));

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
        recItems.add(new RecItem(1,"First Aid Checklist",1));
        recItems.add(new RecItem(2,"5 Key Steps of First Aid",1));
        recItems.add(new RecItem(3,"10 Basic First Aid Tips & for Any Emergency",1));
        recItems.add(new RecItem(4,"First Aid for Cuts",1));

        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        editor.putString(FIRST_AID, gson.toJson(recItems));
        editor.commit(); //to persist the history, recieve it and modify it, we use sharedpreference.
    }
    private void initCoronaHelp() {
        ArrayList<RecItem> recItems = new ArrayList<>();
        recItems.add(new RecItem(5,"Learn About COVID-19",1));
        recItems.add(new RecItem(6,"Advices For Public",1));
        recItems.add(new RecItem(7,"Things to Do If Someone You Live With Has COVID-19",1));
        recItems.add(new RecItem(8,"COVID-19 related Data and Statistics",1));

        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        editor.putString(CORONA_HELP, gson.toJson(recItems));
        editor.commit(); //to persist the history, recieve it and modify it, we use sharedpreference.
    }
    private void initHealthTips() {
        ArrayList<RecItem> recItems = new ArrayList<>();
        recItems.add(new RecItem(7,"Common Seasonal Diseases",R.drawable.seasonal_disease));
        recItems.add(new RecItem(8,"Yoga Asanas",R.drawable.yoga_and_mental));
        recItems.add(new RecItem(9,"Health and Nutrition Tips",R.drawable.nutrition_tips));
        recItems.add(new RecItem(10,"Basic Exercises",R.drawable.children_exercising_in_fitness));

        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        editor.putString(HEALTH_TIPS, gson.toJson(recItems));
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
