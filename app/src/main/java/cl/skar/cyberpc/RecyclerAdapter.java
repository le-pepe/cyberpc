package cl.skar.cyberpc;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

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
        CardView layoutView = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);
        return new RecyclerAdapter.ViewHolder(layoutView);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final PhotoViewAttacher attacher = new PhotoViewAttacher(holder.photoView);
        Picasso.with(context)
                .load(list.get(position))
                //.centerCrop()
                .into(holder.photoView, new Callback() {
                    @Override
                    public void onSuccess() {
                        attacher.update();
                        Log.d("attacher updated", "Picasso");
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
