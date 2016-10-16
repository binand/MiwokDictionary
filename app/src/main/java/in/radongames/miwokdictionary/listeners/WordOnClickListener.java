package in.radongames.miwokdictionary.listeners;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.view.View;
import android.widget.AdapterView;

import in.radongames.miwokdictionary.MiwokApplication;
import in.radongames.miwokdictionary.data.Word;
import in.radongames.miwokdictionary.utils.SpokenMiwok;

/**
 * Created by Binand on 15-10-2016.
 */

public class WordOnClickListener implements AdapterView.OnItemClickListener {

    private Context ctx;

    private static MediaPlayer.OnCompletionListener mcl;
    private static AudioManager.OnAudioFocusChangeListener fcl;

    public WordOnClickListener(Context ctx) {
        this.ctx = ctx;
        if (fcl == null) {
            fcl = new AudioFocusChangeListener(ctx);
        }
        if (mcl == null) {
            mcl = new MediaOnCompletionListener(ctx);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

        Word w = (Word) parent.getItemAtPosition(position);
        SpokenMiwok sm = ((MiwokApplication) ctx.getApplicationContext()).getMiwokSpeaker();
        sm.startSpeaking(w.getAudioResource(), fcl, mcl);
    }
}
