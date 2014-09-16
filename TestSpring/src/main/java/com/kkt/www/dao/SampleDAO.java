package com.kkt.www.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository("sampleDAO")
public class SampleDAO {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public List selectSampleList(Map parameter) throws Exception {
		return sqlSession.selectList("sampleDAO.selectSampleList", parameter);
	}	
	
}
