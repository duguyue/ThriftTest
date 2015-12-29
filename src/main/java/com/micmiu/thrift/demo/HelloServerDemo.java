
    /**  
    * @Title: HelloServerDemo.java
    * @Package com.micmiu.thrift.demo
    * @Description: TODO(用一句话描述该文件做什么)
    * @author LinDL
    * @Email  lindl@maizuo.com
    * @date 2015-12-15
    * @version V1.0  
    */
    
package com.micmiu.thrift.demo;

import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;


    /**
 * @ClassName: HelloServerDemo
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author LinDL
 * @Email  lindl@maizuo.com
 * @date 2015-12-15
 *
 */

public class HelloServerDemo {
	public static final int SERVER_PORT = 8090;
 
	public void startServer() {
		try {
			System.out.println("HelloWorld TSimpleServer start ....");
 
			TProcessor tprocessor = new HelloWorldService.Processor<
			HelloWorldService.Iface>(
					new HelloWorldImpl());
			// HelloWorldService.Processor&lt;HelloWorldService.Iface&gt; tprocessor =
			// new HelloWorldService.Processor&lt;HelloWorldService.Iface&gt;(
			// new HelloWorldImpl());
 
			// 简单的单线程服务模型，一般用于测试
			TServerSocket serverTransport = new TServerSocket(SERVER_PORT);
			TServer.Args tArgs = new TServer.Args(serverTransport);
			tArgs.processor(tprocessor);
			tArgs.protocolFactory(new TBinaryProtocol.Factory());
			// tArgs.protocolFactory(new TCompactProtocol.Factory());
			// tArgs.protocolFactory(new TJSONProtocol.Factory());
			TServer server = new TSimpleServer(tArgs);
			server.serve();
 
		} catch (Exception e) {
			System.out.println("Server start error!!!");
			e.printStackTrace();
		}
	}
 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HelloServerDemo server = new HelloServerDemo();
		server.startServer();
	}
 
}