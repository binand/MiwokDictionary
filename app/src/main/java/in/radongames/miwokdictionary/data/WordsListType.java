package in.radongames.miwokdictionary.data;

import in.radongames.miwokdictionary.R;

/**
 * Created by Binand on 02-10-2016.
 */

public enum WordsListType {
        WORDS_NUMBERS(R.id.numbers, true, R.color.category_numbers),
        WORDS_FAMILY(R.id.family, true, R.color.category_family),
        WORDS_COLOURS(R.id.colours, true, R.color.category_colors),
        WORDS_PHRASES(R.id.phrases, false, R.color.category_phrases);

    private int vId;
    private boolean hasImage;
    private int bgColour;

    WordsListType(int vId, boolean hasImage, int bgColour) {
        this.vId = vId;
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

    public static WordsListType getTypeFromViewId(int vId) {
        for (WordsListType w : WordsListType.values()) {
            if (w.getViewId() == vId) {
                return w;
            }
        }
        return null;
    }
}
