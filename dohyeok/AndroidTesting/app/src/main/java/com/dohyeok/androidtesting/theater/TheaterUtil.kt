package com.dohyeok.androidtesting.theater

object TheaterUtil {

    /**요구사항
     * - 만 12세 이하 어린이용 티켓 가격 15달러
     * - 만 13~60세용 표준 티켓 가격 30달러. 월요일에는 이 연령대를 대상으로 표준 티켓 가격을 25달러로 할인
     * - 만 61세 이상용 노인 티켓 가격 20달러. 영화 관람자의 최대 연령을 만 100세로 가정
     * - -1 값은 사용자가 연령 분류에 속하지 않는 연령을 입력하는 경우 유효하지 않은 가격을 표시
     */
    fun ticketPrice(age: Int, isMonday: Boolean): Int {
        val price: Int =
            if (age <= 12) {
                15
            } else if (age <= 60) {
                if (isMonday) {
                    25
                } else {
                    30
                }
            } else if (age <= 100) {
                20
            } else {
                -1
            }
        return price
    }
}