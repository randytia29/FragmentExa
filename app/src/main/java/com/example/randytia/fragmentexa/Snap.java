package com.example.randytia.fragmentexa;

import java.util.List;

/**
 * Created by Randytia on 25/10/2017.
 */

public class Snap {

    private int mGravity;
    private String mText;
    private List<Search> mApps;

    public Snap(int gravity, String text, List<Search> apps) {
        mGravity = gravity;
        mText = text;
        mApps = apps;
    }

    public String getText() {
        return mText;
    }

    public int getGravity() {
        return mGravity;
    }

    public List<Search> getApps() {
        return mApps;
    }
}
