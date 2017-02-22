package it.shanjj.netty4.protocolMore;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BusinessHandler extends ChannelInboundHandlerAdapter {
	private Logger	logger	= LoggerFactory.getLogger(BusinessHandler.class);

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		Person person = (Person) msg;
		System.out.println("BusinessHandler read msg from client :" + person);
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		ctx.flush();
	}
}