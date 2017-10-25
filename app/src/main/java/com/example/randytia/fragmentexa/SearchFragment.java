package com.example.randytia.fragmentexa;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class SearchFragment extends Fragment {

    public static final String ORIENTATION = "orientation";

    private RecyclerView mRecyclerView;
    private boolean mHorizontal;

    public static SearchFragment newInstance() {
        return new SearchFragment();
    }

    public SearchFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_search, container, false);

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setHasFixedSize(true);

        if (savedInstanceState == null) {
            mHorizontal = true;
        } else {
            mHorizontal = savedInstanceState.getBoolean(ORIENTATION);
        }
        setupAdapter();

        return rootView;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(ORIENTATION, mHorizontal);
    }

    private void setupAdapter() {
        List<Search> document = getDocument();
        List<Search> chat = getChat();
        List<Search> favorite = getFavorite();

        SnapAdapter snapAdapter = new SnapAdapter();
        snapAdapter.addSnap(new Snap(Gravity.START, "Favorite", favorite));
        snapAdapter.addSnap(new Snap(Gravity.START, "Chat", chat));
        snapAdapter.addSnap(new Snap(Gravity.START, "Document", document));

        mRecyclerView.setAdapter(snapAdapter);
    }

    private List<Search> getDocument() {
        List<Search> apps = new ArrayList<>();
        apps.add(new Search("Sheets", R.drawable.ic_sheets_48dp));
        apps.add(new Search("Slides", R.drawable.ic_slides_48dp));
        apps.add(new Search("Docs", R.drawable.ic_docs_48dp));
        apps.add(new Search("Inbox", R.drawable.ic_inbox_48dp));

        return apps;
    }

    private List<Search> getChat() {
        List<Search> apps = new ArrayList<>();
        apps.add(new Search("Hangouts", R.drawable.ic_hangouts_48dp));
        apps.add(new Search("Messenger", R.drawable.ic_messenger_48dp));
        return apps;
    }

    private List<Search> getFavorite() {
        List<Search> apps = new ArrayList<>();
        apps.add(new Search("Google+", R.drawable.ic_google_48dp));
        apps.add(new Search("Gmail", R.drawable.ic_gmail_48dp));
        apps.add(new Search("Inbox", R.drawable.ic_inbox_48dp));
        apps.add(new Search("Google Keep", R.drawable.ic_keep_48dp));
        apps.add(new Search("Google Drive", R.drawable.ic_drive_48dp));
        apps.add(new Search("Google Photos", R.drawable.ic_photos_48dp));
        return apps;
    }
}
