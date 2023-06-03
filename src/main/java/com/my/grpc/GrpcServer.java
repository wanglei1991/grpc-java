package com.my.grpc;


import com.my.grpc.service.GrpcService;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @author sunbo
 * @date 2021/4/15 10:38
 */
public class GrpcServer {

    static CountDownLatch countDownLatch=new CountDownLatch(1);
    static Server server;

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("grpc server start .......");
        //绑定端口
        //设置处理服务的类
        server = ServerBuilder.forPort(8901)
                .addService(new GrpcService())
                .build();
        server.start();
        System.out.println("grpc server started .......");
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            //项目被关闭触发
            stop();
            System.out.println("grpc server shutdown .......");
        }));
        countDownLatch.await();
    }

    public static void stop(){
        if(server!=null){
            server.shutdownNow();
        }
        countDownLatch.countDown();
    }
}
