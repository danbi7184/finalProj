package com.fin.proj.member.model.service;

import com.fin.proj.member.model.vo.Member;

public interface MemberService {

	Member login(Member m);

	int insertUser(Member m);

	int checkId(String uId);

	int checkNickName(String uNickName);

}
