package cl.skar.cyberpc;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.GlideUrl;

import java.util.ArrayList;

import uk.co.senab.photoview.PhotoView;
import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * Created by trabajo on 20/09/2016.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private ArrayList<String> list;
    private Context context;

    public RecyclerAdapter(ArrayList<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, null);
        RecyclerAdapter.ViewHolder holder = new RecyclerAdapter.ViewHolder(layoutView);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final PhotoViewAttacher attacher = new PhotoViewAttacher(holder.photoView);
        GlideUrl glideUrl = new GlideUrl(list.get(position)+"/");
        Glide.with(context)
                .load(glideUrl)
                .fitCenter()
                .centerCrop()
                .into(holder.photoView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public PhotoView photoView;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(new OnImageClickListener(getLayoutPosition(), itemView.getContext()));
            photoView = (PhotoView) itemView.findViewById(R.id.imageView_recycler);
        }


        class OnImageClickListener implements View.OnClickListener {

            int _postion;
            Context _context;

            // constructor
            public OnImageClickListener(int position, Context context) {
                this._postion = position;
                this._context = context;
            }

            @Override
            public void onClick(View v) {
                // on selecting grid view image
                // launch full screen activity
                /*Intent i = new Intent(_context, FullScreenViewActivity.class);
                i.putExtra("position", _postion);
                _context.startActivity(i);*/
            }

        }
    }
}
