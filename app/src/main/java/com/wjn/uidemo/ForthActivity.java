package com.wjn.uidemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;

public class ForthActivity extends AppCompatActivity {

    private Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        bitmap= BitmapFactory.decodeResource(getResources(),R.mipmap.mission);

    }

    /**
     * onResume方法
     * */

    @Override
    protected void onResume() {
        super.onResume();

        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {

                /**
                 * 获取颜色值方式1
                 * */

                Palette.Swatch vibrant = palette.getVibrantSwatch();
                if (null == vibrant) {
                    for (Palette.Swatch swatch : palette.getSwatches()) {
                        vibrant = swatch;
                        break;
                    }
                }
                // 获取Rgb格式颜色值
                int rbg = vibrant.getRgb();

                /**
                 * 获取颜色值方式2
                 * */

                // 获取到柔和的深色的颜色（可传默认值）
                int color1 = palette.getDarkMutedColor(Color.BLUE);
                // 获取到活跃的深色的颜色（可传默认值）
                int color2 = palette.getDarkVibrantColor(Color.BLUE);
                // 获取到柔和的明亮的颜色（可传默认值）
                int color3 = palette.getLightMutedColor(Color.BLUE);
                // 获取到活跃的明亮的颜色（可传默认值）
                int color4 = palette.getLightVibrantColor(Color.BLUE);
                // 获取图片中最活跃的颜色（也可以说整个图片出现最多的颜色）（可传默认值）
                int color5 = palette.getVibrantColor(Color.BLUE);
                // 获取图片中一个最柔和的颜色（可传默认值）
                int color6 = palette.getMutedColor(Color.BLUE);

                //根据状态栏颜色来决定 状态栏背景 用黑色还是白色 true:是否修改状态栏字体颜色
                StatusBarUtil.setStatusBarMode(ForthActivity.this, true,true,color3);
            }
        });

    }

}
