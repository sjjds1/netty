package it.shanjj.netty4.definedProtocol;

import java.util.List;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import it.shanjj.netty4.utils.ByteBufToBytes;
import it.shanjj.netty4.utils.ByteObjConverter;

public class PersonDecoder extends ByteToMessageDecoder {
	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
		ByteBufToBytes read = new ByteBufToBytes();
		Object obj = ByteObjConverter.ByteToObject(read.read(in));
		out.add(obj);
	}

}
