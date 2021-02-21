package github.io.rahmatsyam.firstsubmission.ui.dialogfragment;

import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.Objects;

import github.io.rahmatsyam.firstsubmission.R;
import github.io.rahmatsyam.firstsubmission.data.model.CoffeeModel;
import github.io.rahmatsyam.firstsubmission.databinding.FragmentCoffeeDetailDialogBinding;

public class CoffeeDetailDialogFragment extends DialogFragment {

    private FragmentCoffeeDetailDialogBinding binding;

    public static String TAG = "FullScreenDialog";
    private static final String TAG_COFFEE = "tag_coffee";

    public static CoffeeDetailDialogFragment newInstance(CoffeeModel coffeeModel) {
        CoffeeDetailDialogFragment fragment = new CoffeeDetailDialogFragment();
        Bundle args = new Bundle();
        args.putParcelable(TAG_COFFEE, coffeeModel);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.FullScreenDialogStyle);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentCoffeeDetailDialogBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initData();
    }

    private void initData() {

        Bundle bundle = getArguments();
        if (bundle != null) {
            CoffeeModel coffeeModel = bundle.getParcelable(TAG_COFFEE);

            binding.tvCoffeeDesc.setText(coffeeModel.getCoffeeDesc());
            binding.tvHeader.setText(coffeeModel.getCoffeeName());
            Glide.with(requireContext())
                    .load(coffeeModel.getUrlCoffeePhoto())
                    .optionalFitCenter()
                    .into(binding.ivCoffee);

            binding.ivClose.setOnClickListener(v -> dismiss());
        }

    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            int width = ViewGroup.LayoutParams.MATCH_PARENT;
            int height = ViewGroup.LayoutParams.MATCH_PARENT;
            Objects.requireNonNull(dialog.getWindow()).setLayout(width, height);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
