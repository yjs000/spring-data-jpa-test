package com.example.spring_data_jpa_test.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "MEMBER")
@SequenceGenerator(
        name = "HIBERNATE_SEQUENCE",
        sequenceName = "MEMBER_SEQ",
        initialValue = 1, allocationSize = 1
)
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long memberId;

    @NotNull
    private String name;

    @OneToOne(mappedBy = "member")
    private MemberDesc desc;
}
