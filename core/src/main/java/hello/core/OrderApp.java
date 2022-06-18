package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        //new Member(memberId, "memberA", Grade.VIP); 까지 쓰고 option+commend+V
        Member member = new Member(memberId, "memberA", Grade.VIP);// VIP 회원 한명 만듦
        memberService.join(member); // memberService 를 통해 member 객체를 메모리에 넣어놓고 디비에서 필요할 때 꺼내쓴다.

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        // soutv
        System.out.println("order = " + order);
        System.out.println("order.calculatePrice = " + order.calculatePrice());
        // 출력 결과
        // order = Order{memberId=1, itemName='itemA', itemPrice=10000, discountPrice=1000}



    }
}