package com.example.spring_data_jpa_test.repository;

import com.example.spring_data_jpa_test.domain.Member;
import com.example.spring_data_jpa_test.domain.MemberDesc;
import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@DataJpaTest
class MemberRepositoryTest {

    @Autowired
    MemberDescRepository memberDescRepository;

    @Autowired
    MemberRepository memberRepository;

    final String MEMBER1_DESC = "my description";


    // =============== 1 ===============
    public Member saveMember1() {
        Member member = new Member();
        memberRepository.save(member);
        return member;
    }

    //TODO : spring data jpa JOIN관계 저장 검색
    public MemberDesc saveMemberDesc1(Member member) {
        MemberDesc desc = new MemberDesc();
        desc.setMemberId(member.getMemberId());
        desc.setDesc(MEMBER1_DESC);
        memberDescRepository.save(desc);
        return desc;
    }

    @Test
    public void findMember() {
        Member member1 = saveMember1();
        Member result= memberRepository.findById(member1.getMemberId()).get();
        Assertions.assertThat(result == member1).isEqualTo(true);
    }

    @Test
    public void findMemberDesc() {
        Member member1 = saveMember1();
        MemberDesc memberDesc = saveMemberDesc1(member1);

        MemberDesc result= memberDescRepository.findById(memberDesc.getMemberId()).get();
        Assertions.assertThat(result == memberDesc).isEqualTo(true);
    }

    @Test
    void findAllMemberDesc() {
        Member member1 = saveMember1();
        MemberDesc memberDesc = saveMemberDesc1(member1);

        List<MemberDesc> all = memberDescRepository.findAll();
        Assertions.assertThat(all.size()).isEqualTo(1);

    }

    @Test
    public void findAllMember() {
        saveMember1();

        //when
        List<Member> memberList = memberRepository.findAll();
        Assertions.assertThat(memberList.size()).isEqualTo(1);
    }


//    @Test
//    public void findAllMemberWithDesc() {
//        Member member1 = saveMember1();
//        MemberDesc memberDesc = saveMemberDesc1(member1);
//        List<Member> memberList = memberRepository.findAll();
//
//        Assertions.assertThat(memberList.get(0).getDesc()).isEqualTo(MEMBER1_DESC);
//    }

    // ============= 1 =================

    /**
     * 1. Member에서 OneToOne Eager로 JOIN하면 JOIN되지 않음 Member만 select
     * 2. 반대로? => 마찬가지로 MemberDesc만 select
     * 3. 양방향 (MemberDesc주)
     */

    // ========= 2 ================
    @Test
    void findAllMemberWithDesc_2() {
        Member member1 = saveMember1();
        MemberDesc memberDesc = saveMemberDesc1(member1);

        List<MemberDesc> descList = memberDescRepository.findAll();
        System.out.println(descList.toString());
    }
    // ========= 2 ================

    @Test
    void findAllMemberWithDesc_3() {
        Member member1 = saveMember1();
        MemberDesc memberDesc = saveMemberDesc1(member1);

        List<MemberDesc> descList = memberDescRepository.findAll();
        System.out.println(descList.toString());

        List<Member> memberList = memberRepository.findAll();
        System.out.println(memberList.toString());
    }
}