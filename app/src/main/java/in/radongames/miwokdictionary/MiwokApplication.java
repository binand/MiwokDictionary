package in.radongames.miwokdictionary;

import android.app.Application;

import in.radongames.miwokdictionary.utils.SpokenMiwok;

/**
 * Created by Binand on 16-10-2016.
 */

public class MiwokApplication extends Application {

    private SpokenMiwok sm;

    @Override
    public void onCreate() {
        super.onCreate();
        sm = SpokenMiwok.initMiwokSpeaker(this);
    }

    public SpokenMiwok getMiwokSpeaker() {
        return sm;
    }
}
