package com.springbook.ioc.injection;

import java.util.Iterator;
import java.util.Map;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectionBeanClient {

   public static void main(String[] args) {
      // TODO Auto-generated method stub
	      AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
	      
	      CollectionBean bean = (CollectionBean)factory.getBean("collectionBean");
//      List<String> addressList = bean.getAddressList();
//      Set<String> addressList = bean.getAddressList();
      

//      for(String address : addressList) {
//         System.out.println(address);
//      }
      
		Map<String, String> addressList = bean.getAddressList();
		
		Iterator<String> keys = addressList.keySet().iterator();
		while( keys.hasNext() ){
		   String key = keys.next();
		   System.out.println( String.format("키 : %s, 값 : %s", key, addressList.get(key)) );
		}
      
//      Properties addressList = bean.getAddressList();
//	    
//      for(String key : addressList.stringPropertyNames()) {
//    	  System.out.println(key+":"+addressList.get(key));
//    	  
//      }

   }

}