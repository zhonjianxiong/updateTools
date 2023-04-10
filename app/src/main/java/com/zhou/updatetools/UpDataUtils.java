package com.zhou.updatetools;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;


import com.zhou.updateutils.v2.AllenVersionChecker;
import com.zhou.updateutils.v2.builder.DownloadBuilder;
import com.zhou.updateutils.v2.builder.UIData;
import com.zhou.updateutils.v2.callback.ForceUpdateListener;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by DZH
 * Email:18710108923@163.com
 * 2018/12/26
 */
public class UpDataUtils {

    //更新
    public static void inspectUpData(final Activity activity) throws Exception {


//        String versionName = UpDataUtils.getVersionName(activity);
//        Map<String,String> map=new HashMap<>();
//        map.put("version",versionName);
//        map.put("appOs","android");
//        map.put("resType","0");//0校验版本号  1获取升级信息
//        HttpFactory.createOK().getToken(Urls.VERSION, map, new NetWorkCallBack<UpDataBean>() {
//            @Override
//            public void onSuccess(UpDataBean upDataBean) {
//                if (upDataBean.getCode()==ResultCode.SUCCESS_CODE){
//                    UpDataBean.DataBean data = upDataBean.getData();
//                    if (!data.getRemindType().equals("0")){
//                        String remindType = data.getRemindType();
//                        String upGradeInfo = data.getUpGradeInfo();
//                        String remindDesp = data.getRemindDesp();
//                        String button1Desp = data.getButton1Desp();
//                        String button2Desp = data.getButton2Desp();
//                        String button1Action = data.getButton1Action();
//                        String button2Action = data.getButton2Action();
//                        String downloadUrl = data.getDownloadUrl();
//                        upData(activity,remindType,upGradeInfo,remindDesp,button1Desp,button2Desp,button1Action,button2Action,downloadUrl);
//                    }
//                }else{
//                    ToastUtils.showMessage(activity,upDataBean.getMessage());
//                }
//            }
//
//            @Override
//            public void onError(int errorCode, String errorMsg) {
//
//            }
//
//            @Override
//            public void onFail(String netOff) {
//
//            }
//        });

    }




    /**
     * 获取指定包名的版本号
     *
     * @param context
     *            本应用程序上下文
     * @param packageName
     *            你想知道版本信息的应用程序的包名
     * @return
     * @throws Exception
     */
    public static int getVersionName(Context context, String packageName) throws Exception {
        // 获取packagemanager的实例
        PackageManager packageManager = context.getPackageManager();
        PackageInfo packInfo = packageManager.getPackageInfo(packageName, 0);
        int version = packInfo.versionCode;
        return version;
    }


    public static void upData(final Activity context, final String remindType,
                              String upGradeInfo, String remindDesp,
                              String button1Desp, String button2Desp,
                              String button1Action , final String button2Action, String url){
        UIData uiData = UIData.create().setDownloadUrl(url);
        uiData.setTitle(upGradeInfo);
        uiData.setContent(remindDesp);
        uiData.setBUTTON1(button1Desp);
        uiData.setBUTTON2(button2Desp);

        DownloadBuilder builder= AllenVersionChecker
                .getInstance()
                .downloadOnly(uiData);

        builder.excuteMission(context);

        builder.setForceUpdateListener(new ForceUpdateListener() {
            @Override
            public void onShouldForceUpdate() {
                if (button2Action.equals("2")){
                    context.finish();
                }else{
                }
            }
        });
    }


    public static void download(final Activity context, String url){
        UIData uiData = UIData.create().setDownloadUrl(url);
        uiData.setTitle("提示");
        uiData.setContent("是否下载到本地");
        uiData.setBUTTON1("确定");
        uiData.setBUTTON2("取消");

        DownloadBuilder builder= AllenVersionChecker
                .getInstance()
                .downloadOnly(uiData);
        builder.excuteMission(context);
    }
}
