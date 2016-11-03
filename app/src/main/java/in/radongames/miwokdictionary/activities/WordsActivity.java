package in.radongames.miwokdictionary.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import in.radongames.miwokdictionary.R;
import in.radongames.miwokdictionary.fragments.WordsFragment;

public class WordsActivity extends AppCompatActivity /*implements WordsFragment.OnFragmentInteractionListener*/ {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_words);

        // From: http://stackoverflow.com/questions/28002209/android-getactionbar-vs-getsupportactionbar
        // If you are using AppCompat you always have to call getSupportActionBar() no matter which Android Version your App is running.
        // using AppCompat ==> extends AppCompatActivity
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.words_fragment_container, new WordsFragment())
                .commit();
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

//    @Override
//    public void onFragmentInteraction(Uri uri) {
//        // do Nothing, for now.
//    }
}
