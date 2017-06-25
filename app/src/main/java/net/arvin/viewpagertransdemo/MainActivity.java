package net.arvin.viewpagertransdemo;

import android.animation.ArgbEvaluator;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import net.arvin.viewpagertransdemo.adapter.LoopPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 一屏多页
 * 循环有个点问题，注释掉了，之后再研究
 * <p>
 * 自动切换的方式太复杂，遗弃了
 */
public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {
    private ViewPager mPager;
    private List<Integer> mItems;

    private View mRoot;

//    private int currentPosition;
//    private boolean isNeedChange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRoot = findViewById(R.id.mRoot);
        initData();
        initView(savedInstanceState);
    }

    private void initData() {
//        currentPosition = 1;
//        isNeedChange = false;
        mItems = new ArrayList<>();
        mItems.addAll(getColors());
    }

    private List<Integer> getColors() {
        List<Integer> colors = new ArrayList<>();
        colors.add(getResources().getColor(R.color.colorPrimary));
        colors.add(getResources().getColor(R.color.colorAccent));
        colors.add(getResources().getColor(R.color.colorPrimaryDark));
        colors.add(getResources().getColor(R.color.colorAccent));
        colors.add(getResources().getColor(R.color.colorPrimaryDark));
        colors.add(getResources().getColor(R.color.colorAccent));
        return colors;
    }

    private void initView(Bundle savedInstanceState) {
        mPager = (ViewPager) findViewById(R.id.mPager);
        mPager.setAdapter(new LoopPagerAdapter(getSupportFragmentManager(), mItems));
//        mPager.setPageMargin(Utils.dp2px(16));
        mPager.setOffscreenPageLimit(3);
//        mPager.setPageTransformer(true,new CardTransformer());
        mPager.setPageTransformer(true,new AlphaTransformer());
//        mPager.setCurrentItem(currentPosition);

        mPager.setOnPageChangeListener(this);
    }

    @Override
    public void onPageSelected(int position) {
//        currentPosition = position;
//        if (position == getColors().size() + 1) {
//            currentPosition = 1;
//            isNeedChange = true;
//        } else if (position == 0) {
//            isNeedChange = true;
//            currentPosition = getColors().size();
//        } else {
//            isNeedChange = false;
//        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {
//        if (state == ViewPager.SCROLL_STATE_IDLE && isNeedChange) {
//            mPager.setCurrentItem(currentPosition, false);
//        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        int color = mItems.get(position % mItems.size());
        if (positionOffset > 0) {
            color = Utils.getColor(positionOffset, mItems.get(position % mItems.size()),
                    mItems.get((position+1) % mItems.size()));
        }
        mRoot.setBackgroundColor(color);
    }

}
