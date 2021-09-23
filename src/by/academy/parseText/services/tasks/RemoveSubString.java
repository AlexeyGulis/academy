package by.academy.parseText.services.tasks;

import by.academy.parseText.entity.Sentence;
import by.academy.parseText.services.ParseWord;

import java.util.List;

public class RemoveSubString {
    public static void remove(List<Sentence> sentenceList, char start, char end) {
        for (Sentence s : sentenceList
             ) {
            String str = s.toString();
            String result;
            if(str.indexOf(start)>=0){
                if(str.lastIndexOf(end)>0){
                    if(str.lastIndexOf(end) - str.indexOf(start) > 0){
                        if(str.indexOf(start)==0){
                            if(str.lastIndexOf(end)!=str.length()-1){
                                result = str.substring(str.lastIndexOf(end)+1);
                            }else{
                                result = "";
                            }
                        }else{
                            if(str.lastIndexOf(end)!=str.length()-1){
                                result = str.substring(0,str.indexOf(start)) + str.substring(str.lastIndexOf(end)+1);
                            }else{
                                result = str.substring(0,str.indexOf(start));
                            }

                        }
                        Sentence temp = new Sentence();
                        ParseWord.parseWord(result,temp);
                        s.setWordList(temp.getWordList());
                    }
                }
            }
        }
    }
}
