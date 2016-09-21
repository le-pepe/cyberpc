package cl.skar.cyberpc;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

import cl.skar.cyberpc.util.HackyViewPager;
import cl.skar.cyberpc.util.ImageUtil;

public class FullScreenViewActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen_view);
        Intent intent = getIntent();
        int position = intent.getIntExtra("position",0);
        ViewPager viewPager = (HackyViewPager) findViewById(R.id.view_pager);
        setContentView(viewPager);
        ArrayList<String> list = ImageUtil.getImageUrls(this);
        HackyViewPagerAdapter adapter = new HackyViewPagerAdapter(list, this, position);
        viewPager.setAdapter(adapter);
    }
}
