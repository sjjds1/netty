package it.shanjj.netty4.protocolMore;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import it.shanjj.netty4.utils.ByteObjConverter;

public class PersonEncoder extends MessageToByteEncoder<Person>  {

	@Override
	protected void encode(ChannelHandlerContext ctx, Person msg, ByteBuf out) throws Exception {
		out.writeBytes(ByteObjConverter.objectToByte(msg));
	}
}
