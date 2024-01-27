package com.yihuosoft.netlib.http;

import android.text.TextUtils;

import com.yihuosoft.netlib.bean.BaseResponse;
import com.yihuosoft.netlib.bean.FileStorage;
import com.yihuosoft.netlib.bean.UploadRealAddress;
import com.yihuosoft.netlib.bean.UploadReq;
import com.yihuosoft.netlib.util.RequestBodyUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

public class CommonManager {

    public interface UploadImageCallback {
        void callback(String imageFileUrl, File file);  //请求成功回调

        void failureReason(int code, String reason);    //请求失败回调

        void onError(String reason);                    //http错误回调
    }

    //图片上传调用接口入口
    public static void preUpload(UploadReq uploadReq, String path, UploadImageCallback uploadImageCallback) {
        HttpManager.getInstance().create(ApiService.class).preUpload(RequestBodyUtil.preUploadBody(uploadReq)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<BaseResponse<UploadRealAddress.Result>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(BaseResponse<UploadRealAddress.Result> resultBaseResponse) {
                if (resultBaseResponse.getCode() == 0) {
                    UploadRealAddress.Result address = resultBaseResponse.getData();
                    File file = new File(path);
                    FileStorage storage = new FileStorage();
                    if (file.exists()) {
                        storage.setFileFormat(file.getName().split("\\.")[1]);
                        storage.setFileName(file.getName());
                        storage.setFileSize(file.length());
                    }
                    List<FileStorage.FileUrl> fileUrls = new ArrayList<>();
                    FileStorage.FileUrl fileUrl = new FileStorage.FileUrl();
                    fileUrl.setUrl(address.getFileUrl());
                    fileUrls.add(fileUrl);
                    storage.setFileUrls(fileUrls);
                    storage.setMd5(md5HashCode(path));
                    if (!TextUtils.isEmpty(address.getRealOperationUrl())) {
                        upLoadFile(storage, address.getRealOperationUrl(), address.getFileUrl(), file, uploadImageCallback);
                    } else {
                        fileStorage(storage, address.getFileUrl(), file, uploadImageCallback);
                    }
                } else {
                    uploadImageCallback.failureReason(resultBaseResponse.getCode(), resultBaseResponse.getMessage());
                }
            }

            @Override
            public void onError(Throwable e) {
                uploadImageCallback.onError(e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        });
    }

    //上传文件到腾讯云服务器
    private static void fileStorage(FileStorage storage, String imageFileUrl, File file, UploadImageCallback uploadImageCallback) {
        HttpManager.getInstance().create(ApiService.class).fileStorage(RequestBodyUtil.saveReturnId(storage)).
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<BaseResponse<String>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BaseResponse<String> stringBaseResponse) {
                        if (stringBaseResponse.getCode() != 0) {
                            uploadImageCallback.failureReason(stringBaseResponse.getCode(), stringBaseResponse.getMessage());
                        } else {
                            uploadImageCallback.callback(imageFileUrl, file);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        uploadImageCallback.onError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    //上传文件
    private static void upLoadFile(FileStorage storage, String path, String imageFileUrl, File file, UploadImageCallback uploadImageCallback) {
        RequestBody body = RequestBody.create(MediaType.parse("application/octet-stream"), file);
        HttpManager.getInstance().create(ApiService.class).uploadFile(path, body).
                subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).
                subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        fileStorage(storage, imageFileUrl, file, uploadImageCallback);
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (!TextUtils.isEmpty(e.getMessage())) {
                            uploadImageCallback.onError(e.getMessage());
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


    private static String md5HashCode(String filePath) {
        try {
            InputStream fis = Files.newInputStream(Paths.get(filePath));
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] buffer = new byte[1024];
            int length = -1;
            while ((length = fis.read(buffer, 0, 1024)) != -1) {
                md.update(buffer, 0, length);
            }
            fis.close();
            //并返回包含16个元素字节数组,返回数值范围为-128到127
            byte[] md5Bytes = md.digest();
            BigInteger bigInt = new BigInteger(1, md5Bytes);
            return bigInt.toString(16);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
