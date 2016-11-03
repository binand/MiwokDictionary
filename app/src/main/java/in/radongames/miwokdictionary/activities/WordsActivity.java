package in.radongames.miwokdictionary.activities;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import in.radongames.miwokdictionary.R;
import in.radongames.miwokdictionary.fragments.WordsPagerAdapter;

public class WordsActivity extends AppCompatActivity /*implements WordsFragment.OnFragmentInteractionListener*/ {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_words);

        ViewPager vp = (ViewPager) findViewById(R.id.words_fragment_container);
        PagerAdapter wpa = new WordsPagerAdapter(getSupportFragmentManager());
        vp.setAdapter(wpa);
    }
}
