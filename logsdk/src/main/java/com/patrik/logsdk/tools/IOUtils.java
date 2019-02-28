package com.patrik.logsdk.tools;

import com.patrik.logsdk.log.LogUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class IOUtils {
    private static final int DEFAULT_BUFFER_SIZE = 4096;

    public static long copy(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];

        long count;
        int n;
        for (count = 0L; -1 != (n = in.read(buffer)); count += (long) n) {
            out.write(buffer, 0, n);
        }

        return count;
    }

    public static byte[] toBytes(InputStream is) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        copy(is, bos);
        return bos.toByteArray();
    }

    public static InputStream toStream(byte[] bytes) {
        return new ByteArrayInputStream(bytes);
    }

    public static void closeQuietly(Closeable io) {
        try {
            if (io != null) {
                io.close();
            }
        } catch (IOException var2) {
            LogUtils.logError2File(var2);
        }

    }
}
