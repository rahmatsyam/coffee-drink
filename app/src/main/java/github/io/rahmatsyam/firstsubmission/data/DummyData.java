package github.io.rahmatsyam.firstsubmission.data;

import android.app.Activity;

import java.util.ArrayList;
import java.util.Collections;

import github.io.rahmatsyam.firstsubmission.R;
import github.io.rahmatsyam.firstsubmission.data.model.CoffeeModel;

public class DummyData {

    public static ArrayList<CoffeeModel> getListCoffee(Activity activity) {
        ArrayList<CoffeeModel> lisCoffee = new ArrayList<>();
        lisCoffee.clear();

        String [] coffeeName = activity.getResources().getStringArray(R.array.coffee_name);
        String [] coffeeDesc = activity.getResources().getStringArray(R.array.coffee_desc);
        String [] urlCoffee = activity.getResources().getStringArray(R.array.url_coffee);

        for (int i = 0; i < coffeeName.length; i++){
            lisCoffee.add(new CoffeeModel(coffeeName[i], coffeeDesc[i], urlCoffee[i]));
        }

        Collections.sort(lisCoffee, CoffeeModel.coffeeNameComparator);

        return lisCoffee;

    }
}
