package com.example.retrofitjava.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitjava.Entity.GetDataEntity;
import com.example.retrofitjava.R;
import com.example.retrofitjava.databinding.CardRecycleListBinding;

import java.util.ArrayList;

public class RecycleListAdapter extends RecyclerView.Adapter<RecycleListAdapter.RecycleListHolder> {

    private final ArrayList<GetDataEntity.Results> arr_list_results;
    private final Context mContext;
    private CardRecycleListBinding cardRecycleListBinding;
    private OnClickList onClickList;
    private int selectPosition;

    public RecycleListAdapter(Context context, ArrayList<GetDataEntity.Results> results) {
        this.mContext = context;
        this.arr_list_results = results;
        try {
            onClickList = (OnClickList) context;
        } catch (ClassCastException e) {
            throw new ClassCastException("Calling Activity must implement OnClickList interface");
        }
    }

    @NonNull
    @Override
    public RecycleListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        cardRecycleListBinding = CardRecycleListBinding.inflate(LayoutInflater.from(mContext), parent, false);
        return new RecycleListHolder(cardRecycleListBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleListHolder holder, int position) {
        GetDataEntity.Results results = arr_list_results.get(position);
        holder.cardRecycleListBinding.Gender.setText(results.getGender());
        holder.cardRecycleListBinding.tvName.setText(results.getName().getFirst() + " " + results.getName().getFirst() + " " + results.getName().getLast());
        holder.cardRecycleListBinding.tvEmail.setText(results.getEmail());
        holder.cardRecycleListBinding.llListView.setTag(R.string.POSITION, position);
        holder.cardRecycleListBinding.llListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LinearLayout linearLayout = (LinearLayout) view;
                int position = (int) linearLayout.getTag(R.string.POSITION);
                onClickList.OnClickList(arr_list_results.get(position), position);
            }
        });
        if (position == selectPosition) {
            helightView(holder);
        } else {
            normalView(holder);
        }
    }

    private void normalView(RecycleListHolder holder) {
        holder.cardRecycleListBinding.cvMainView.setCardBackgroundColor(Color.WHITE);
    }

    private void helightView(RecycleListHolder holder) {
        holder.cardRecycleListBinding.cvMainView.setCardBackgroundColor(Color.parseColor("#FFBB86FC"));
    }

    @Override
    public int getItemCount() {
        return arr_list_results.size();
    }

    public class RecycleListHolder extends RecyclerView.ViewHolder {
        private CardRecycleListBinding cardRecycleListBinding;

        public RecycleListHolder(@NonNull CardRecycleListBinding itemView) {
            super(itemView.getRoot());
            cardRecycleListBinding = itemView;
        }
    }

    public interface OnClickList {
        void OnClickList(GetDataEntity.Results results, int position);
    }
}
