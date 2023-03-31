package com.example.spring_data_jpa_test.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Data
public class MemberDesc {

    @Id
    @Column(name = "MEMBER_ID")
    private Long memberId;

    private String desc;


}
