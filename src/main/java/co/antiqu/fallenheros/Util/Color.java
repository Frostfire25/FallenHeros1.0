package co.antiqu.fallenheros.Util;

import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.List;

public class Color {

    public static String t(String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }

    public static boolean listAreEqual(List<String> list1, ArrayList<String> list2) {
        if(list1.size() != list2.size());
        int counter = 0;
        for(int i = 0; i < list1.size(); i++) {
            if(list1.get(i).equals(list2.get(i)))
                counter++;
        }
        return (counter == list1.size());
    }
}
