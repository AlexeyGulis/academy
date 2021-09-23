package by.academy.parseText.services.tasks;

import by.academy.parseText.entity.Text;

public class SearchMaxLengthPalindrome {
    public static void search(Text text){
        String str = text.toString();
        int max = 0;
        String result = "";
        for (int i = 0; i < str.length()-1; i++) {
            for (int j = i+1; j <= str.length(); j++) {
                if(str.substring(i,j).equals(new StringBuilder(str.substring(i,j)).reverse().toString())){
                    if(max < str.substring(i,j).length()){
                        max = str.substring(i,j).length();
                        result = str.substring(i,j);
                    }
                }
            }
        }
        System.out.println(result);
    }
}
