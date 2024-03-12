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

    fun printDrinksMenu() {
        println(
            "[ Drinks MENU ]\n" +
                    "1. Coke       | W 1.9 | 언제 어디서든 일상 속 마법 같은 짜릿한 순간을 함께 해온 코카-콜라. 130년 이상 변하지 않는 짜릿한 맛, 독창적인 디자인으로 대중문화의 아이콘으로 함께 해왔습니다.\n" +
                    "2. Sprite     | W 3.9 | 입안 가득 퍼지는 상쾌함과 시원함을 을 느낄 수 있는 스프라이트는 전세계 190개국 이상에서 판매되며 쿨하고 힙한 매력으로 사랑 받고 있습니다.\n" +
                    "3. Cider      | W 2.4 | 칠성사이다는 반세기 이상의 역사를 지닌 대한민국 No.1 오리지널 탄산음료입니다. 청량감이 느껴지는 탄산과 상큼한 레몬라임향이 특징입니다.\n" +
                    "3. Fanta      | W 2.9 | 환타의 상큼하고 재미있는 맛을 만나보세요. 환타 파인애플, 오렌지, 포도, 밀크소다와 같은 클래식 소프트 드링크가 모든 연령층에게 사랑받고 있습니다.\n" +
                    "4. Dr Pepper  | W 1.4 | 1885년 탄생한 닥터페퍼는 독특한 맛과 톡 쏘는 탄산으로 마실수록 빠져드는 경험을 선사합니다.\n" +
                    "0. 뒤로가기    | 뒤로가기"
        )
    }

    fun printBeerMenu() {
        println(
            "[ Beer MENU ]\n" +
                    "1. Asahi      | W 1.9 | 갓 따른 생맥주 같은 부드러운 거품과 목 넘김!\n" +
                    "2. Cass       | W 3.9 | 신나기만 했던 여름은? 바로 오늘!\n" +
                    "3. Kelly      | W 2.4 | 첫맛은 부드럽게 끝맛은 강렬하게\n" +
                    "3. Kirin      | W 2.9 | 라벨을 보면 맛이 보인다 보리 100%의 첫즙만 담은 단 하나의 맛\n" +
                    "4. TERRA      | W 1.4 | 이 맛이 청정라거다!\n" +
                    "0. 뒤로가기    | 뒤로가기"
        )
    }
}