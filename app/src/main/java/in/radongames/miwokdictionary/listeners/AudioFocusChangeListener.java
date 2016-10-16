package in.radongames.miwokdictionary.listeners;

import android.content.Context;
import android.media.AudioManager;

import in.radongames.miwokdictionary.MiwokApplication;
import in.radongames.miwokdictionary.utils.SpokenMiwok;

/**
 * Created by Binand on 15-10-2016.
 */

public class AudioFocusChangeListener implements AudioManager.OnAudioFocusChangeListener {

    private Context ctx;

    public AudioFocusChangeListener(Context ctx) {

        this.ctx = ctx;
    }

    @Override
    public void onAudioFocusChange(int newFocus) {

        SpokenMiwok sm = ((MiwokApplication) ctx.getApplicationContext()).getMiwokSpeaker();

        switch (newFocus) {

            case AudioManager.AUDIOFOCUS_LOSS:                      // Permanent loss of Audio Focus
            case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK:   // Temporary duckable loss of Audio Focus
            case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT:            // Temporary loss of Audio Focus
                sm.stopSpeaking();
                break;

            case AudioManager.AUDIOFOCUS_GAIN:                      // Obtained focus
                sm.startSpeaking();
                break;
        }
    }
}
