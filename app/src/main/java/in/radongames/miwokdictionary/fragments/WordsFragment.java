package in.radongames.miwokdictionary.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import in.radongames.miwokdictionary.MiwokApplication;
import in.radongames.miwokdictionary.R;
import in.radongames.miwokdictionary.adapters.WordAdapter;
import in.radongames.miwokdictionary.data.WordsList;
import in.radongames.miwokdictionary.data.WordsListType;
import in.radongames.miwokdictionary.listeners.WordOnClickListener;
import in.radongames.miwokdictionary.utils.MiwokAppConstants;
import in.radongames.miwokdictionary.utils.SpokenMiwok;

public class WordsFragment extends Fragment {

    public WordsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Activity parentActivity = getActivity();
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_words, container, false);

        Bundle b = getArguments();
        int position = b.getInt(MiwokAppConstants.getExtraCallingPosition());
        WordsListType wt = WordsListType.getTypeFromPosition(position);

        WordAdapter wordAdapter = new WordAdapter(parentActivity, WordsList.getWordsList(wt), wt.getBgColourId(), wt.hasImage());

        ListView lv = (ListView) v.findViewById(R.id.words_list);
        lv.setOnItemClickListener(new WordOnClickListener(parentActivity));
        lv.setAdapter(wordAdapter);

        return v;
    }

    @Override
    public void onStop() {
        super.onStop();

        MiwokApplication app = (MiwokApplication) getActivity().getApplicationContext();
        SpokenMiwok sm = app.getMiwokSpeaker();

        if (sm != null) {
            sm.stopSpeaking();
        }
    }
}
