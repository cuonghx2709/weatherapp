package com.example.cuonghx.hw_weatherapp.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by cuonghx on 10/19/2017.
 */

public class Utils {
    public static void openFragment(FragmentManager fragmentManager, int layouId, Fragment fragment){

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(layouId, fragment);
        fragmentTransaction.commit();

    }

    public static String getDateFormDayOfWeek(int n){
        switch (n){
            case 0:
                return "SunDay";

            case 1:
                return "MonDay";

            case 2:
                return "TuesDay";

            case 3:
                return "Wednesday";

            case 4:
                return "Thursday";
            case 5:
                return "FriDay";

            case 6:
                return "Saturday";
            default:
                return null;

        }
    }
}
