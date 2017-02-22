package it.shanjj.netty4.protocolMore;

import java.util.List;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import it.shanjj.netty4.utils.ByteBufToBytes;
import it.shanjj.netty4.utils.ByteObjConverter;

public class PersonDecoder extends ByteToMessageDecoder {
	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
		byte n = "n".getBytes()[0];
		byte p = in.readByte();
		in.resetReaderIndex();
		if (n != p) {
			// 把读取的起始位置重置
			ByteBufToBytes reader = new ByteBufToBytes();
			out.add(ByteObjConverter.byteToObject(reader.read(in)));
		} else {
			// 执行其它的decode
			ctx.fireChannelRead(in);
		}
	}
}
