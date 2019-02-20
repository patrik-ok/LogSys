package com.patrik.logsdk.action;

import com.patrik.logsdk.log.LogMonster;

public interface ConfigInterface {

    /**
     * 上传云端http地址
     *
     * @param path
     * @return
     */
    LogMonster setUploadPath(String path);
}
