package kodman.appforpixeltex.mvp.view;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import kodman.appforpixeltex.R;
import kodman.appforpixeltex.mvp.model.Fact;
import kodman.appforpixeltex.mvp.model.Wallpaper;

public class RecyclerAdapter  extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    List<Wallpaper> list;

    public RecyclerAdapter list() {
        this.list= new ArrayList<>();
    }

    public void setWallpapers(List<Wallpaper> list){
        list.clear();
        list.addAll(list);
        notifyDataSetChanged();
    }



    private WallViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fact_item, parent, false);
        MainActivity.FactViewHolder viewholder = new MainActivity.FactViewHolder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(MainActivity.FactViewHolder holder, int position) {
        Fact fact = facts.get(position);
        holder.titleView.setText(fact.getTitle());
        holder.descriptionView.setText(fact.getDescription());

        String imageUrl = fact.getImageHref();
        if (TextUtils.isEmpty(imageUrl)) {
            holder.imageView.setVisibility(View.GONE);
        } else {
            holder.imageView.setVisibility(View.VISIBLE);
            Glide.with(holder.imageView.getContext())
                    .load(fact.getImageHref())
                    .fitCenter()
                    .into(holder.imageView);
        }
    }

    @Override
    public int getItemCount() {
        return facts.size();
    }
}

/**
 * ViewHolder for list item
 */

private static class WallpaperViewHolder extends RecyclerView.ViewHolder {

    public TextView titleView;
    public TextView descriptionView;
    public ImageView imageView;

    public WallpaperViewHolder(View itemView) {
        super(itemView);
        titleView = (TextView) itemView.findViewById(R.id.titleView);
        descriptionView = (TextView) itemView.findViewById(R.id.descriptionView);
        imageView = (ImageView) itemView.findViewById(R.id.imageView);
    }
}
}
