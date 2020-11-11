package com.example.linyang.runkeepertest;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.LinkedHashMap;
import java.util.List;

// first layer recycler view's adapter
public class AchievementGroupRecyclerViewAdapter extends RecyclerView.Adapter<AchievementGroupRecyclerViewAdapter.ViewHolder> {

    static final int COLUMN_NUM = 2;

    private Context mContext;
    private LinkedHashMap <String, List<List<String>>> mData;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    AchievementGroupItemRecyclerViewAdapter gridViewAdapter;
    AchievementGroupItemRecyclerViewAdapter.ItemClickListener groupItemListener;

    AchievementGroupRecyclerViewAdapter(Context context, LinkedHashMap<String, List<List<String>>> data) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recyclerview_groups_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String groupName = (String) mData.keySet().toArray()[position];
        List<List<String>> groupItems= (List<List<String>>) mData.values().toArray()[position];
        int completes = 0;
        for(int i = 0; i < groupItems.size(); i++) {
            if (groupItems.get(i).get(3).equals("1")) {
                completes++;
            }
        }

        holder.groupNameTextView.setText(groupName);
        holder.groupCountTextView.setText(completes + " of " + groupItems.size());

        RecyclerView recyclerViewGrid = holder.itemView.findViewById(R.id.gridGroupItems);
        recyclerViewGrid.setLayoutManager(new GridLayoutManager(mContext, COLUMN_NUM));
        gridViewAdapter = new AchievementGroupItemRecyclerViewAdapter(mContext, groupItems);
        gridViewAdapter.setClickListener(groupItemListener);
        recyclerViewGrid.setAdapter(gridViewAdapter);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView groupNameTextView;
        TextView groupCountTextView;

        ViewHolder(View itemView) {
            super(itemView);
            groupNameTextView = itemView.findViewById(R.id.groupName);
            groupCountTextView = itemView.findViewById(R.id.counts);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
