package net.arvin.viewpagertransdemo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import net.arvin.viewpagertransdemo.CardFragment;
import net.arvin.viewpagertransdemo.SimpleFragment;

import java.util.List;

/**
 * Created by arvin on 2016/8/24 09:52
 */
public class LoopPagerAdapter extends FragmentStatePagerAdapter {
    private List<Integer> items;

    public LoopPagerAdapter(FragmentManager fm, List<Integer> items) {
        super(fm);
        this.items = items;
    }

    @Override
    public int getCount() {
        //比原来的页数多两页，因为在第一页前加；最后一页后也要加一页
//        return items.size() + 2;
        return items.size();
    }

    @Override
    public Fragment getItem(int position) {
//        //将position转化为对应在items的position
//        if (position == items.size() + 1) {
//            //在最后一页的时候显示第一页的内容，
//            position = 0;
//        } else if (position == 0) {
//            //在第一页的时候显示最后一页的内容
//            position = items.size() - 1;
//        } else {
//            position -= 1;
//        }
        //显示相应页的内容
//        return new SimpleFragment(items.get(position));
        return new CardFragment(position);
    }
}
