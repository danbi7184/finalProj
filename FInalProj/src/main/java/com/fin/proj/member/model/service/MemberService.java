package com.fin.proj.member.model.service;

import java.util.HashMap;

import com.fin.proj.member.model.vo.Member;

public interface MemberService {

	Member login(Member m);

	int insertUser(Member m);

	int checkId(String uId);

	int checkNickName(String uNickName);
	
	int updateMyInfo(Member m);

	int deleteUser(String uId);

	int checkNickNameModify(Member m);

	int updatePwd(HashMap<String, String> map);

	String selectPwd(String uId);

	int searchEmailUser(HashMap<String, String> map);

	Member searchUser(Member m);

	int searchEmailUser2(HashMap<String, String> map);

	Member searchUserPwd(Member m);

}
