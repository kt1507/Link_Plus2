package com.example.linkmain;

public class StoreDBClass {

    StoreClass[] store = new StoreClass[100];

    //하드코딩
    public void storedbclass(){
            store[0] = new StoreClass("대일전기", "대전광역시 대덕구 오전동 370-9", 36.349524, 127.414039, "042-633-0765", "NULL", "NULL", false);
            store[1] = new StoreClass("LS산전","대전광역시 대덕구 오정동 298-5", 36.354680,127.407600,"NULL","월-금 08:30~18:00 / 토 08:30~15:00","일요일",false);
            store[2] = new StoreClass("백제종합전기", "대전광역시 대덕구 오정로 22", 36.349128,127.415073,"042-622-1670", "NULL","NULL",false);
            store[3] = new StoreClass("명일전기", "대전광역시 대덕구 오정로 26", 36.350293,127.413880,"042-631-5894","월~토 08:00~19:00","일요일, 명절",true);
            store[4] = new StoreClass("상일전기", "대전광역시 대덕구 오정동 103-18", 36.353716,127.411533,"042-633-3017","NULL","NULL",false);

    }
}