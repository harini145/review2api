package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.SignUp;

import jakarta.transaction.Transactional;

public interface UserDetailsRepo extends JpaRepository<SignUp, Long> {
	@Query(value="select * from signupdetails where mobileno=:s or name=:sn",nativeQuery=true)
	public List<SignUp>getUserInfo(@Param("s")long id,@Param("sn")String name);
	@Modifying
	@Transactional
	@Query(value="delete from Servicedetails where registrationnumber=:s",nativeQuery=true)
	public int deleteUserInfo(@Param("s")String d);
	@Modifying
	@Transactional
	@Query(value="update signupdetails set password=?1 where password=?2",nativeQuery=true)
	public int updateUserInfo(String newid,String oldid);
}