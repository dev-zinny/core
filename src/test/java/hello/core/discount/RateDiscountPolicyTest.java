package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다.") // junit 5부터 제공됨.
    void vip_o() {
        // given
        Member member = new Member(1L, "memberVIP", Grade.VIP);

        // when
        int discount = discountPolicy.discount(member, 10000);

        //then
        assertThat(discount).isEqualTo(1000); // static으로 import 하는 것이 좋음.
    }


    // 성공테스트도 중요하지만 실패 테스트도 만들어 봐야 함.
    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야 함.")
    void vip_x() {

        // given
        Member member = new Member(2L, "memberBasic", Grade.BASIC);

        // when
        int discount = discountPolicy.discount(member, 10000);

        //then
        assertThat(discount).isEqualTo(0);
    }


}