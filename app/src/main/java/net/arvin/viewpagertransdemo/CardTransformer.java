package net.arvin.viewpagertransdemo;

import android.annotation.SuppressLint;
import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by arvinljw on 17/5/27 13:01
 * Function：
 * Desc：
 */
public class CardTransformer implements ViewPager.PageTransformer {
    private static final float MIN_SCALE = 0.9f;

    private static final int PAGE_OFFSET = 40;

    @SuppressLint("NewApi")
    @Override
    public void transformPage(View view, float position) {
        //position从左往右滑时，根据缓存了多少页，每一页的变化都是currPos到currPos+1；反之则为currPos到currPos-1；所以根据pos的大小可以控制当前页的位置，
        //例如下边改变translationX，让后几页一样显示到当前页，当然这里让它能被看到，
        //再调整ViewPager的宽高来控制协作控制其位置
        int pageWidth = view.getWidth();
        int pageHeight = view.getHeight();
        float scaleFactor;
        if (position < -1) { // [-Infinity,-1)
            view.setAlpha(0);
        } else if (position <= 0) {
            view.setAlpha(1 + position);
            scaleFactor = MIN_SCALE + (1 - MIN_SCALE)
                    * (1 - Math.abs(position));
            view.setScaleX(scaleFactor);
            view.setScaleY(scaleFactor);
        } else {
            view.setAlpha(1 + position);
            if (position <= 3) {
                if (position <= 2) {
                    view.setAlpha(1);
                } else {
                    view.setAlpha(1 - (position - 2));
                }
                view.setTranslationX(pageWidth * -position);
            } else {
                view.setAlpha(0);
            }
            scaleFactor = MIN_SCALE + (1 - MIN_SCALE)
                    * (1 - Math.abs(position));
            view.setScaleX(scaleFactor);
            view.setScaleY(scaleFactor);
            view.setTranslationY(-position * PAGE_OFFSET - (pageHeight - pageHeight * scaleFactor) / 2);
        }
    }
}
