package com.vando.tpl.vando.Request;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.vando.tpl.vando.Utilities.APIContract;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Faraz on 21-Oct-16.
 */
public class SearchRequest extends StringRequest {
    private static final String SEARCH_REQUEST_URL = "";
    private Map<String, String> params;

    public SearchRequest(String searchString, Response.Listener<String> listener) {
        super(Method.POST, SEARCH_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("search_string", searchString);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
