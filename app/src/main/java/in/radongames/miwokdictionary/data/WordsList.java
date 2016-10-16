package in.radongames.miwokdictionary.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import in.radongames.miwokdictionary.R;

/**
 * Created by Binand on 02-10-2016.
 */

public class WordsList {

    private static Boolean listsInitialized = false;
    private static Map<WordsListType, List<Word>> masterList;

    public static List<Word> getWordsList(WordsListType t) {

        synchronized (listsInitialized) {
            if (!listsInitialized) {
                initializeLists();
                listsInitialized = true;
            }
        }

        return masterList.get(t);
    }

    private static void initializeLists() {

        masterList = new HashMap<WordsListType, List<Word>>();

        List<Word> numberList = new ArrayList<Word>();
        numberList.add(new Word("lutti", "one", R.drawable.number_one, R.raw.number_one));
        numberList.add(new Word("otiiko", "two", R.drawable.number_two, R.raw.number_two));
        numberList.add(new Word("tolookosu", "three", R.drawable.number_three, R.raw.number_three));
        numberList.add(new Word("oyyisa", "four", R.drawable.number_four, R.raw.number_four));
        numberList.add(new Word("massokka", "five", R.drawable.number_five, R.raw.number_five));
        numberList.add(new Word("temmokka", "six", R.drawable.number_six, R.raw.number_six));
        numberList.add(new Word("kenekaku", "seven", R.drawable.number_seven, R.raw.number_seven));
        numberList.add(new Word("kawinta", "eight", R.drawable.number_eight, R.raw.number_eight));
        numberList.add(new Word("wo'e", "nine", R.drawable.number_nine, R.raw.number_nine));
        numberList.add(new Word("na'aacha", "ten", R.drawable.number_ten, R.raw.number_ten));
        masterList.put(WordsListType.WORDS_NUMBERS, numberList);

        List<Word> familyList = new ArrayList<Word>();
        familyList.add(new Word("әpә", "father", R.drawable.family_father, R.raw.family_father));
        familyList.add(new Word("әṭa", "mother", R.drawable.family_mother, R.raw.family_mother));
        familyList.add(new Word("angsi", "son", R.drawable.family_son, R.raw.family_son));
        familyList.add(new Word("tune", "daughter", R.drawable.family_daughter, R.raw.family_daughter));
        familyList.add(new Word("taachi", "older brother", R.drawable.family_older_brother, R.raw.family_older_brother));
        familyList.add(new Word("chalitti", "younger brother", R.drawable.family_younger_brother, R.raw.family_younger_brother));
        familyList.add(new Word("teṭe", "older sister", R.drawable.family_older_sister, R.raw.family_older_sister));
        familyList.add(new Word("kolliti", "younger sister", R.drawable.family_younger_sister, R.raw.family_younger_sister));
        familyList.add(new Word("ama", "grandmother", R.drawable.family_grandmother, R.raw.family_grandmother));
        familyList.add(new Word("paapa", "grandfather", R.drawable.family_grandfather, R.raw.family_grandfather));
        masterList.put(WordsListType.WORDS_FAMILY, familyList);

        List<Word> coloursList = new ArrayList<Word>();
        coloursList.add(new Word("weṭeṭṭi", "red", R.drawable.color_red, R.raw.color_red));
        coloursList.add(new Word("chokokki", "green", R.drawable.color_green, R.raw.color_green));
        coloursList.add(new Word("ṭakaakki", "brown", R.drawable.color_brown, R.raw.color_brown));
        coloursList.add(new Word("ṭopoppi", "grey", R.drawable.color_gray, R.raw.color_gray));
        coloursList.add(new Word("kululli", "black", R.drawable.color_black, R.raw.color_black));
        coloursList.add(new Word("kelelli", "white", R.drawable.color_white, R.raw.color_white));
        coloursList.add(new Word("ṭopiisә", "dusty yellow", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
        coloursList.add(new Word("chiwiiṭә", "mustard yellow", R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));
        masterList.put(WordsListType.WORDS_COLOURS, coloursList);

        List<Word> phrasesList = new ArrayList<Word>();
        phrasesList.add(new Word("minto wuksus", "Where are you going?", -1, R.raw.phrase_where_are_you_going));
        phrasesList.add(new Word("tinnә oyaase'nә", "What is your name?", -1, R.raw.phrase_what_is_your_name));
        phrasesList.add(new Word("oyaaset...", "My name is...", -1, R.raw.phrase_my_name_is));
        phrasesList.add(new Word("michәksәs?", "How are you feeling?", -1, R.raw.phrase_how_are_you_feeling));
        phrasesList.add(new Word("kuchi achit", "I’m feeling good.", -1, R.raw.phrase_im_feeling_good));
        phrasesList.add(new Word("әәnәs'aa?", "Are you coming?", -1, R.raw.phrase_are_you_coming));
        phrasesList.add(new Word("hәә’ әәnәm", "Yes, I’m coming.", -1, R.raw.phrase_yes_im_coming));
        phrasesList.add(new Word("әәnәm", "I’m coming.", -1, R.raw.phrase_im_coming));
        phrasesList.add(new Word("yoowutis", "Let’s go.", -1, R.raw.phrase_lets_go));
        phrasesList.add(new Word("әnni'nem", "Come here.", -1, R.raw.phrase_come_here));
        masterList.put(WordsListType.WORDS_PHRASES, phrasesList);
    }
}
