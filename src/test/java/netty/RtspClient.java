package netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.DefaultHttpRequest;
import io.netty.handler.codec.http.DefaultHttpResponse;
import io.netty.handler.codec.rtsp.RtspDecoder;
import io.netty.handler.codec.rtsp.RtspEncoder;
import io.netty.handler.codec.rtsp.RtspHeaderNames;
import io.netty.handler.codec.rtsp.RtspMethods;
import io.netty.handler.codec.rtsp.RtspVersions;
import java.util.Objects;
import java.util.Scanner;

/**
 * @author wonseok.song
 * @since 2021-02-04
 */
public class RtspClient {

  public static class ClientHandler extends SimpleChannelInboundHandler<DefaultHttpResponse> {

    private String msg;

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
      ctx.flush();
    }
    protected void channelRead0(ChannelHandlerContext ctx, DefaultHttpResponse msg) throws Exception {
      setMsg(Objects.toString(msg, ""));
      ctx.close().sync();
    }

    public String getMsg() {
      return this.msg;
    }

    public void setMsg(String msg) {
      this.msg = msg;
    }
  }

  public static void main(String[] args) throws InterruptedException {

    EventLoopGroup workerGroup = new NioEventLoopGroup();
    ClientHandler handler = new ClientHandler();

    Bootstrap b = new Bootstrap();
    b.group(workerGroup);
    b.channel(NioSocketChannel.class);
    b.option(ChannelOption.AUTO_CLOSE, true);
    b.remoteAddress("wowzaec2demo.streamlock.net", 80);
    b.handler(new ChannelInitializer<SocketChannel>() {
      protected void initChannel(SocketChannel ch) {
        ChannelPipeline p = ch.pipeline();
        p.addLast("encoder", new RtspEncoder());
        p.addLast("decoder", new RtspDecoder());
        p.addLast(handler);
      }
    });

    Channel channel = b.connect().sync().channel();

    DefaultHttpRequest request = new DefaultHttpRequest(RtspVersions.RTSP_1_0, RtspMethods.GET_PARAMETER,"rtsp://wowzaec2demo.streamlock.net/vod/mp4:BigBuckBunny_115k.mov");
    request.headers().add(RtspHeaderNames.CSEQ, 1);
    request.headers().add(RtspHeaderNames.SESSION, "294");

    channel.writeAndFlush(request);
    channel.closeFuture().sync();

    //return message
    System.out.println(handler.getMsg());

    workerGroup.shutdownGracefully();
  }
}
