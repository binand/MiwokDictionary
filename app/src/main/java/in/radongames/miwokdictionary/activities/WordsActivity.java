package in.radongames.miwokdictionary.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ListView;

import in.radongames.miwokdictionary.MiwokApplication;
import in.radongames.miwokdictionary.R;
import in.radongames.miwokdictionary.data.WordAdapter;
import in.radongames.miwokdictionary.data.WordsList;
import in.radongames.miwokdictionary.data.WordsListType;
import in.radongames.miwokdictionary.listeners.WordOnClickListener;
import in.radongames.miwokdictionary.utils.SpokenMiwok;

public class WordsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        int vId = intent.getIntExtra("EXTRA_CALLING_VIEW", R.id.numbers);

        WordsListType wt = WordsListType.getTypeFromViewId(vId);
        WordAdapter wordAdapter = new WordAdapter(this, WordsList.getWordsList(wt), wt.getBgColourId(), wt.hasImage());

        ListView lv = (ListView) findViewById(R.id.list);
        lv.setOnItemClickListener(new WordOnClickListener(this));
        lv.setAdapter(wordAdapter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        MiwokApplication app = (MiwokApplication) this.getApplicationContext();
        SpokenMiwok sm = app.getMiwokSpeaker();

        if (sm != null) {
            sm.stopSpeaking();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
