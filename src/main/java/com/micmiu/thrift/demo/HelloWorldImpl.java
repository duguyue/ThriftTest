/**  
 * @Title: HelloWorldImpl.java
 * @Package com.micmiu.thrift.demo
 * @Description: TODO(用一句话描述该文件做什么)
 * @author LinDL
 * @Email  lindl@maizuo.com
 * @date 2015-12-15
 * @version V1.0  
 */

package com.micmiu.thrift.demo;

import org.apache.thrift.TException;

/**
 * @ClassName: HelloWorldImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author LinDL
 * @Email lindl@maizuo.com
 * @date 2015-12-15
 * 
 */

public class HelloWorldImpl implements HelloWorldService.Iface {

	public HelloWorldImpl() {
	}

	@Override
	public String sayHello(String username) throws TException {
		return "Hi," + username + " welcome to my blog www.micmiu.com";
	}

}