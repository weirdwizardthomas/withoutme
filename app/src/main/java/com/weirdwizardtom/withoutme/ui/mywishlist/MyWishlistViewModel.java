package com.weirdwizardtom.withoutme.ui.mywishlist;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyWishlistViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public MyWishlistViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is dashboard fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}