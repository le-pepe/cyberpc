package cl.skar.cyberpc.util;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import cl.skar.cyberpc.FullScreenViewActivity;
import cl.skar.cyberpc.R;

/**
 * Created by trabajo on 16/09/2016.
 */
public class GridViewAdapter extends BaseAdapter {

    private Activity activity;
    private ArrayList<String> urls = new ArrayList<String>();

    public GridViewAdapter(Activity activity, ArrayList<String> urls) {
        this.activity = activity;
        this.urls = urls;
    }

    @Override
    public int getCount() {
        return urls.size();
    }

    @Override
    public Object getItem(int position) {
        return urls.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            imageView = (ImageView) parent.findViewById(R.id.imageView);
        } else {
            imageView = (ImageView) convertView;
        }
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Glide.with(activity).load(urls.get(position)).into(imageView);
        return imageView;
    }
    class OnImageClickListener implements View.OnClickListener {

        int _postion;

        // constructor
        public OnImageClickListener(int position) {
            this._postion = position;
        }

        @Override
        public void onClick(View v) {
            // on selecting grid view image
            // launch full screen activity
            Intent i = new Intent(activity, FullScreenViewActivity.class);
            i.putExtra("position", _postion);
            activity.startActivity(i);
        }

    }
}

