package com.jxxx.tiyu_pad.utils;

import com.jxxx.tiyu_pad.api.RetrofitUtil;
import com.jxxx.tiyu_pad.base.Result;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class HttpRequestUtils {
    public static void uploadFiles(String filePath,UploadFileInterface fileInterface) {
        if(StringUtil.isBlank(filePath)){
            fileInterface.succeed("-1");
            return;
        }
        File file = new File(filePath);
        Map<String, RequestBody> map = new HashMap<>();
//        map.put("dirtype", toRequestBody("3"));//头像：3，申诉 ：2 ，收款码：1
        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        // MultipartBody.Part  和后端约定好Key，这里的name是用file
//        MultipartBody.Part body = MultipartBody.Part.createFormData("file", file.getName(), requestFile);
        MultipartBody.Part[] ba =  {MultipartBody.Part.createFormData("files", file.getName(), requestFile)};
        RetrofitUtil.getInstance().apiService()
                .submitFiles(ba, map)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Result>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(Result result) {
                        if (result.getCode() == 200 && result.getData()!=null &&StringUtil.isNotBlank(result.getData().toString())) {
                            fileInterface.succeed(result.getData().toString());
                        }else{
                            fileInterface.failure();
                        }

                    }

                    @Override
                    public void onError(Throwable e) {
                        fileInterface.failure();
                    }

                    @Override
                    public void onComplete() {
                    }
                });

    }

    public interface UploadFileInterface{
        void succeed(String path);
        void failure();
    }
}
