package com.patrik.logsdk.callback;

import com.patrik.logsdk.log.LogMonster;

public interface ILogConfig {

    /**
     * 上传云端http地址
     *
     * @param path
     * @return
     */
    LogMonster setUploadPath(String path);

    /**
     * log本地存储路径
     *
     * @param path
     * @return
     */
    LogMonster setLogStoragePath(String path);

}
