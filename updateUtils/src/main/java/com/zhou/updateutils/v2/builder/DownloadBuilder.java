package com.zhou.updateutils.v2.builder;

import android.content.Context;

import androidx.annotation.NonNull;

import com.zhou.updateutils.callback.APKDownloadListener;
import com.zhou.updateutils.utils.FileHelper;
import com.zhou.updateutils.v2.callback.CustomDownloadFailedListener;
import com.zhou.updateutils.v2.callback.CustomDownloadingDialogListener;
import com.zhou.updateutils.v2.callback.CustomVersionDialogListener;
import com.zhou.updateutils.v2.callback.ForceUpdateListener;
import com.zhou.updateutils.v2.ui.VersionService;

/**
 *
 * Created by Zhon Jianxiong on 2023/4/10
 * Copyright  2015-2023 All rights reserved.
 */

public class DownloadBuilder {
    private RequestVersionBuilder requestVersionBuilder;
    private boolean isSilentDownload;
    private String downloadAPKPath;
    private boolean isForceRedownload;
    private String downloadUrl;
    private boolean isShowDownloadingDialog;
    private boolean isShowNotification;
    private boolean isShowDownloadFailDialog;
    private NotificationBuilder notificationBuilder;
    private APKDownloadListener apkDownloadListener;

    private CustomDownloadFailedListener customDownloadFailedListener;
    private CustomDownloadingDialogListener customDownloadingDialogListener;
    private CustomVersionDialogListener customVersionDialogListener;
    private ForceUpdateListener forceUpdateListener;
    private UIData versionBundle;

    public DownloadBuilder() {
        throw new RuntimeException("can not be instantiated from outside");
    }

    private void initialize() {
        isSilentDownload = false;
        downloadAPKPath = FileHelper.getDownloadApkCachePath();
        isForceRedownload = false;
        isShowDownloadingDialog = true;
        isShowNotification = true;
        isShowDownloadFailDialog = true;
        notificationBuilder=NotificationBuilder.create();
    }

    public DownloadBuilder(RequestVersionBuilder requestVersionBuilder, UIData versionBundle) {
        this.requestVersionBuilder = requestVersionBuilder;
        this.versionBundle = versionBundle;
        initialize();
    }


    public ForceUpdateListener getForceUpdateListener() {
        return forceUpdateListener;
    }

    public DownloadBuilder setForceUpdateListener(ForceUpdateListener forceUpdateListener) {
        this.forceUpdateListener = forceUpdateListener;
        return this;
    }

    public DownloadBuilder setVersionBundle(UIData versionBundle) {
        this.versionBundle = versionBundle;
        return this;
    }

    public UIData getVersionBundle() {
        return versionBundle;
    }

    public DownloadBuilder setCustomDownloadFailedListener(CustomDownloadFailedListener customDownloadFailedListener) {
        this.customDownloadFailedListener = customDownloadFailedListener;
        return this;
    }

    public DownloadBuilder setCustomDownloadingDialogListener(CustomDownloadingDialogListener customDownloadingDialogListener) {
        this.customDownloadingDialogListener = customDownloadingDialogListener;
        return this;
    }

    public DownloadBuilder setCustomVersionDialogListener(CustomVersionDialogListener customVersionDialogListener) {
        this.customVersionDialogListener = customVersionDialogListener;
        return this;
    }


    public DownloadBuilder setSilentDownload(boolean silentDownload) {
        isSilentDownload = silentDownload;
        return this;
    }

    public DownloadBuilder setDownloadAPKPath(String downloadAPKPath) {
        this.downloadAPKPath = downloadAPKPath;
        return this;
    }

    public DownloadBuilder setForceRedownload(boolean forceRedownload) {
        isForceRedownload = forceRedownload;
        return this;
    }

    public DownloadBuilder setDownloadUrl(@NonNull String downloadUrl) {
        this.downloadUrl = downloadUrl;
        return this;
    }

    public DownloadBuilder setShowDownloadingDialog(boolean showDownloadingDialog) {
        isShowDownloadingDialog = showDownloadingDialog;
        return this;
    }

    public DownloadBuilder setShowNotification(boolean showNotification) {
        isShowNotification = showNotification;
        return this;
    }

    public DownloadBuilder setShowDownloadFailDialog(boolean showDownloadFailDialog) {
        isShowDownloadFailDialog = showDownloadFailDialog;
        return this;
    }

    public DownloadBuilder setApkDownloadListener(APKDownloadListener apkDownloadListener) {
        this.apkDownloadListener = apkDownloadListener;
        return this;
    }




    public boolean isSilentDownload() {
        return isSilentDownload;
    }

    public String getDownloadAPKPath() {
        return downloadAPKPath;
    }

    public boolean isForceRedownload() {
        return isForceRedownload;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public boolean isShowDownloadingDialog() {
        return isShowDownloadingDialog;
    }

    public boolean isShowNotification() {
        return isShowNotification;
    }

    public boolean isShowDownloadFailDialog() {
        return isShowDownloadFailDialog;
    }

    public APKDownloadListener getApkDownloadListener() {
        return apkDownloadListener;
    }



    public CustomDownloadFailedListener getCustomDownloadFailedListener() {
        return customDownloadFailedListener;
    }

    public CustomDownloadingDialogListener getCustomDownloadingDialogListener() {
        return customDownloadingDialogListener;
    }

    public CustomVersionDialogListener getCustomVersionDialogListener() {
        return customVersionDialogListener;
    }

    public RequestVersionBuilder getRequestVersionBuilder() {
        return requestVersionBuilder;
    }

    public NotificationBuilder getNotificationBuilder() {
        return notificationBuilder;
    }

    public DownloadBuilder setNotificationBuilder(NotificationBuilder notificationBuilder) {
        this.notificationBuilder = notificationBuilder;
        return this;
    }

    public void excuteMission(Context context) {
        VersionService.enqueueWork(context, this);
    }
}
