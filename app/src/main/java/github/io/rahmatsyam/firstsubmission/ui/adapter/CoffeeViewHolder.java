package github.io.rahmatsyam.firstsubmission.ui.adapter;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import github.io.rahmatsyam.firstsubmission.databinding.ItemCoffeeBinding;
import github.io.rahmatsyam.firstsubmission.data.model.CoffeeModel;

public class CoffeeViewHolder extends RecyclerView.ViewHolder {

    protected ItemCoffeeBinding mBinding;

    public CoffeeViewHolder(ItemCoffeeBinding binding) {
        super(binding.getRoot());
        mBinding = binding;

    }

    public void bindTo(CoffeeModel coffeeModel, Context context, OnItemClickListener listener){
        mBinding.tvCoffeeName.setText(coffeeModel.getCoffeeName());
        mBinding.tvCoffeeDesc.setText(coffeeModel.getCoffeeDesc());

        Glide.with(context)
                .load(coffeeModel.getUrlCoffeePhoto())
                .centerCrop()
                .into(mBinding.ivCoffee);

        mBinding.btnMore.setOnClickListener(v -> listener.onItemClick(coffeeModel));

    }
}
