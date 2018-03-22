package index.scraper;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Map;

/**
 * Created by wangzhe.bj on 2018/3/17.
 */
public class CT {

    public static void main(String[] args) throws IOException {
//        String url = "https://www.gstatic.com/ct/log_list/all_logs_list.json";
        String url = "https://www.gstatic.com/ct/log_list/log_list.json";
        Map<String,String> idNames = Maps.newHashMap();

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        String r = response.body().string();

        JSONObject root = JSON.parseObject(r);

        JSONArray operators = root.getJSONArray("operators");
        for (Object jo : operators) {
            JSONObject o = (JSONObject)jo;
            idNames.put(o.getString("id"),o.getString("name"));
        }


        StringBuilder sb = new StringBuilder();
        JSONArray logs = root.getJSONArray("logs");
        logs.forEach(l ->{
            JSONObject log = (JSONObject) l;
            sb.append(log.getString("description")).append(",");
            sb.append(log.getString("key")).append(",");
            sb.append(log.getString("url")).append(",");
            sb.append(log.getString("maximum_merge_delay")).append(",");
            JSONArray ob = log.getJSONArray("operated_by");
            String name = idNames.getOrDefault(ob.getString(0),"无");
            sb.append(log.getString("dns_api_endpoint")).append(",");
            sb.append(name).append("\n");

        });

        System.out.println(sb.toString());


    }
}
