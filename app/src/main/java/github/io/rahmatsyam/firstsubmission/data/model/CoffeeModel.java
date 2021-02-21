package github.io.rahmatsyam.firstsubmission.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Comparator;

public class CoffeeModel implements Parcelable {

    protected String coffeeName, coffeeDesc, urlCoffeePhoto;

    public CoffeeModel(String coffeeName, String coffeeDesc, String urlHerbPhotoHerb) {
        this.coffeeName = coffeeName;
        this.coffeeDesc = coffeeDesc;
        this.urlCoffeePhoto = urlHerbPhotoHerb;
    }

    public String getCoffeeName() {
        return coffeeName;
    }

    public String getCoffeeDesc() {
        return coffeeDesc;
    }

    public String getUrlCoffeePhoto() {
        return urlCoffeePhoto;
    }

    public static Comparator<CoffeeModel> coffeeNameComparator = (o1, o2) -> {
        String coffee1 = o1.getCoffeeName().toUpperCase();
        String coffee2 = o2.getCoffeeName().toUpperCase();
        return coffee1.compareTo(coffee2);
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.coffeeName);
        dest.writeString(this.coffeeDesc);
        dest.writeString(this.urlCoffeePhoto);
    }

    private CoffeeModel(Parcel in){
        this.coffeeName = in.readString();
        this.coffeeDesc = in.readString();
        this.urlCoffeePhoto = in.readString();
    }

    public static Parcelable.Creator<CoffeeModel> CREATOR = new Parcelable.Creator<CoffeeModel>() {
        @Override
        public CoffeeModel createFromParcel(Parcel source) {
            return new CoffeeModel(source);
        }

        @Override
        public CoffeeModel[] newArray(int size) {
            return new CoffeeModel[size];
        }
    };

}
