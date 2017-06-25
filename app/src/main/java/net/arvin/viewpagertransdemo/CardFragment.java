package net.arvin.viewpagertransdemo;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

/**
 * Created by arvinljw on 17/5/27 13:08
 * Function：
 * Desc：
 */
public class CardFragment extends Fragment {
    private View mRoot;
    private TextView tvIndex;

    private int pos;

    private List<String> colors = Arrays.asList("#3F51B5", "#FF4081");

    public CardFragment() {
    }

    @SuppressLint("ValidFragment")
    public CardFragment(int pos) {
        this.pos = pos;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRoot = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_card, container, false);
        tvIndex = (TextView) mRoot.findViewById(R.id.tv_index);
        tvIndex.setText(pos + "");

//        mRoot.setBackgroundColor(Color.parseColor(colors.get(pos % 2)));
        Log.d("onCreateView", "onCreateView=" + pos);
        return mRoot;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("onDestroyView", "onDestroyView=" + pos);

    }
}
