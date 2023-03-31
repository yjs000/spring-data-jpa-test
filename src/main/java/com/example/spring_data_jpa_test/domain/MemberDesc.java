package com.example.spring_data_jpa_test.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class MemberDesc {

    @Id
    @Column(name = "MEMBER_ID")
    private Long memberId;

    private String desc;

    @OneToOne
    @JoinColumn
    private Member member;
}
