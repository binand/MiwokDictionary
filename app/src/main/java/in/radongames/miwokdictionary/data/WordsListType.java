package in.radongames.miwokdictionary.data;

import in.radongames.miwokdictionary.R;

/**
 * Created by Binand on 02-10-2016.
 */

public enum WordsListType {

        WORDS_NUMBERS("Numbers", 0, true, R.color.category_numbers),
        WORDS_FAMILY("Family", 1, true, R.color.category_family),
        WORDS_COLOURS("Colours", 2, true, R.color.category_colors),
        WORDS_PHRASES("Phrases", 3, false, R.color.category_phrases);

    private String typeName;
    private int position;
    private boolean hasImage;
    private int bgColour;

    WordsListType(String typeName, int position, boolean hasImage, int bgColour) {
        this.typeName = typeName;
        this.position = position;
        this.hasImage = hasImage;
        this.bgColour = bgColour;
    }

    public boolean hasImage() {
        return hasImage;
    }

    public int getBgColourId() {
        return bgColour;
    }

    public String getName() {
        return typeName;
    }

    public int getPosition() {
        return position;
    }

    public static WordsListType getTypeFromPosition(int pos) {
        for (WordsListType w : WordsListType.values()) {
            if (w.getPosition() == pos) {
                return w;
            }
        }
        return null;
    }

    public static int getNumListTypes() {
        return WordsListType.values().length;
    }
}
