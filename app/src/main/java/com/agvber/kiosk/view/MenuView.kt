package com.agvber.kiosk.view

class MenuView {

    fun printMenu() {
        println(
            "[ SHAKESHACK MENU ]\n" +
                    "1. Burgers         | 앵거스 비프 통살을 다져만든 버거\n" +
                    "2. Forzen Custard  | 매장에서 신선하게 만드는 아이스크림\n" +
                    "3. Drinks          | 매장에서 직접 만드는 음료\n" +
                    "4. Beer            | 뉴욕 브루클린 브루어리에서 양조한 맥주\n" +
                    "0. 종료            | 프로그램 종료"
        )
    }

    fun printBurgersMenu() {
        println(
            "[ Burgers MENU ]\n" +
                    "1. ShackBurger   | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거\n" +
                    "2. SmokeShack    | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거\n" +
                    "3. Shroom Burger | W 9.4 | 몬스터 치즈와 체다 치즈로 속을 채운 베지테리안 버거\n" +
                    "3. Cheeseburger  | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거\n" +
                    "4. Hamburger     | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거\n" +
                    "0. 뒤로가기      | 뒤로가기"
        )
    }

    fun printFrozenCustardMenu() {
        println(
            "[ Frozen Custard MENU ]\n" +
                    "1. Strawberry Candy Ice cream   | W 5.9 | 상큼한 딸기 소르베&달콤한 딸기 아이스크림에 딸기 리본과 크리스탈 슈가, 팝핑 캔디가 톡톡\n" +
                    "2. Bonjour, Macaron             | W 6.9 | 부드러운 마스카포네 아이스크림과 마카롱, 초콜릿의 달콤한 만남!\n" +
                    "3. Peach Yogurt                 | W 3.4 | 상큼한 복숭아 요거트, 복숭아 샤베트에 복숭아 과육이 가득!\n" +
                    "3. Mint Chocolate BonBon        | W 2.9 | 민트 아이스크림에 달콤한 초콜릿칩과 봉봉 프레첼 볼이 가득!\n" +
                    "4. Mango Tango                  | W 3.4 | 부드럽고 상큼한 열대과일, 입 안 가득 진한 망고 향이 가득!\n" +
                    "0. 뒤로가기                      | 뒤로가기"
        )
    }
}