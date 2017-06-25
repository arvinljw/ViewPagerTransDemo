package net.arvin.viewpagertransdemo;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by arvin on 2016/8/30 16:16
 */
public class SimpleFragment extends Fragment {
    private View mRoot;
    private int color;

    public SimpleFragment() {
    }

    @SuppressLint("ValidFragment")
    public SimpleFragment(int color) {
        this.color = color;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRoot = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_simple, null);
        init(savedInstanceState);
        return mRoot;
    }

    private void init(Bundle savedInstanceState) {
        mRoot.findViewById(R.id.layout_page).setBackgroundColor(color);
    }

}
