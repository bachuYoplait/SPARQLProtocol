package ProtocolTest.basic;

import java.nio.ByteBuffer;

public class MessagePacker {

    private int bufferSize = 1024;
    private static ByteBuffer buffer;
    private  int offset=0;


    public MessagePacker(){
        this.buffer=ByteBuffer.allocate(this.bufferSize);
        this.buffer.clear();
    }

    public MessagePacker(int size){
        this.buffer=ByteBuffer.allocate(size);
        this.buffer.clear();
    }

    public MessagePacker(byte[] byteArr){
        buffer=ByteBuffer.allocate(byteArr.length);
        buffer.clear();
        buffer=ByteBuffer.wrap(byteArr);
    }
}