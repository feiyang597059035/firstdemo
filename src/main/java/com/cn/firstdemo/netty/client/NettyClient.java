package com.cn.firstdemo.netty.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * netty客户端 . <br>
 * 
 * @author hkb
 */
public class NettyClient {

    /**
     * 主机
     */
    private String host;

    /**
     * 端口号
     */
    private int port;

    private Channel channe = null;

    /**
     * 构造函数
     * 
     * @param host
     * @param port
     */
    public NettyClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    /**
     * 连接方法
     */
    public void connect1() {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group).channel(NioSocketChannel.class);
            bootstrap.option(ChannelOption.TCP_NODELAY, true);
            // bootstrap.option(ChannelOption.SO_KEEPALIVE, true);
            bootstrap.handler(new NettyClientInitializer());
            Channel channel = bootstrap.connect(host, port).sync().channel();
            // 发送json字符串
            String msg = "{\"name\":\"admin\",\"age\":27}\n";
            channel.writeAndFlush(msg);
            channel.closeFuture().sync();

        } catch (Exception e) {
            System.out.print(e.getMessage());
            e.printStackTrace();

        } finally {
            group.shutdownGracefully();
        }
    }

    /**
     * 连接方法d
     */
    public Channel connect() {
        Channel channel = null;
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group).channel(NioSocketChannel.class);
            bootstrap.option(ChannelOption.TCP_NODELAY, true);
            // bootstrap.option(ChannelOption.SO_KEEPALIVE, true);
            bootstrap.handler(new NettyClientInitializer());
            channel = bootstrap.connect(host, port).sync().channel();
            /*  // 发送json字符串
            String msg = "{\"name\":\"admin\",\"age\":27}\n";
            channel.writeAndFlush(msg);
            channel.closeFuture().sync();*/

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully();
        }
        return channel;
    }

    public void sendMessage(Channel channel) {
        // 发送json字符串
        String msg = "{\"name\":\"admin\",\"age\":27}\n";
        channel.writeAndFlush(msg);
        try {
            channel.closeFuture().sync();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    /**
     * 测试入口
     * 
     * @param args
     */
    public static void main(String[] args) {
        String host = "127.0.0.1";
        int port = 11111;
        NettyClient nettyClient = new NettyClient(host, port);
        nettyClient.connect1();
       /* Channel channel = nettyClient.connect();
        nettyClient.sendMessage(channel);*/

    }

}
