package github.io.rahmatsyam.firstsubmission.ui.dialogfragment;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.bumptech.glide.Glide;

import java.util.Objects;

import github.io.rahmatsyam.firstsubmission.R;

import github.io.rahmatsyam.firstsubmission.databinding.FragmentProfileDialogBinding;

public class ProfileDialogFragment extends DialogFragment {

    private FragmentProfileDialogBinding binding;

    public static String TAG = "FullScreenDialog";

    String linkPhoto = "https://avatars.githubusercontent.com/u/21690091?s=460&u=31e4636e2329a2ea0fafa372c6b57b36fdbe16c2&v=4";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.FullScreenDialogStyle);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentProfileDialogBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initData();
    }

    private void initData() {
        Glide.with(requireContext())
                .load(linkPhoto)
                .circleCrop()
                .into(binding.ivProfile);

        binding.ivClose.setOnClickListener(v -> dismiss());
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
