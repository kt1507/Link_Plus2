package com.example.linkmain.ui.cat1;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class Cat1ViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    private MutableLiveData<String> liveText = new MutableLiveData<>();

    public LiveData<String> getText(){
        return liveText;
    }

    public void setText(String text){
        liveText.setValue(text);
    }
}