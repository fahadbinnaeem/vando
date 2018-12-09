package com.vando.tpl.vando.Request;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.vando.tpl.vando.Utilities.APIContract;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Faraz on 01-Dec-16.
 */
public class GetFeedsRequest extends StringRequest {
    private static final String GET_FEEDS_REQUEST_URL = "";
    private Map<String, String> params;

    public GetFeedsRequest(long userId,long reqCountLimit,long offset, Response.Listener<String> listener) {
        super(Method.POST, GET_FEEDS_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("user_id", userId+"");
        params.put("limit", reqCountLimit+"");
        params.put("offset", offset+"");
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}