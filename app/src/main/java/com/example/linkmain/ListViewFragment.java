package com.example.linkmain;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.linkmain.ui.cat1.Cat1ViewModel;

public class ListViewFragment extends Fragment {

    private ListView listview;
    private ListViewAdapter adapter;
    private Cat1ViewModel cat1ViewModel;
    private String Tab1 = null;
    private String Tab2 = null;
    private String Tab3 = null;
    private String Tab4 = null;
    private String Tab5 = null;
    private String category = null;

    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.content_main, container, false);

        Bundle bundle = getArguments(); //MainActivity에서 bundle로 데이터 받아옴
        if (bundle != null) {
            category = bundle.getString("Tab1");
            if(category != null){
                Tab1 = category;
                category = null;
                //Toast.makeText(this.getContext(), Tab1, Toast.LENGTH_SHORT).show();
            }
            category = bundle.getString("Tab2");
            if(category != null){
                Tab2 = category;
                category = null;
                //Toast.makeText(this.getContext(), Tab2, Toast.LENGTH_SHORT).show();
            }
            category = bundle.getString("Tab3");
            if(category != null){
                Tab3 = category;
                category = null;
                //Toast.makeText(this.getContext(), Tab3, Toast.LENGTH_SHORT).show();
            }
            category = bundle.getString("Tab4");
            if(category != null){
                Tab4 = category;
                category = null;
                //Toast.makeText(this.getContext(), Tab4, Toast.LENGTH_SHORT).show();
            }
            category = bundle.getString("Tab5");
            if(category != null){
                Tab5 = category;
                category = null;
                //Toast.makeText(this.getContext(), Tab5, Toast.LENGTH_SHORT).show();
            }
            //update(root);
        }
        adapter = new ListViewAdapter();

        //리스트뷰 참조 및 Adapter 달기
        listview = (ListView) root.findViewById(R.id.listview);
        listview.setAdapter(adapter);

        //db파일 객체
        StoreDBClass storeDBClass = new StoreDBClass();
        storeDBClass.storedbclass();
        for(int i = 0; i < 67; i++){
            if(Tab1 != null && Tab1.equals(storeDBClass.store[i].getCategory())){
                adapter.addItem(storeDBClass.store[i].getStorename(), storeDBClass.store[i].getPhone(), storeDBClass.store[i].getWorktime(), storeDBClass.store[i].getCategory(), storeDBClass.store[i].getParking(), storeDBClass.store[i].getStore_picture());
            }
            else if(Tab2 != null && Tab2.equals(storeDBClass.store[i].getCategory())){
                adapter.addItem(storeDBClass.store[i].getStorename(), storeDBClass.store[i].getPhone(), storeDBClass.store[i].getWorktime(), storeDBClass.store[i].getCategory(), storeDBClass.store[i].getParking(), storeDBClass.store[i].getStore_picture());
            }
            else if(Tab3 != null && Tab3.equals(storeDBClass.store[i].getCategory())){
                adapter.addItem(storeDBClass.store[i].getStorename(), storeDBClass.store[i].getPhone(), storeDBClass.store[i].getWorktime(), storeDBClass.store[i].getCategory(), storeDBClass.store[i].getParking(), storeDBClass.store[i].getStore_picture());
            }
            else if(Tab4 != null && Tab4.equals(storeDBClass.store[i].getCategory())){
                adapter.addItem(storeDBClass.store[i].getStorename(), storeDBClass.store[i].getPhone(), storeDBClass.store[i].getWorktime(), storeDBClass.store[i].getCategory(), storeDBClass.store[i].getParking(), storeDBClass.store[i].getStore_picture());
            }
            else if(Tab5 != null && Tab5.equals(storeDBClass.store[i].getCategory())){
                adapter.addItem(storeDBClass.store[i].getStorename(), storeDBClass.store[i].getPhone(), storeDBClass.store[i].getWorktime(), storeDBClass.store[i].getCategory(), storeDBClass.store[i].getParking(), storeDBClass.store[i].getStore_picture());
            }
            else if(Tab1 == "모두표시" || Tab1 == null){
                adapter.addItem(storeDBClass.store[i].getStorename(), storeDBClass.store[i].getPhone(), storeDBClass.store[i].getWorktime(), storeDBClass.store[i].getCategory(), storeDBClass.store[i].getParking(), storeDBClass.store[i].getStore_picture());
            }

        }
        adapter.notifyDataSetChanged(); //어댑터의 변경을 알림

        return root;
    }
}
