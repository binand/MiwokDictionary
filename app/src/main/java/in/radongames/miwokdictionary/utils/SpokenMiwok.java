package in.radongames.miwokdictionary.utils;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.util.Log;

/**
 * Created by Binand on 15-10-2016.
 */

public enum SpokenMiwok {
    INSTANCE;

    private Context ctx;
    private int resId = -1;
    private AudioManager.OnAudioFocusChangeListener fcl;
    private MediaPlayer.OnCompletionListener mcl;

    private AudioManager am;
    private MediaPlayer mp;

    private static PlayerState mpStatus = PlayerState.SILENT;

    private static String TAG = "SpokenMiwok";

    private enum PlayerState {
        SPEAKING,
        SILENT
    }

    public static SpokenMiwok initMiwokSpeaker(Context ctx) {

        INSTANCE.ctx = ctx;
        Log.d(TAG, "initMiwokSpeaker : initialized [Passed Context = " + ctx.hashCode() + "][Instance Context = " + INSTANCE.ctx.hashCode() + "]");
        return INSTANCE;
    }

    public void startSpeaking(int resId, AudioManager.OnAudioFocusChangeListener fcl, MediaPlayer.OnCompletionListener mcl) {

        this.resId = resId;
        this.fcl = fcl;
        this.mcl = mcl;
        Log.d(TAG, "startSpeaking[1] with resId = " + resId);
        startSpeaking();
    }

    public void startSpeaking() {

        if (resId <= 0) {
            return;
        }
        if (mp != null && mp.isPlaying()) {
            stopSpeaking();
        }

        Log.d(TAG, "startSpeaking[2] with resId = " + resId);
        synchronized (mpStatus) {
            if (initAudio() == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                mp = MediaPlayer.create(ctx, resId);
                mp.seekTo(0);
                mp.start();
                mp.setOnCompletionListener(mcl);
                mpStatus = PlayerState.SPEAKING;
                Log.d(TAG, "startSpeaking[2] with resId = " + resId + " Status = SPEAKING");
            }
        }
    }

    public void stopSpeaking() {

        synchronized (mpStatus) {
            if (mp != null) {
                if (mp.isPlaying()) {
                    mp.stop();
                }
                mp.release();
                mp = null;
                mpStatus = PlayerState.SILENT;
                Log.d(TAG, "stopSpeaking with Status = SILENT");
            }
            endAudio();
        }
    }

    private int initAudio() {

        if (this.am == null) {
            this.am = (AudioManager) ctx.getSystemService(Context.AUDIO_SERVICE);
        }
        Log.d(TAG, "initAudio : AudioManager about to request");
        return am.requestAudioFocus(fcl, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
    }

    private int endAudio() {

        if (this.am == null) {
            am = (AudioManager) ctx.getSystemService(Context.AUDIO_SERVICE);
        }
        Log.d(TAG, "endAudio : AudioManager about to abandon");
        return am.abandonAudioFocus(fcl);
    }
}