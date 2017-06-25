package net.arvin.viewpagertransdemo;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by arvinljw on 17/6/25 12:26
 * Function：
 * Desc：
 */
public class AlphaTransformer implements ViewPager.PageTransformer {
    @Override
    public void transformPage(View page, float position) {
        if (position <= 0) {
            float alpha = 0.7f * (1 + position) + 0.3f;
            page.setAlpha(alpha);
        } else {
            float alpha = 0.7f * (1 - position) + 0.3f;
            page.setAlpha(alpha);
        }
    }
}
