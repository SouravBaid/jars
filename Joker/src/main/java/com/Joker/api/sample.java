package com.Joker.api;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class sample {

	public  String data;
	
	private static final Logger logger = (Logger) LoggerFactory.getLogger("logger");

	public static class SampleBuilder {
		private SqlSession session = null;

		public SampleBuilder(SqlSession session) {
			super();
			this.session = session;
		}

		public String getData(String data) {

			System.out.println("****INSIDE-GET-NAME****" + data);
			logger.info("------INSIDE-GET-NAME---------",data);
			String nme = null;

			try {
					
				System.out.println("****INSIDE-GET-NME****" + data);
				// nme = (String) session.selectOne("PromMapper.getName", names);
				 logger.info("------INSIDE-GET-NAME--{}-------",nme);
				System.out.println("record retrieved successfully");

			} catch (Exception e) {
				e.printStackTrace();
			}
			return data;
		}
	}
}
