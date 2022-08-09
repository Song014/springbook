package com.springbook.ioc.injection;

import java.util.Map;

import org.springframework.context.annotation.EnableMBeanExport;

import lombok.Data;

@Data
@EnableMBeanExport
public class CollectionBean {
//   private List<String> addressList;
//   private Set<String> addressList;
	
	private Map<String,String> addressList;
//   private Properties addressList;
   
}