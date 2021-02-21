package github.io.rahmatsyam.firstsubmission.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import github.io.rahmatsyam.firstsubmission.R;
import github.io.rahmatsyam.firstsubmission.data.model.CoffeeModel;
import github.io.rahmatsyam.firstsubmission.ui.adapter.ItemCoffeeAdapter;
import github.io.rahmatsyam.firstsubmission.data.DummyData;
import github.io.rahmatsyam.firstsubmission.databinding.ActivityMainBinding;
import github.io.rahmatsyam.firstsubmission.ui.dialogfragment.CoffeeDetailDialogFragment;
import github.io.rahmatsyam.firstsubmission.ui.dialogfragment.ProfileDialogFragment;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    protected ItemCoffeeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setRVCoffee();
    }

    private void setRVCoffee() {
        adapter = new ItemCoffeeAdapter();

        adapter.setData(DummyData.getListCoffee(this), this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        binding.rvCoffee.setLayoutManager(layoutManager);
        binding.rvCoffee.setHasFixedSize(true);
        binding.rvCoffee.setAdapter(adapter);

        adapter.setClickItem(this::setDataFragment);

    }

    private void setDataFragment(CoffeeModel coffeeModel) {
        CoffeeDetailDialogFragment dialogFragment = CoffeeDetailDialogFragment.newInstance(coffeeModel);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        dialogFragment.show(ft, CoffeeDetailDialogFragment.TAG);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_about, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_profile) {
            aboutProfile();
        } else {
            return super.onOptionsItemSelected(item);
        }
        return true;
    }

    private void aboutProfile() {
        ProfileDialogFragment dialogFragment = new ProfileDialogFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        dialogFragment.show(ft, ProfileDialogFragment.TAG);
    }

    @Override
    public void onBackPressed() {
        finishAndRemoveTask();
    }

}
