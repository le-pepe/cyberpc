package cl.skar.cyberpc;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import cl.skar.cyberpc.util.CustomImageView;
import uk.co.senab.photoview.PhotoViewAttacher;

public class HackyViewPagerAdapter extends PagerAdapter {

    private ArrayList<String> list;
    private Context context;
    int position = -1;
    private boolean doNotifyDataSetChangedOnce;

    public HackyViewPagerAdapter(ArrayList<String> list, Context context, int position) {
        this.list = list;
        this.context = context;
        this.position = position;
    }

    public HackyViewPagerAdapter(ArrayList<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public View instantiateItem(ViewGroup container, int position) {
        if(this.position != -1){
            position = this.position;
        }
        doNotifyDataSetChangedOnce = true;
        CustomImageView photoView = new CustomImageView(container.getContext());
        final PhotoViewAttacher attacher = new PhotoViewAttacher(photoView);
        Picasso.with(context)
                .load(list.get(position))
                .into(photoView, new Callback() {
                    @Override
                    public void onSuccess() {
                        attacher.update();
                    }

                    @Override
                    public void onError() {

                    }
                });

        // Now just add PhotoView to ViewPager and return it
        container.addView(photoView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        return photoView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
