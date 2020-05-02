//package com.Joker.service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.apache.ibatis.session.SqlSession;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import com.Joker.api.sample.SampleBuilder;
//
//
//
//
//public class jokerservice extends Baseservice {
//	private static final Logger logger = (Logger) LoggerFactory.getLogger("logger");
//	
//	public jokerservice() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//	
//	
//	public String getData(String data) {
//		String datas = null;
//		logger.info("-------SERVICE-----",data);
//		try {
//			SqlSession session = sqlSessionFactory.openSession(true);
//			logger.info("-------SERVICE-----",session);
//			SampleBuilder builder = new SampleBuilder(session);
//			datas = builder.getData(data);
//			logger.info("-------SERVICE-{}----",datas);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return datas;
//	}
//}