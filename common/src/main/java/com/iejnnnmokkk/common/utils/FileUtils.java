package com.iejnnnmokkk.common.utils;

import android.content.Context;
import android.os.Environment;

import java.io.File;

/**
 * @author Sun
 * @Demo class FileUtils
 * @Description TODO
 * @date 2024/12/10 11:00
 */
public class FileUtils {

    /**
     * 获取应用的外部存储目录（例如：/storage/emulated/0/Android/data/your.package.name/files）
     *
     * @param context 上下文
     * @return 外部存储目录的 File 对象，或 null 如果不可用
     */
    public static File getExternalFilesDir(Context context) {
        if (context == null) {
            return null;
        }
        return context.getExternalFilesDir(null);
    }

    /**
     * 获取应用的外部缓存目录（例如：/storage/emulated/0/Android/data/your.package.name/cache）
     *
     * @param context 上下文
     * @return 外部缓存目录的 File 对象，或 null 如果不可用
     */
    public static File getExternalCacheDir(Context context) {
        if (context == null) {
            return null;
        }
        return context.getExternalCacheDir();
    }

    /**
     * 获取应用的内部存储目录（例如：/data/user/0/your.package.name/files）
     *
     * @param context 上下文
     * @return 内部存储目录的 File 对象，或 null 如果 context 为 null
     */
    public static File getInternalFilesDir(Context context) {
        if (context == null) {
            return null;
        }
        return context.getFilesDir();
    }

    /**
     * 获取应用的内部缓存目录（例如：/data/user/0/your.package.name/cache）
     *
     * @param context 上下文
     * @return 内部缓存目录的 File 对象，或 null 如果 context 为 null
     */
    public static File getInternalCacheDir(Context context) {
        if (context == null) {
            return null;
        }
        return context.getCacheDir();
    }

    /**
     * 获取公共外部存储目录（例如：/storage/emulated/0）
     *
     * @return 公共外部存储目录的 File 对象，或 null 如果外部存储不可用
     */
    public static File getExternalStorageDirectory() {
        if (!isExternalStorageWritable()) {
            return null;
        }
        return Environment.getExternalStorageDirectory();
    }

    /**
     * 创建目录
     *
     * @param dirPath 目录路径
     * @return 如果成功创建或已经存在则返回 true，否则返回 false
     */
    public static boolean createDirectory(String dirPath) {
        if (dirPath == null || dirPath.isEmpty()) {
            return false;
        }
        File dir = new File(dirPath);
        if (!dir.exists()) {
            try {
                return dir.mkdirs();
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    /**
     * 删除目录及其子目录和文件
     *
     * @param dir 目标目录
     * @return 删除是否成功
     */
    public static boolean deleteDirectory(File dir) {
        if (dir == null || !dir.exists()) {
            return false;
        }
        if (dir.isDirectory()) {
            String[] children = dir.list();
            if (children != null) {
                for (String child : children) {
                    boolean success = deleteDirectory(new File(dir, child));
                    if (!success) {
                        return false;
                    }
                }
            }
        }
        return dir.delete();
    }

    /**
     * 获取应用专属的外部文件夹路径，如果不存在则创建
     *
     * @param context    上下文
     * @param folderName 文件夹名称
     * @return 创建的文件夹的 File 对象，或 null 如果创建失败
     */
    public static File getOrCreateAppExternalFolder(Context context, String folderName) {
        if (context == null || folderName == null || folderName.isEmpty()) {
            return null;
        }
        File folder = new File(getExternalFilesDir(context), folderName);
        if (!folder.exists()) {
            boolean created = folder.mkdirs();
            if (!created) {
                return null;
            }
        }
        return folder;
    }

    /**
     * 判断外部存储是否可用
     *
     * @return 外部存储是否可用
     */
    public static boolean isExternalStorageWritable() {
        return Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState());
    }

    /**
     * 判断外部存储是否可读取
     *
     * @return 外部存储是否可读取
     */
    public static boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        return Environment.MEDIA_MOUNTED.equals(state) || Environment.MEDIA_MOUNTED_READ_ONLY.equals(state);
    }
}
