package hello.core.discount;

import hello.core.member.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RateDiscountPolicyTest {
    MemberRepository memberRepository = new MemoryMemberRepository();
    DiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 정률 할인 정책이 적용돼야 한다.")
    void vip_O() {
        //given
        Member member = new Member(1L, "VIP", Grade.VIP);
        memberRepository.save(member);

        //when
        int discountPrice = discountPolicy.discount(memberRepository.findById(1L), 1000);

        //then
        assertThat(discountPrice).isEqualTo(100);
    }

    @Test
    @DisplayName("VIP는 정률 할인 정책이 적용돼지 않아야 한다.")
    void vip_X() {
        //given
        Member member = new Member(2L, "BASIC", Grade.BASIC);
        memberRepository.save(member);

        //when
        int discountPrice = discountPolicy.discount(memberRepository.findById(2L), 1000);

        //then
        assertThat(discountPrice).isEqualTo(0);
    }
}