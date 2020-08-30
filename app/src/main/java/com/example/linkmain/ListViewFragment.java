package com.example.linkmain;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

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

//            Toast.makeText(this.getContext(), Tab1, Toast.LENGTH_SHORT).show();
//            Toast.makeText(this.getContext(), Tab2, Toast.LENGTH_SHORT).show();
//            Toast.makeText(this.getContext(), Tab3, Toast.LENGTH_SHORT).show();
//            Toast.makeText(this.getContext(), Tab4, Toast.LENGTH_SHORT).show();
//            Toast.makeText(this.getContext(), Tab5, Toast.LENGTH_SHORT).show();

           // update(root);
        }
        adapter = new ListViewAdapter();

        //리스트뷰 참조 및 Adapter 달기
        listview = (ListView) root.findViewById(R.id.listview);
        listview.setAdapter(adapter);

        //db파일 객체
        StoreDBClass storeDBClass = new StoreDBClass();
        storeDBClass.storedbclass();
        /*for(int i = 0; i < 67; i++){
            if(Tab1 != null && Tab1.equals(storeDBClass.store[i].getCategory())){
                adapter.addItem(storeDBClass.store[i].getStorename(), storeDBClass.store[i].getPhone(), storeDBClass.store[i].getWorktime(), storeDBClass.store[i].getCategory(), storeDBClass.store[i].getParking(), storeDBClass.store[i].getStore_picture());
            }
            if(Tab2 != null && Tab2.equals(storeDBClass.store[i].getCategory())){
                adapter.addItem(storeDBClass.store[i].getStorename(), storeDBClass.store[i].getPhone(), storeDBClass.store[i].getWorktime(), storeDBClass.store[i].getCategory(), storeDBClass.store[i].getParking(), storeDBClass.store[i].getStore_picture());
            }
            if(Tab3 != null && Tab3.equals(storeDBClass.store[i].getCategory())){
                adapter.addItem(storeDBClass.store[i].getStorename(), storeDBClass.store[i].getPhone(), storeDBClass.store[i].getWorktime(), storeDBClass.store[i].getCategory(), storeDBClass.store[i].getParking(), storeDBClass.store[i].getStore_picture());
            }
            if(Tab4 != null && Tab4.equals(storeDBClass.store[i].getCategory())){
                adapter.addItem(storeDBClass.store[i].getStorename(), storeDBClass.store[i].getPhone(), storeDBClass.store[i].getWorktime(), storeDBClass.store[i].getCategory(), storeDBClass.store[i].getParking(), storeDBClass.store[i].getStore_picture());
            }
            if(Tab5 != null && Tab5.equals(storeDBClass.store[i].getCategory())){
                adapter.addItem(storeDBClass.store[i].getStorename(), storeDBClass.store[i].getPhone(), storeDBClass.store[i].getWorktime(), storeDBClass.store[i].getCategory(), storeDBClass.store[i].getParking(), storeDBClass.store[i].getStore_picture());
            }
            //adapter.addItem(storeDBClass.store[i].getStorename(), storeDBClass.store[i].getPhone(), storeDBClass.store[i].getWorktime(), storeDBClass.store[i].getCategory(), storeDBClass.store[i].getParking(), storeDBClass.store[i].getStore_picture());
        }*/
        for(int i = 0; i < 67; i++){
            adapter.addItem(storeDBClass.store[i].getStorename(), storeDBClass.store[i].getPhone(), storeDBClass.store[i].getWorktime(), storeDBClass.store[i].getCategory(), storeDBClass.store[i].getParking(), storeDBClass.store[i].getStore_picture());
        }
        //adapter.addItem(storeDBClass.store[0].getStorename(),storeDBClass.store[0].getPhone(),storeDBClass.store[0].getWorktime(),"주차 가능 여부 : X", getResources().getDrawable(R.mipmap.ic_launcher));

        //adapter를 통해 자료 추가
        /*adapter.addItem("야무진", "042-638-0689~90", "8:30~17:30", "주차 가능 여부 : X", getResources().getDrawable(R.mipmap.ic_launcher));
        adapter.addItem("대남기공사", "042-626-4880", "07:00~18:00", "주차 가능 여부 : O", getResources().getDrawable(R.mipmap.ic_launcher));
        adapter.addItem("세종종합상사", "042-635-6040", "07:00~19:00", "주차 가능 여부 : O", getResources().getDrawable(R.mipmap.ic_launcher));
        adapter.addItem("샘 광고 레이저", "042-632-4445,631-0907", "08:00~18:00", "주차 가능 여부 : O", getResources().getDrawable(R.mipmap.ic_launcher));
        adapter.addItem("명창종합상사", "042-626-9240", "07:00~19:00", "주차 가능 여부 : O", getResources().getDrawable(R.mipmap.ic_launcher));
        adapter.addItem("케이투발전기(주)", "042-673-9400", "08:00~18:30", "주차 가능 여부 : O", getResources().getDrawable(R.mipmap.ic_launcher));
*/
        adapter.notifyDataSetChanged(); //어댑터의 변경을 알림

        return root;
    }

    public void update(View root){
        adapter = new ListViewAdapter();

        listview = (ListView) root.findViewById(R.id.listview);
        listview.setAdapter(adapter);

        StoreDBClass storeDBClass = new StoreDBClass();
        storeDBClass.storedbclass();

        for(int i = 0; i < 67; i++){
            if(Tab1 != null && Tab1.equals(storeDBClass.store[i].getCategory())){
                adapter.addItem(storeDBClass.store[i].getStorename(), storeDBClass.store[i].getPhone(), storeDBClass.store[i].getWorktime(), storeDBClass.store[i].getCategory(), storeDBClass.store[i].getParking(), storeDBClass.store[i].getStore_picture());
            }
            if(Tab2 != null && Tab2.equals(storeDBClass.store[i].getCategory())){
                adapter.addItem(storeDBClass.store[i].getStorename(), storeDBClass.store[i].getPhone(), storeDBClass.store[i].getWorktime(), storeDBClass.store[i].getCategory(), storeDBClass.store[i].getParking(), storeDBClass.store[i].getStore_picture());
            }
            if(Tab3 != null && Tab3.equals(storeDBClass.store[i].getCategory())){
                adapter.addItem(storeDBClass.store[i].getStorename(), storeDBClass.store[i].getPhone(), storeDBClass.store[i].getWorktime(), storeDBClass.store[i].getCategory(), storeDBClass.store[i].getParking(), storeDBClass.store[i].getStore_picture());
            }
            if(Tab4 != null && Tab4.equals(storeDBClass.store[i].getCategory())){
                adapter.addItem(storeDBClass.store[i].getStorename(), storeDBClass.store[i].getPhone(), storeDBClass.store[i].getWorktime(), storeDBClass.store[i].getCategory(), storeDBClass.store[i].getParking(), storeDBClass.store[i].getStore_picture());
            }
            if(Tab5 != null && Tab5.equals(storeDBClass.store[i].getCategory())){
                adapter.addItem(storeDBClass.store[i].getStorename(), storeDBClass.store[i].getPhone(), storeDBClass.store[i].getWorktime(), storeDBClass.store[i].getCategory(), storeDBClass.store[i].getParking(), storeDBClass.store[i].getStore_picture());
            }
            //adapter.addItem(storeDBClass.store[i].getStorename(), storeDBClass.store[i].getPhone(), storeDBClass.store[i].getWorktime(), storeDBClass.store[i].getCategory(), storeDBClass.store[i].getParking(), storeDBClass.store[i].getStore_picture());
        }
        adapter.notifyDataSetChanged();

    }
}
