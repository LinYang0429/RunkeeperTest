package com.example.linyang.runkeepertest;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class AchievementGroupItemRecyclerViewAdapter extends RecyclerView.Adapter<AchievementGroupItemRecyclerViewAdapter.ViewHolder> {

    private Context mContext;
    private List<List<String>> mData;
    private LayoutInflater mInflater;
    private AchievementGroupItemRecyclerViewAdapter.ItemClickListener mClickListener;

    AchievementGroupItemRecyclerViewAdapter(Context context, List<List<String>> data) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    @Override
    public AchievementGroupItemRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recyclerview_groups_item, parent, false);
        return new AchievementGroupItemRecyclerViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AchievementGroupItemRecyclerViewAdapter.ViewHolder holder, int position) {

        List<String> groupItems = mData.get(position);

        holder.groupItemNameTextView.setText(groupItems.get(0));
        holder.groupItemDescriptionTextView.setText(groupItems.get(1));

        Resources res = mContext.getResources();
        String mDrawableName = groupItems.get(2);
        int resID = res.getIdentifier(mDrawableName , "drawable", mContext.getPackageName());
        holder.groupItemImageView.setImageResource(resID);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView groupItemNameTextView;
        TextView groupItemDescriptionTextView;
        ImageView groupItemImageView;

        ViewHolder(View itemView) {
            super(itemView);
            groupItemNameTextView = itemView.findViewById(R.id.groupItem);
            groupItemDescriptionTextView = itemView.findViewById(R.id.groupItemDescription);
            groupItemImageView = itemView.findViewById(R.id.groupItemImage);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    void setClickListener(AchievementGroupItemRecyclerViewAdapter.ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
