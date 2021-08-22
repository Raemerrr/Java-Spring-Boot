package hello.core;

import hello.core.Order.Order;
import hello.core.Order.OrderService;
import hello.core.Order.OrderServiceImpl;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        Long memberId = 1L;
        MemberService memberService = appConfig.memberService();
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        OrderService orderService = appConfig.orderService();
        Order order = orderService.createOrder(member.getId(), "사과", 1500);
        System.out.println(order.toString());
    }
}
