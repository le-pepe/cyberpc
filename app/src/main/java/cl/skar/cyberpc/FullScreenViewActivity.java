package cl.skar.cyberpc;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

import cl.skar.cyberpc.util.HackyViewPager;

/**
 * Created by trabajo on 16/09/2016.
 */
public class FullScreenViewActivity extends AppCompatActivity{

    private HackyViewPager viewPager;
    private FullScreenImageAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_fullscreen);

        viewPager = (HackyViewPager) findViewById(R.id.view_pager);

        Intent i = getIntent();
        int position = i.getIntExtra("position", 0);

        adapter = new FullScreenImageAdapter(FullScreenViewActivity.this,
                new ArrayList<String>());

        viewPager.setAdapter(adapter);

        // displaying selected image first
        viewPager.setCurrentItem(position);

    }
}
