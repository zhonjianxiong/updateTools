package com.zhou.updateutils.callback;

import java.io.File;

/**
 * 下载监听
 * Created by Zhon Jianxiong on 2023/4/10
 * Copyright  2015-2023 All rights reserved.
 */
public interface APKDownloadListener {
    void onDownloading(int progress);
    void onDownloadSuccess(File file);
    void onDownloadFail();
}
