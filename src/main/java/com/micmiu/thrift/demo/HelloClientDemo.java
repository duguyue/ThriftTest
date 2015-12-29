/**  
 * @Title: HelloClientDemo.java
 * @Package com.micmiu.thrift.demo
 * @Description: TODO(用一句话描述该文件做什么)
 * @author LinDL
 * @Email  lindl@maizuo.com
 * @date 2015-12-15
 * @version V1.0  
 */

package com.micmiu.thrift.demo;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

/**
 * @ClassName: HelloClientDemo
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author LinDL
 * @Email lindl@maizuo.com
 * @date 2015-12-15
 * 
 */

public class HelloClientDemo {

	public static final String SERVER_IP = "localhost";
	public static final int SERVER_PORT = 8080;
	public static final int TIMEOUT = 30000;

	/**
	 * 
	 * @param userName
	 */
	public void startClient(String userName) {
		TTransport transport = null;
		try {
			transport = new TSocket(SERVER_IP, SERVER_PORT, TIMEOUT);
			// 协议要和服务端一致
			TProtocol protocol = new TBinaryProtocol(transport);
			// TProtocol protocol = new TCompactProtocol(transport);
			// TProtocol protocol = new TJSONProtocol(transport);
			HelloWorldService.Client client = new HelloWorldService.Client(
					protocol);
			transport.open();
			String result = client.sayHello(userName);
			System.out.println("Thrify client result =: " + result);
		} catch (TTransportException e) {
			e.printStackTrace();
		} catch (TException e) {
			e.printStackTrace();
		} finally {
			if (null != transport) {
				transport.close();
			}
			
			
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HelloClientDemo client = new HelloClientDemo();
		client.startClient("Michael");

	}

}