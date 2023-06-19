package com.fin.proj.support.model.service;

import java.util.ArrayList;

import com.fin.proj.common.model.vo.PageInfo;
import com.fin.proj.support.model.vo.Support;
import com.fin.proj.support.model.vo.SupportDetail;
import com.fin.proj.support.model.vo.SupportHistory;

public interface SupportService {

	int supportApply(Support s);

	int insertSupportDetail(SupportDetail supportDetail);

	ArrayList<Support> selectApplyListUser(int uNo);

	Support supportDetail(int supportNo);

	ArrayList<SupportDetail> supportUsageDetail(int supportNo);

	int getListCount();

	ArrayList<Support> selectSupportList(PageInfo pi);

	int getWListCount();

	ArrayList<Support> selectApplyList(PageInfo pi);

	int getDListCount(String devision);

	ArrayList<Support> applyDevision(PageInfo pi, String devision);

	int updateApplyStatus(Support s);

	int getEListCount();

	ArrayList<Support> selectEndSupportList(PageInfo pi);

	int getSeachListCount(String searchWord);

	ArrayList<Support> selectSearchListAdmin(PageInfo pi, String searchWord);

	int getSupporterListCount(int supportNo);

	ArrayList<SupportHistory> selectSupporterListEach(PageInfo pi, int supportNo);

	int getSupporterListAllCount();

	ArrayList<SupportHistory> selectSupporterList(PageInfo pi);

	int getMListCount(int uNo);

	ArrayList<SupportHistory> selectMySupportList(PageInfo pi, int uNo);

	int getSearchListCount(Support s);

	ArrayList<Support> selectApplySearchList(PageInfo pi, Support s);

	int insertSupporter(SupportHistory sh);






}
