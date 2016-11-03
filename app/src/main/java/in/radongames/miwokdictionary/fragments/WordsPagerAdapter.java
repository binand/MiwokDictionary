package in.radongames.miwokdictionary.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import in.radongames.miwokdictionary.data.WordsListType;
import in.radongames.miwokdictionary.utils.MiwokAppConstants;

/**
 * Created by Binand on 03-11-2016.
 */

public class WordsPagerAdapter extends FragmentPagerAdapter {

    public WordsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        WordsFragment wf = new WordsFragment();
        Bundle b = new Bundle();
        b.putInt(MiwokAppConstants.getExtraCallingPosition(), position);
        wf.setArguments(b);
        return wf;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return WordsListType.getTypeFromPosition(position).getName();
    }
}
