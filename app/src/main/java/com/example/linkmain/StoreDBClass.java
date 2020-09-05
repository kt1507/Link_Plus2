package com.example.linkmain;

public class StoreDBClass {

    public StoreClass[] store = new StoreClass[100];

    //하드코딩
    public void storedbclass(){
            store[0] = new StoreClass("대일전기", "전기","대전광역시 대덕구 오정동 370-9", 36.349524, 127.414039, "042-633-0765", "NULL", "NULL", 0,0);
            store[1] = new StoreClass("LS산전","전기","대전광역시 대덕구 오정동 298-5", 36.354680,127.407600,"NULL","월-금 08:30~18:00 / 토 08:30~15:00","일요일",0,0);
            store[2] = new StoreClass("백제종합전기", "전기","대전광역시 대덕구 오정로 22", 36.349128,127.415073,"042-622-1670", "NULL","NULL",0,0);
            store[3] = new StoreClass("명일전기", "전기","대전광역시 대덕구 오정로 26", 36.350293,127.413880,"042-631-5894","월~토 08:00~19:00","일요일, 명절",6,0);
            store[4] = new StoreClass("상일전기", "전기","대전광역시 대덕구 오정동 103-18", 36.353716,127.411533,"042-633-3017","NULL","NULL",0,0);
            store[5] = new StoreClass("SJ종합상사", "공구","대전광역시 대덕구 오정로 9번길 2", 36.349102,127.414857,"042-284-0289","월~금 07:30~18:00 / 토 07:30~15:00","일요일",0,0);
            store[6] = new StoreClass("영신공구", "공구","대전광역시 대덕구 오정로 17", 36.349166,127.414195,"NULL","NULL","NULL",0,0);
            store[7] = new StoreClass("대선종합상사","공구","대전광역시 대덕구 오정로 19", 36.349378,127.413925,"042-624-8028","월~토 07:00~19:00","일요일",0,0);
            store[8] = new StoreClass("현대종합공구", "공구","대전광역시 대덕구 오정로 119번길", 36.355858,127.406221,"042-623-0909","월~토 07:00~19:00","일요일",1,0);
            store[9] = new StoreClass("동진공구철물", "공구","대전광역시 대덕구 오정동 292-11", 36.355298,127.406416,"042-621-1374","월~토 07:00~18:00","일요일",1,0);
            store[10] = new StoreClass("힐티대전기업","공구","대전광역시 대덕구 오정로 298-7번지", 36.354751,127.407293, "010-5406-0982","월~토 07:00~19:00","일요일",1,0);
            store[11] = new StoreClass("강산건재철물", "공구","대전광역시 대덕구 오정로 101", 36.354754,127.407496,"042-635-7765","월~토 : 07:00~18:00","일요일, 명절",5, 0);
            store[12] = new StoreClass("동우공구","공구","대전광역시 대덕구 오정동 323-5",36.353176,127.409247,"042-621-7455","NULL","NULL",0,0);
            store[13] = new StoreClass("두리상사", "공구","대전광역시 대덕구 오정동 299-9",36.354441,127.407750,"042-635-2933","월~토 07:00~18:00","일요일",1,0);
            store[14] = new StoreClass("번영공구백화점", "공구","대전광역시 대덕구 오정로 97",36.354202,127.407906,"042-626-0945","월~일 07:00~18:30","구정,신정",15,0);
            store[15] = new StoreClass("동한상사","공구","대전광역시 대덕구 오정동 338-7",36.351844,127.410948,"042-624-4349 / 010-3456-4349","월~토 06:30~19:30","일요일",1,0);
            store[16] = new StoreClass("금성종합상사", "공구","대전광역시 대덕구 오정동 287-5",36.351269,127.412470,"042-626-0975","NULL","NULL",0,0);
            store[17] = new StoreClass("대성종합기계상사","공구","대전광역시 대덕구 오정로 45",36.351156,127.411930,"042-637-0986","월~토 08:00~18:00","일요일",1,0);
            store[18] = new StoreClass("금강종합상사", "공구","대전광역시 대덕구 오정로 88", 36.353920,127.408853,"042-628-5315","NULL","NULL",0,0);
            store[19] = new StoreClass("경보상사", "공구","대전광역시 대덕구 오정로 27",36.349964,127.413610,"NULL","NULL","NULL",0,0);
            store[20] = new StoreClass("현대로프상사", "공구","대전광역시 대덕구 오정로 14",36.349424,127.414688,"042-634-4629","NULL","NULL",0,0);
            store[21] = new StoreClass("오정공구","공구","대전광역시 대덕구 오정로 57",36.351932,127.411006,"042-636-3477","월~토 07:00~19:00","일요일, 명절연휴",1,0);
            store[22] = new StoreClass("삼원공구", "공구","대전광역시 대덕구 오정로 64번길 8", 36.352339,127.410999,"042-621-7778","월~토 06:00~19:00","일요일",2,0);
            store[23] = new StoreClass("계약전동공구", "공구","대전광역시 대덕구 오정동 299-9",36.354431,127.407752,"042-631-8141","NULL","NULL",0,0);
            store[24] = new StoreClass("한양종합상사", "공구","대전광역시 대덕구 오정로 10", 36.349118,127.415014,"042-634-3309","NULL","NULL",0,0);
            store[25] = new StoreClass("신세계철물", "철물","대전광역시 대덕구 오정로 80",36.353553,127.409310,"NULL","NULL","NULL",0,0);
            store[26] = new StoreClass("금강스틸", "철공예","대덕구 오정로 9번길 2",36.348921,127.415021,"042-226-8000","월~금 08:00~18:00 / 토 08:00~15:00","일요일, 공휴일",0,0);
            store[27] = new StoreClass("명용접기", "철공예","대전광역시 대덕구 오정로 21", 36.349601,127.413819, "042-623-0940","NULL","NULL",0,0);
            store[28] = new StoreClass("후지육절기/저울","철공예","대전광역시 대덕구 오정동 299-13", 36.353918,127.408361,"042-631-7013","NULL", "NULL",0,0);
            store[29] = new StoreClass("광덕금속", "철공예","대전광역시 대덕구 오정동 338-7",36.351906,127.411002,"042-623-6061","NULL","NULL",0,0);
            store[30] = new StoreClass("신성철망", "철공예","대전광역시 대덕구 오정로 57",36.352355,127.410422,"042-627-7070","월~토 07:00~18:00","일요일",1,0);
            store[31] = new StoreClass("우신앵글진열장","진열대","대전광역시 대덕구 오정로 99번길 8",36.354630,127.407719,"042-622-7113","NULL","NULL",0,0);
            store[32] = new StoreClass("화신공조상사", "닥트", "대전광역시 대덕구 오정로 105", 36.354714,127.407204,"042-636-3488","월~금 07:20~18:20 / 토 07:20~16:00","일요일",1,0);
            store[33] = new StoreClass("신도공조닥트", "닥트", "대전광역시 대덕구 오정로 10",36.348880,127.415125,"NULL","NULL","NULL",0,0);
            store[34] = new StoreClass("제비표페인트","페인트","대전광역시 대덕구 오정로 24",36.349975,127.413764,"NULL","NULL","NULL",0,0);
            store[35] = new StoreClass("페인트마트","페인트","대전광역시 대덕구 오정로 28",36.350471,127.413578,"042-634-0478~9","06:30~19:00","명절",2,0);
            store[36] = new StoreClass("로하스산업","타일","대전광역시 대덕구 오정로 74",36.353241,127.409735,"042-626-9068","NULL","NULL",0,0);
            store[37] = new StoreClass("탑블랙세라믹","타일","대전광역시 대덕구 오정로 54",36.351948,127.411834,"042-628-1181","08:00~19:00","일요일",1,0);
            store[38] = new StoreClass("신혼지업사","장판","대전광역시 대덕구 오정동 338-9",36.352298,127.410581,"NULL","NULL","NULL",0,0);
            store[39] = new StoreClass("㈜다원하우징","장판","대전광역시 대덕구 오정로 28",36.350440,127.414290,"042-625-2337","07:00~18:30","일요일",1,0);
            store[40] = new StoreClass("맥스본드","포장/접착","대전광역시 대덕구 오정동 338-7",36.351844,127.410948,"042-628-4949","NULL","NULL",0,0);
            store[41] = new StoreClass("아주접착테프","포장/접착","대전광역시 대덕구 오정로 30",36.350537,127.413524,"042-635-4141","월~금 07:00~19:30 / 토 07:00~16:00","일요일",1,0);
            store[42] = new StoreClass("보성테이프","포장/접착","대전광역시 대덕구 오정로 14",36.349540,127.414772,"042-633-8989","월~토 06:30~19:00","일요일",1,0);
            store[43] = new StoreClass("선광자동밸브","파이프","NULL",36.349835,127.414082,"NULL","NULL","NULL",0,0);
            store[44] = new StoreClass("삼우스팀보일러","보일러","대전광역시 대덕구 오정로 77번길 16",36.353051,127.408939,"042-631-8811/624-8678","NULL","주말",1,0);
            store[45] = new StoreClass("한빛가스상사(경동나비엔 대덕대리점)","보일러","대전광역시 오정로 78번길 2",36.353567,127.410088,"042-636-1144","월~토 08:00~18:00","일요일",1,0);
            store[46] = new StoreClass("남영LED","조명","대전광역시 대덕구 오정로 7",36.348720,127.415479,"042-632-5566","NULL","일요일",1,0);
            store[47] = new StoreClass("동아LED", "조명", "대전광역시 대덕구 오정로 5",36.348465,127.415759,"042-672-3316","월~토 07:40~18:30","일요일",1,0);
            store[48] = new StoreClass("동광전기조명","조명","대전광역시 대덕구 오정로 21",36.349777,127.413832,"042-628-2547~8","NULL","NULL",0,0);
            store[49] = new StoreClass("아리랑 전기조명","조명","대전광역시 대덕구 오정로 115",36.358567,127.406740,"042-623-0940","월~토 08:30~19:00 / 일 08:30~18:00","X",1,0);
            store[50] = new StoreClass("대경전기조명(플러스전기조명)","조명","대전광역시 대덕구 오정로 107 1층",36.355136,127.406996,"042-628-0267","월~토 07:00~19:00","일요일, 명절",1,0);
            store[51] = new StoreClass("형제종합전기조명","조명","대전광역시 대덕구 오정로 99번길 7",36.354535,127.407811,"042-488-2316","월~금 07:20~18:30 / 토 07:20~15:30","일요일",1,0);
            store[52] = new StoreClass("네츄럴 라이팅","조명","대전광역시 대덕구 오정동 324-8번지",36.3527441,127.409643,"010-6740-3977","월~토 07:00~18:00","일요일",1,0);
            store[53] = new StoreClass("이엘조명","조명","대전광역시 대덕구 오정로 57",36.352043,127.410905,"042-627-4788","월~토 07:00~20:00","일요일",1,0);
            store[54] = new StoreClass("동양전기조명","조명","대전광역시 대덕구 오정로 31",36.350364,127.413069,"042-639-8985","월~일 07:30~19:00","X",1,0);
            store[55] = new StoreClass("조명랜드","조명","대전광역시 대덕구 대전로 1031",36.346700,127.417263,"042-673-7612","월~금 08:30~18:00 / 토 08:30~16:00","일요일",0,0);
            store[56] = new StoreClass("KD전기조명","조명","대전광역시 대덕구 오정로 99번길 8",36.354751,127.407518,"042-638-5652","월~토 07:30~18:30","일요일",1,0);
            store[57] = new StoreClass("우주전기조명","조명", "대전광역시 대덕구 오정로 71",36.353073, 127.410024, "042-636-3344","월~토 07:30~18:30","일요일",10,0);
            store[58] = new StoreClass("럭키산업안전","안전용품","대전광역시 대덕구 오정로 12",36.349044,127.414978,"042-624-5759","NULL","NULL",0,0);
            store[59] = new StoreClass("양지타이어","자동차용품","대전광역시 대덕구 오정로 10",36.348799,127.415232,"042-634-5109","NULL","NULL",0,0);
            store[60] = new StoreClass("영락인쇄","간판","대전광역시 대덕구 오정로 22",36.349729,127.414080,"042-631-2222","NULL","NULL",0,0);
            store[61] = new StoreClass("중부도장","간판","NULL",36.350309,127.413466,"NULL","NULL","NULL",0,0);
            store[62] = new StoreClass("미래사","간판", "대전광역시 대덕구 오정로 12", 36.349259,127.414920,"042-636-8168","월~토 08:30~18:00","일요일, 공휴일", 1,0);
            store[63] = new StoreClass("신성산업공사", "운반기기", "대전광역시 대덕구 오정로 86", 36.353894,127.408893,"042-628-8944","NULL","NULL",0,0);
            store[64] = new StoreClass("우신천막사","천막","대전광역시 대덕구 오정로 125",36.356093,127.405613,"042-631-7416","월~금 08:30~17:30 / 토 08:30~15:00","일요일",1,0);
            store[65] = new StoreClass("대한천막공사","천막","대전광역시 대덕구 오정동 87-13",36.354104,127.408950,"042-633-4524/631-8009","NULL","NULL",0,0);
            store[66] = new StoreClass("신창천막사","천막","대전광역시 대덕구 오정로 24번길 5",36.350235,127.414021,"042-256-5870","월~토 08:00~19:00","일요일",1,0);
            store[67] = new StoreClass("광명전기공조","모터펌프","대전광역시 대덕구 오정동 324-8",36.352763,127.409635,"011-409-3431","월~토 07:30~19:00 / 일 07:30~14:00","X",1,0);
    }
}