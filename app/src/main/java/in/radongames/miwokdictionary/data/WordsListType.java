package in.radongames.miwokdictionary.data;

import in.radongames.miwokdictionary.R;

/**
 * Created by Binand on 02-10-2016.
 */

public enum WordsListType {

        WORDS_NUMBERS(R.id.numbers, "Numbers", 0, true, R.color.category_numbers),
        WORDS_FAMILY(R.id.family, "Family", 1, true, R.color.category_family),
        WORDS_COLOURS(R.id.colours, "Colours", 2, true, R.color.category_colors),
        WORDS_PHRASES(R.id.phrases, "Phrases", 3, false, R.color.category_phrases);

    private int vId;
    private String typeName;
    private int position;
    private boolean hasImage;
    private int bgColour;

    WordsListType(int vId, String typeName, int position, boolean hasImage, int bgColour) {
        this.vId = vId;
        this.typeName = typeName;
        this.position = position;
        this.hasImage = hasImage;
        this.bgColour = bgColour;
    }

    public int getViewId() {
        return vId;
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

    public static WordsListType getTypeFromViewId(int vId) {
        for (WordsListType w : WordsListType.values()) {
            if (w.getViewId() == vId) {
                return w;
            }
        }
        return null;
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
