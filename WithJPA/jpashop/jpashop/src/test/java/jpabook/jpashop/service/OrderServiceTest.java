package jpabook.jpashop.service;

import jpabook.jpashop.domain.*;
import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.exception.NotEnoughStockException;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class OrderServiceTest {

    @Autowired
    EntityManager em;

    @Autowired
    OrderService orderService;

    @Test
    public void 상품주문() throws Exception {
        int 초기수량 = 50;
        int 주문수량 = 30;
        int 최종수량 = 초기수량 - 주문수량;
        //given
        Member member = createMember();

        Item item = createItem(초기수량);

        //when
        Long orderId = orderService.order(member.getId(), item.getId(), 주문수량);
        Order findOrder = orderService.findOne(orderId);

        //then
        assertEquals("상품 주문시 상태는 ORDER", OrderStatus.ORDER, findOrder.getStatus());
        assertEquals("주문 금액", findOrder.getTotalPrice(), 주문수량 * item.getPrice());
        assertEquals("주문 후 남아있는 아이템의 수량", item.getStockQuantity(), 최종수량);
    }

    @Test
    public void 주문취소() throws Exception {
        int 초기수량 = 50;
        int 주문수량 = 30;
        //given
        Member member = createMember();

        Item item = createItem(초기수량);

        Long orderId = orderService.order(member.getId(), item.getId(), 주문수량);

        //when
        orderService.cancel(orderId);

        //then
        Order findOrder = orderService.findOne(orderId);
        assertEquals("상품 취소시 상태는 CANCEL", OrderStatus.CANCEL, findOrder.getStatus());

        //상품 취소 시 재고가 복구되어야 한다.
        assertThat(item.getStockQuantity()).isEqualTo(초기수량);

    }

    @Test
    public void 상품주문_재고수량초과() throws Exception {
        //given
        int 초기수량 = 50;
        int 주문수량 = 100;
        //given
        Member member = createMember();

        //when
        Item item = createItem(초기수량);

        //then
        assertThrows(NotEnoughStockException.class, () -> orderService.order(member.getId(), item.getId(), 주문수량));
    }

    private Member createMember() {
        Member member = new Member();
        member.setName("회원1");
        member.setAddress(new Address("서울", "세종대로 1길", "12323"));
        em.persist(member);
        return member;
    }

    private Item createItem(int 초기수량) {
        Item item = new Book();
        item.setName("위인전");
        item.setPrice(30000);
        item.setStockQuantity(초기수량);
        em.persist(item);
        return item;
    }
}