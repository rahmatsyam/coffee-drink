package github.io.rahmatsyam.firstsubmission.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import github.io.rahmatsyam.firstsubmission.databinding.ItemCoffeeBinding;
import github.io.rahmatsyam.firstsubmission.data.model.CoffeeModel;

public class ItemCoffeeAdapter extends RecyclerView.Adapter<CoffeeViewHolder> {

    private ArrayList<CoffeeModel> mCoffeeList;

    private OnItemClickListener mListener;

    private Context mContext;

    public ItemCoffeeAdapter() {

    }

    public void setData(ArrayList<CoffeeModel> list, Context context) {
        this.mCoffeeList = list;
        this.mContext = context;
    }

    public void setClickItem(OnItemClickListener clickListener) {
        this.mListener = clickListener;
    }

    @NonNull
    @Override
    public CoffeeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        ItemCoffeeBinding binding = ItemCoffeeBinding.inflate(inflater, viewGroup, false);
        return new CoffeeViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CoffeeViewHolder holder, int position) {
        holder.bindTo(mCoffeeList.get(position), mContext, mListener);
    }


    @Override
    public int getItemCount() {
        return mCoffeeList.size();
    }

}
