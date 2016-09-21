package cl.skar.cyberpc;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import cl.skar.cyberpc.util.CustomImageView;
import uk.co.senab.photoview.PhotoViewAttacher;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private ArrayList<String> list;
    private Context context;

    public RecyclerAdapter(ArrayList<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView layoutView = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);
        return new RecyclerAdapter.ViewHolder(layoutView);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final PhotoViewAttacher attacher = new PhotoViewAttacher(holder.photoView);
        Picasso.with(context)
                .load(list.get(position))
                .into(holder.photoView, new Callback() {
                    @Override
                    public void onSuccess() {
                        attacher.update();
                    }

                    @Override
                    public void onError() {

                    }
                });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public CustomImageView photoView;

        public ViewHolder(View itemView) {
            super(itemView);
            photoView = (CustomImageView) itemView.findViewById(R.id.imageView_recycler);
        }

    }
}

