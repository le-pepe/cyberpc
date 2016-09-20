package cl.skar.cyberpc;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import cl.skar.cyberpc.util.HackyViewPager;
import uk.co.senab.photoview.PhotoView;

public class FullScreenImageAdapter extends PagerAdapter {

    private Activity activity;
    private ArrayList<String> _imagePaths;
    private LayoutInflater inflater;

    public FullScreenImageAdapter(Activity activity, ArrayList<String> _imagePaths) {
        this.activity = activity;
        this._imagePaths = _imagePaths;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((RelativeLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        PhotoView imgDisplay;

        inflater = (LayoutInflater) activity
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View viewLayout = inflater.inflate(R.layout.fullscreen_image, container,
                false);

        imgDisplay = (PhotoView) viewLayout.findViewById(R.id.imgDisplay);

        Glide.with(activity).load(_imagePaths.get(position)).into(imgDisplay);


        ((HackyViewPager) container).addView(viewLayout);

        return viewLayout;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((HackyViewPager) container).removeView((RelativeLayout) object);

    }
}
