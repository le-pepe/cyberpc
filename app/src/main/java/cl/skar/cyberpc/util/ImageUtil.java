package cl.skar.cyberpc.util;

import android.app.Activity;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by trabajo on 20/09/2016.
 */
public class ImageUtil {

    protected static String URL = "https://raw.githubusercontent.com/xSkArx/cyberpc/master/app/src/main/assets/url.json";



    public static ArrayList<String> getImageUrls(Activity activity) {
        RequestQueue queue = Volley.newRequestQueue(activity);
// Request a string response from the provided URL.
        JsonArrayRequest jsArrayRequest;
        final ArrayList<String> list = new ArrayList<String>();

        jsArrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                URL,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        for (int i = 0; i < response.length(); i++) {
                            JSONObject jresponse = null;
                            try {
                                jresponse = response.getJSONObject(i);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            String url = null;
                            try {
                                url = jresponse.getString("url");
                                Log.d("url", url);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            list.add(url);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("ImageUtil", "Error Respuesta en JSON: " + error.getMessage());

                    }
                }
        );
        queue.add(jsArrayRequest);


        return list;
    }
}
