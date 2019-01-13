package soexample.umeng.com.w3.model;

import java.util.Map;

import soexample.umeng.com.w3.callback.MyCallBack;

/**
 * author:author${朱佳华}
 * data:2019/1/12
 */
public interface IModel {
    void getData(String url, Class cla, Map<String,String> map,MyCallBack myCallBack);
}
