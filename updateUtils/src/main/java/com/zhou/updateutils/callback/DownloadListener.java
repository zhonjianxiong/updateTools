package com.zhou.updateutils.callback;

import java.io.File;

/**
 *
 * Created by Zhon Jianxiong on 2023/4/10
 * Copyright  2015-2023 All rights reserved.
 */
public interface DownloadListener {
    void onCheckerDownloading(int progress);
    void onCheckerDownloadSuccess(File file);
    void onCheckerDownloadFail();
    void onCheckerStartDownload();
}
