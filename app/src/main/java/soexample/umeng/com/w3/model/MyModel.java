package soexample.umeng.com.w3.model;

import android.util.Log;

import com.google.gson.Gson;

import java.util.Map;

import soexample.umeng.com.w3.callback.MyCallBack;
import soexample.umeng.com.w3.utils.RetrofitUtils;

/**
 * author:author${朱佳华}
 * data:2019/1/12
 */
public class MyModel implements IModel {
    @Override
    public void getData(String url, final Class cla, Map<String, String> map, final MyCallBack myCallBack) {
        RetrofitUtils.getInstance().get(url, map, new RetrofitUtils.CallBacks() {
            @Override
            public void setSuccess(String jsonStr) {
                Gson gson = new Gson();
                Object o = gson.fromJson(jsonStr, cla);
                myCallBack.setSuccessData(o);
            }

            @Override
            public void setError(String jsonStr) {
                Log.e("e",jsonStr);
            }
        });
    }
}
