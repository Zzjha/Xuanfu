package soexample.umeng.com.w3.presenter;

import android.util.Log;

import java.util.Map;

import soexample.umeng.com.w3.callback.MyCallBack;
import soexample.umeng.com.w3.model.MyModel;
import soexample.umeng.com.w3.view.IView;

/**
 * author:author${朱佳华}
 * data:2019/1/12
 */
public class MyPresenter implements IPresenter {
    private MyModel myModel;
    private IView iView;

    public MyPresenter(IView iView) {
        this.iView = iView;
        myModel = new MyModel();
    }

    @Override
    public void getRequest(String url, Class cla, Map<String, String> map) {
        myModel.getData(url, cla, map, new MyCallBack() {
            @Override
            public void setSuccessData(Object successData) {
                iView.success(successData);
                Log.e("aaa",successData.toString());
            }
        });
    }
}
