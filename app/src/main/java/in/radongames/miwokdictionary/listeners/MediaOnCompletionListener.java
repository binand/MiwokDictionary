package in.radongames.miwokdictionary.listeners;

import android.content.Context;
import android.media.MediaPlayer;

import in.radongames.miwokdictionary.MiwokApplication;
import in.radongames.miwokdictionary.utils.SpokenMiwok;

/**
 * Created by Binand on 15-10-2016.
 */

public class MediaOnCompletionListener implements MediaPlayer.OnCompletionListener {

    private Context ctx;

    public MediaOnCompletionListener(Context ctx) {
        this.ctx = ctx;
    }

    @Override
    public void onCompletion(MediaPlayer mp) {

        SpokenMiwok sm = ((MiwokApplication) ctx.getApplicationContext()).getMiwokSpeaker();
        sm.stopSpeaking();
    }
}
