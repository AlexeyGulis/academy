package by.academy.parseText.services.tasks;

import by.academy.parseText.entity.Word;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortConsonantsLetter {
    private static char[] vowels = {'а', 'я', 'ы', 'ё', 'у', 'е', 'и', 'о', 'ю', 'э',
            'А', 'Я', 'Ы', 'Ё', 'У', 'Е', 'И', 'О', 'Ю', 'Э',
            'a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U', 'y', 'Y',};

    public static void sort(List<Word> wordList) {
        List<Word> words1stVowelsLetter = new ArrayList<>();
        for (Word t : wordList
        ) {
            if (t.getWord().length() != t.getWord().replaceAll("^[a||e||y||u||i||o||A||E||Y||U||I||O||я||у||а||е||и||о||э||ю||ё||ы||Ы||Ю||Е||Ё||Э||Я||У||А||Е||И||О]", "").length()) {
                words1stVowelsLetter.add(t);
            }
        }
        Collections.sort(words1stVowelsLetter, new Comparator<Word>() {
            @Override
            public int compare(Word o1, Word o2) {
                String str1 = o1.getWord().replaceAll("[aeyuioAEYUIOяуаеиоэюёыЫЮЕЁЭЯУАЕИО]", "");
                String str2 = o2.getWord().replaceAll("[aeyuioAEYUIOяуаеиоэюёыЫЮЕЁЭЯУАЕИО]", "");
                int res = str1.compareTo(str2);
                return res;
            }
        });
        printSortedWords(words1stVowelsLetter);
    }

    private static void printSortedWords(List<Word> wordList) {
        for (Word t : wordList
        ) {
            System.out.println(t);
        }
    }
}
