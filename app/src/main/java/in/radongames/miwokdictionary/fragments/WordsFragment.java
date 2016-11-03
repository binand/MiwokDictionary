package in.radongames.miwokdictionary.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import in.radongames.miwokdictionary.MiwokApplication;
import in.radongames.miwokdictionary.R;
import in.radongames.miwokdictionary.data.WordAdapter;
import in.radongames.miwokdictionary.data.WordsList;
import in.radongames.miwokdictionary.data.WordsListType;
import in.radongames.miwokdictionary.listeners.WordOnClickListener;
import in.radongames.miwokdictionary.utils.MiwokAppConstants;
import in.radongames.miwokdictionary.utils.SpokenMiwok;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link WordsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link WordsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WordsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public WordsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment WordsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static WordsFragment newInstance(String param1, String param2) {
        WordsFragment fragment = new WordsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Activity parentActivity = getActivity();
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.words_list, container, false);

        Intent intent = parentActivity.getIntent();
        int vId = intent.getIntExtra(MiwokAppConstants.getExtraCallingView(), R.id.numbers);

        WordsListType wt = WordsListType.getTypeFromViewId(vId);
        WordAdapter wordAdapter = new WordAdapter(parentActivity, WordsList.getWordsList(wt), wt.getBgColourId(), wt.hasImage());

        ListView lv = (ListView) v.findViewById(R.id.list);
        lv.setOnItemClickListener(new WordOnClickListener(parentActivity));
        lv.setAdapter(wordAdapter);

        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
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
