package com.projects.nikita.pocketgym.testdata;

import com.projects.nikita.pocketgym.R;

/**
 * Created by Nikita on 10/2/2015.
 */
public class StringTest {

    private final String[] STRINGS = {"Sunday","Monday","Tuesday","Wednesday"
            ,"Thursday","Friday","Saturday", "Timer"};
    private final Integer[] IMAGES = {R.drawable.sunday, R.drawable.monday, R.drawable.tuesday,
            R.drawable.wednesday, R.drawable.thursday, R.drawable.friday, R.drawable.saturday,R.drawable.bg_timer};
    private static int currentDay;

    public static void setCurrentDay(int day) {
        currentDay = day;
    }

    public static int getCurrentDay() {
        return currentDay;
    }

    public String[] getDays(){return STRINGS;}
    public Integer[] getImages(){return IMAGES;}
    public String getDay(int num){return STRINGS[num];}
    public Integer getImage(int num){return IMAGES[num];}
    public final String[] CATEGORIES = {"Качаем Бицепс", "Качаем Трицепс", "Качаем Грудь", "Качаем Спину",
                                    "Качаем Плечи", "Качаем Трапеции", "Качаем Пресс", "Качаем Ноги"};
}
