package com.example.randytia.fragmentexa;

/**
 * Created by Randytia on 25/10/2017.
 */

public class Search {

    private int mDrawable;
    private String mName;

    public Search(String name, int drawable) {
        mName = name;
        mDrawable = drawable;
    }

    public int getDrawable() {
        return mDrawable;
    }

    public String getName() {
        return mName;
    }
}
