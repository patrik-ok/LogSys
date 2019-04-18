package com.patrik.logsdk.tools;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import com.patrik.logsdk.log.LogUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;

public class FileUtils {

    /**
     * 获取默认存储路径
     *
     * @param context
     * @param groupDirectory  A相关
     * @param targetDirectory A相关下分类
     * @param fileName        xxx.txt
     * @param callerName
     * @return '.../levelDirectory/targetDirectory/fileName'
     */

    public static String getLogRealStoragePath(Context context, String groupDirectory, String targetDirectory, String fileName, String callerName) {
        String cachePath = getDiskCacheDirDefault(context, callerName);
        return cachePath + File.separator + groupDirectory + File.separator + targetDirectory + File.separator + fileName;
    }

    public static String getDiskCacheDirDefault(Context context, String callerName) {
        if (context == null) {
            String error = "mContext can not be null.Please init first before call " + callerName;
            throw new NullPointerException(error);
        }
        String cachePath;
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())
                || !Environment.isExternalStorageRemovable()) {
            cachePath = context.getExternalCacheDir().getPath();
        } else {
            cachePath = context.getCacheDir().getPath();
        }
        if (cachePath == null || "".equals(cachePath)) {
            return "";
        }
        return cachePath;
    }


    public static File getFile(File directory, String... names) {
        if (directory != null && directory.isDirectory()) {
            File file = directory;
            String[] var3 = names;
            int var4 = names.length;

            for (int var5 = 0; var5 < var4; ++var5) {
                String name = var3[var5];
                file = new File(file, name);
            }

            return file;
        } else {
            throw new IllegalArgumentException("file is null or file is not a directory");
        }
    }


    public static boolean copy(File src, File dst) {
        if (src != null && dst != null) {
            if (src.isDirectory()) {
                dst.mkdirs();
                File[] var18 = src.listFiles();
                if (var18 != null) {
                    File[] var19 = var18;
                    int var20 = var18.length;

                    for (int var22 = 0; var22 < var20; ++var22) {
                        File var23 = var19[var22];
                        if (var23 != null && !copy(var23, new File(dst, var23.getName()))) {
                            return false;
                        }
                    }
                }

                return true;
            } else {
                FileInputStream fi = null;
                FileOutputStream fo = null;

                boolean out;
                try {
                    fi = new FileInputStream(src);
                    fo = new FileOutputStream(dst);
                    FileChannel e = fi.getChannel();
                    FileChannel var21 = fo.getChannel();
                    e.transferTo(0L, e.size(), var21);
                    boolean e1 = true;
                    return e1;
                } catch (IOException var16) {
                    LogUtils.logError2File(var16,Thread.currentThread().getStackTrace());
                    out = false;
                } finally {
                    try {
                        if (fo != null) {
                            fo.close();
                        }

                        if (fi != null) {
                            fi.close();
                        }
                    } catch (IOException var15) {
                        LogUtils.logError2File(var15,Thread.currentThread().getStackTrace());
                    }

                }

                return out;
            }
        } else {
            return false;
        }
    }

    public static boolean move(File src, File dst) {
        return copy(src, dst) ? delete(src) : false;
    }

    public static byte[] readBytes(File file) {
        FileInputStream fi = null;

        Object var3;
        try {
            fi = new FileInputStream(file);
            byte[] e = IOUtils.toBytes(fi);
            return e;
        } catch (IOException var7) {
            LogUtils.logError2File(var7,Thread.currentThread().getStackTrace());
            var3 = null;
        } finally {
            IOUtils.closeQuietly(fi);
        }

        return (byte[]) var3;
    }

    public static boolean writeBytes(File file, byte[] bytes) {
        if (bytes == null) {
            return false;
        }
        FileOutputStream fo = null;

        boolean var4;
        try {
            fo = new FileOutputStream(file);
            fo.write(bytes);
            fo.close();
            boolean e = true;
            return e;
        } catch (IOException var8) {
            // TODO: 2019/4/18 log2DB
            Log.getStackTraceString(var8);
            var4 = false;
        } finally {
            IOUtils.closeQuietly(fo);
        }

        return var4;
    }

    public static String readString(File file) {
        byte[] bytes = readBytes(file);
        return bytes != null ? new String(bytes) : null;
    }

    public static boolean writeString(File file, String content) {
        if (content != null) {
            return writeBytes(file, content.getBytes());
        } else {
            LogUtils.logError2File("write string is null",Thread.currentThread().getStackTrace());
            return true;
        }
    }

    public static InputStream readStream(File file) {
        try {
            return new FileInputStream(file);
        } catch (IOException var2) {
            LogUtils.logError2File(var2,Thread.currentThread().getStackTrace());
            return null;
        }
    }

    public static boolean writeStream(File file, InputStream in) {
        FileOutputStream fos = null;

        boolean read;
        try {
            byte[] e = new byte[1024];
            fos = new FileOutputStream(file);

            int read1;
            while ((read1 = in.read(e)) >= 0) {
                fos.write(e, 0, read1);
            }

            boolean var5 = true;
            return var5;
        } catch (Exception var9) {
            LogUtils.logError2File(var9,Thread.currentThread().getStackTrace());
            read = false;
        } finally {
            IOUtils.closeQuietly(fos);
            IOUtils.closeQuietly(in);
        }

        return read;
    }

    public static boolean delete(File file) {
        if (file == null) {
            return true;
        } else {
            if (file.isDirectory()) {
                File[] subFiles = file.listFiles();
                if (subFiles != null) {
                    File[] var2 = subFiles;
                    int var3 = subFiles.length;

                    for (int var4 = 0; var4 < var3; ++var4) {
                        File f = var2[var4];
                        if (!delete(f)) {
                            return false;
                        }
                    }
                }
            }

            return file.delete();
        }
    }
}
