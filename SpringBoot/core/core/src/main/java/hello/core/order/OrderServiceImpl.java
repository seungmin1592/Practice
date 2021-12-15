package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private DiscountPolicy discountPolicy;

    @Override
    public Order createOrder(Long memberid, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberid);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberid, itemName, itemPrice, discountPrice);
    }
}
