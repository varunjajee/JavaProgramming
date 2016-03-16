package com.muks.IntrvAlgorithms.ReverseLargeFiles;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * -Created by mukthar.ahmed on 3/16/16.
 */

class ReverseLineReaderCore {
    private static final int BUFFER_SIZE = 8192;
    private final FileChannel fileChannel;
    private final String encoding;
    private long filePosition;
    private ByteBuffer byteBuffer;
    private int bufferPosition;
    private byte lastLineBreak = '\n';
    private ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();


    public ReverseLineReaderCore(File file, String encoding) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(file, "r");
        fileChannel = raf.getChannel();
        filePosition = raf.length();
        this.encoding = encoding;

        System.out.println("Initialising: [ FilePosition = " + filePosition
        +", BufferPosition=" + bufferPosition + " ]");
    }


    public String readLine() throws IOException {
        System.out.println("\n+ readLine()...");

        while (true) {

            if (bufferPosition < 0) {
                System.out.println("Start: [FilePosition=" + filePosition + ", BufferPosition=" + bufferPosition + "]");

                if (filePosition == 0) {
                    if (byteArrayOutputStream == null) {
                        return null;
                    }
                    String line = bufToString();
                    byteArrayOutputStream = null;
                    return line;
                }

                long start = Math.max(filePosition - BUFFER_SIZE, 0);
                long end = filePosition;
                long len = end - start;

                byteBuffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, start, len);
                bufferPosition = (int) len;
                filePosition = start;
            }

            while (bufferPosition-- > 0) {
                byte c = byteBuffer.get(bufferPosition);
                if (c == '\r' || c == '\n') {
                    if (c != lastLineBreak) {
                        lastLineBreak = c;
                        continue;
                    }
                    lastLineBreak = c;
                    return bufToString();
                }
                byteArrayOutputStream.write(c);
            }
        }
    }

    private String bufToString() throws UnsupportedEncodingException {
        if (byteArrayOutputStream.size() == 0) {
            return "";
        }

        byte[] bytes = byteArrayOutputStream.toByteArray();
        for (int i = 0; i < bytes.length / 2; i++) {
            byte t = bytes[i];
            bytes[i] = bytes[bytes.length - i - 1];
            bytes[bytes.length - i - 1] = t;
        }

        byteArrayOutputStream.reset();
        return new String(bytes, encoding);
    }

}
