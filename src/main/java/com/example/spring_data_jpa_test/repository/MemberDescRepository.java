package com.example.spring_data_jpa_test.repository;

import com.example.spring_data_jpa_test.domain.Member;
import com.example.spring_data_jpa_test.domain.MemberDesc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MemberDescRepository extends JpaRepository<MemberDesc, Long>, JpaSpecificationExecutor<MemberDesc> {
}
