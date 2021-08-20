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
        Long memeberId = 1L;
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(memeberId, "memberA", Grade.VIP);
        memberService.join(member);

        OrderService orderService = new OrderServiceImpl();
        Order order = orderService.createOrder(member.getId(), "사과", 1500);
        System.out.println(order.toString());
    }
}
