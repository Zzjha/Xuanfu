package soexample.umeng.com.w3.utils;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;
import rx.Observable;

/**
 * author:author${朱佳华}
 * data:2019/1/12
 */
public interface MyApiService {
    @GET
    Observable<ResponseBody> get(@Url String url, @QueryMap Map<String,String> map);
}
