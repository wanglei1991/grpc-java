package com.my.grpc;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import com.my.grpc.protobuf.Data;
import com.my.grpc.service.BaseServiceGrpc;
import io.grpc.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author sunbo
 * @date 2021/4/15 15:07
 */
public class GrpcClient {
    ManagedChannel channel;
    public BaseServiceGrpc.BaseServiceBlockingStub blockingStub;

    final  ThreadPoolExecutor  grpcExecutor ;

    public GrpcClient() {
        grpcExecutor = new ThreadPoolExecutor(Runtime.getRuntime()
                .availableProcessors() * 8,
                Runtime.getRuntime().availableProcessors() * 8, 10L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(10000),
                new ThreadFactoryBuilder()
                        .setDaemon(true)
                        .setNameFormat("my-grpc-client-executor-%d")
                        .build());
    }

    public void connectToServer(String serverIp, int serverPort){
        ManagedChannelBuilder<?> o = ManagedChannelBuilder.forAddress(serverIp, serverPort)
                .executor(grpcExecutor)
                .compressorRegistry(CompressorRegistry.getDefaultInstance())
                .decompressorRegistry(DecompressorRegistry.getDefaultInstance())
                .maxInboundMessageSize(10 * 1024 * 1024)
                .keepAliveTime(6 * 60 * 1000, TimeUnit.MILLISECONDS)
                .usePlaintext();
        ManagedChannelBuilder builder = ManagedChannelBuilder.forAddress(serverIp, serverPort).
                maxInboundMessageSize(2147483647).
                usePlaintext();
        this.channel = builder.intercept(new ClientInterceptor[]{}).build();
        blockingStub = BaseServiceGrpc.newBlockingStub(channel);

    }

    public Data.User getUser(String userName) throws InvalidProtocolBufferException {
        Data.Request request= Data.Request.newBuilder()
                .setType("user")
                .setName(userName)
                .build();
        Data.Response response = this.blockingStub.method(request);
        System.out.println(String.format("code:%s,message:%s",response.getCode(),response.getMessage()));
        Data.User user =null;
        if("200".equals(response.getCode())) {
            user = Data.User.parseFrom(response.getData());
            System.out.println(String.format("姓名：%s，地址：%s", user.getName(), user.getAddress()));
        }
        return user;
    }

    public List<Data.GirFriend> getFriends(String userName) throws InvalidProtocolBufferException {
        Data.Request request= Data.Request.newBuilder()
                .setType("friends")
                .setName(userName)
                .build();
        Data.ListResponse listResponse = this.blockingStub.listMethod(request);
        System.out.println(String.format("code:%s,message:%s",listResponse.getCode(),listResponse.getMessage()));
        List<Data.GirFriend> girFriends =new ArrayList<>();
        if("200".equals(listResponse.getCode())) {
            for (ByteString bytes : listResponse.getDataList()) {
                Data.GirFriend girFriend = Data.GirFriend.parseFrom(bytes);
                girFriends.add(girFriend);
            }
        }
        return girFriends;
    }


    public static void main(String[] args) throws InvalidProtocolBufferException {
        GrpcClient grpcClient = new GrpcClient();
        grpcClient.connectToServer("127.0.0.1", 8901);
        Data.User user = grpcClient.getUser("张三");
        List<Data.GirFriend> friends = grpcClient.getFriends("张三");
        for (int i = 0; i <friends.size() ; i++) {
            System.out.println(String.format("第%s个女朋友：%s,住址：%s",i+1, friends.get(i).getName(),friends.get(i).getAddress()));
        }
    }

}
