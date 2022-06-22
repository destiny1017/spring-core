package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    DiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10%할인이 적용되어야한다.")
    public void vip_o () {
        Member memberVIP = new Member(1L, "memberVIP", Grade.VIP);

        int discount = discountPolicy.discount(memberVIP, 10000);

        Assertions.assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야한다.")
    public void vip_x() {
        Member memberBASIC = new Member(2L, "memberBASIC", Grade.BASIC);

        int discount = discountPolicy.discount(memberBASIC, 10000);

        Assertions.assertThat(discount).isEqualTo(1000);
    }

}