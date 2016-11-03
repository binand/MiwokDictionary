package in.radongames.miwokdictionary.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ListView;

import in.radongames.miwokdictionary.MiwokApplication;
import in.radongames.miwokdictionary.R;
import in.radongames.miwokdictionary.data.WordAdapter;
import in.radongames.miwokdictionary.data.WordsList;
import in.radongames.miwokdictionary.data.WordsListType;
import in.radongames.miwokdictionary.listeners.WordOnClickListener;
import in.radongames.miwokdictionary.utils.MiwokAppConstants;
import in.radongames.miwokdictionary.utils.SpokenMiwok;

public class WordsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);

        // From: http://stackoverflow.com/questions/28002209/android-getactionbar-vs-getsupportactionbar
        // If you are using AppCompat you always have to call getSupportActionBar() no matter which Android Version your App is running.
        // using AppCompat ==> extends AppCompatActivity
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        int vId = intent.getIntExtra(MiwokAppConstants.getExtraCallingView(), R.id.numbers);

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

    // Code from: https://developer.android.com/training/implementing-navigation/ancestral.html
    // Section: "Navigate up with a new back stack"
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            // Respond to the action bar's Up/Home button
            case android.R.id.home:

                Intent upIntent = NavUtils.getParentActivityIntent(this);
                if (NavUtils.shouldUpRecreateTask(this, upIntent)) {

                    // This activity is NOT part of this app's task, so create a new task
                    // when navigating up, with a synthesized back stack.
                    TaskStackBuilder.create(this)
                            // Add all of this activity's parents to the back stack
                            .addNextIntentWithParentStack(upIntent)
                            // Navigate up to the closest parent
                            .startActivities();
                } else {
                    // This activity is part of this app's task, so simply
                    // navigate up to the logical parent activity.
                    NavUtils.navigateUpTo(this, upIntent);
                }
                //NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
