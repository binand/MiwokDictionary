package in.radongames.miwokdictionary.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;

import in.radongames.miwokdictionary.R;
import in.radongames.miwokdictionary.listeners.MainOnClickListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View.OnClickListener cl = new MainOnClickListener(this, WordsActivity.class);
        ViewGroup vg = (ViewGroup) findViewById(R.id.activity_main);
        for (int i = vg.getChildCount() - 1; i >= 0; i--) {
            View v = vg.getChildAt(i);
            v.setOnClickListener(cl);
        }
    }
}
