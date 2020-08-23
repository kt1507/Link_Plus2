package com.example.linkmain;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class ListViewFragment extends Fragment {

    private ListView listview;
    private ListViewAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.content_main, container, false);

        adapter = new ListViewAdapter();

        //리스트뷰 참조 및 Adapter 달기
        listview = (ListView) root.findViewById(R.id.listview);
        listview.setAdapter(adapter);

        //db파일 테스트
        StoreDBClass storeDBClass = new StoreDBClass();
        storeDBClass.storedbclass();
        for(int i = 0; i < 5; i++){
            adapter.addItem(storeDBClass.store[i].getStorename(),storeDBClass.store[i].getPhone(),storeDBClass.store[i].getWorktime(),"주차 가능 여부 : X",getResources().getDrawable(R.mipmap.ic_launcher));
        }
        //adapter.addItem(storeDBClass.store[0].getStorename(),storeDBClass.store[0].getPhone(),storeDBClass.store[0].getWorktime(),"주차 가능 여부 : X", getResources().getDrawable(R.mipmap.ic_launcher));

        //adapter를 통해 자료 추가
        adapter.addItem("야무진", "042-638-0689~90", "8:30~17:30", "주차 가능 여부 : X", getResources().getDrawable(R.mipmap.ic_launcher));
        adapter.addItem("대남기공사", "042-626-4880", "07:00~18:00", "주차 가능 여부 : O", getResources().getDrawable(R.mipmap.ic_launcher));
        adapter.addItem("세종종합상사", "042-635-6040", "07:00~19:00", "주차 가능 여부 : O", getResources().getDrawable(R.mipmap.ic_launcher));
        adapter.addItem("샘 광고 레이저", "042-632-4445,631-0907", "08:00~18:00", "주차 가능 여부 : O", getResources().getDrawable(R.mipmap.ic_launcher));
        adapter.addItem("명창종합상사", "042-626-9240", "07:00~19:00", "주차 가능 여부 : O", getResources().getDrawable(R.mipmap.ic_launcher));
        adapter.addItem("케이투발전기(주)", "042-673-9400", "08:00~18:30", "주차 가능 여부 : O", getResources().getDrawable(R.mipmap.ic_launcher));

        adapter.notifyDataSetChanged(); //어댑터의 변경을 알림

        return root;
    }

    public void update(){
        adapter.notifyDataSetChanged();
    }
}
