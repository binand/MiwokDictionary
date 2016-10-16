package in.radongames.miwokdictionary.data;

/**
 * Created by Binand on 02-10-2016.
 */

public class Word {

    private String miwokText;
    private String otherText;
    private int imageResource = -1;
    private int audioResource = -1;

    public Word(String miwokText, String otherText, int imageResource, int audioResource) {
        this.miwokText = miwokText;
        this.otherText = otherText;
        this.imageResource = imageResource;
        this.audioResource = audioResource;
    }

    public String getMiwokText() {
        return miwokText;
    }

    public String getOtherText() {
        return otherText;
    }

    public int getImageResource() {
        return imageResource;
    }

    public int getAudioResource() {
        return audioResource;
    }

    public String toString() {
        return "Miwok: " + miwokText + " Other: " + otherText;
    }
}
