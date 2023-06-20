package com.fin.proj.volunteer.model.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;

import com.fin.proj.volunteer.model.vo.Volunteer;

@Mapper
public interface VolunteerDAO {

	int insertVolunteer(Volunteer v);

	int getVolunteerCount();

	ArrayList<Volunteer> selectVolunteerList(int i, RowBounds rowBounds);

	Volunteer selectVolunteer(int vNo);

	int updateVolunteer(Volunteer v);

	int deleteVolunteer(String vNo);

	int applyVolunteer(Volunteer v);

	int checkVolunteerApply(HashMap<String, Integer> map);

}
