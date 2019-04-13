package com.springbook.biz;

import java.util.*;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectionBeanClient {
	public static void main(String[] args) {
		AbstractApplicationContext factory =new GenericXmlApplicationContext("applicationContext.xml");
		
		CollectionBean bean = (CollectionBean) factory.getBean("collectionBean");
		Properties addressList = bean.getAddressList();
		
//		for(String address: addressList) {
//			System.out.println(address.toString());
//		}
		
		System.out.println(addressList.get("고길동"));
		System.out.println(addressList.get("마이콜"));
		
		factory.close();
	}
}
