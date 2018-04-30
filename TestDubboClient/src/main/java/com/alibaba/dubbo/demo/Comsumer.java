//package com.alibaba.dubbo.demo;
//
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import com.alibaba.dubbo.demo.DemoService;
//
///**
// * Hello world!
// *
// */
//public class Comsumer {
//    public static void main( String[] args ) {
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
//                new String[]{"dubbo-demo-consumer.xml"});
//        context.start();
//        // obtain proxy object for remote invocation
//        DemoService demoService = (DemoService) context.getBean("demoService");
//        // execute remote invocation
//        String hello = demoService.sayHello("world");
//        // show the result
//        System.out.println(hello);
//    }
//}
