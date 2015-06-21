package main.java.com.exavault.client;

import com.fasterxml.jackson.databind.JavaType;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.filter.LoggingFilter;
import com.sun.jersey.api.client.WebResource.Builder;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.io.IOException;
import java.net.URLEncoder;
import java.io.UnsupportedEncodingException;

import javax.ws.rs.core.Response.Status.Family;

// EV NOTE: need Multimap functionality for "array" request parameters
import com.google.common.collect.Multimap;

public class ApiInvoker {

    private static ApiInvoker INSTANCE = new ApiInvoker();

    private Map<String, Client> hostMap = new HashMap<String, Client>();
    private Map<String, String> defaultHeaderMap = new HashMap<String, String>();

    public static ApiInvoker getInstance() {
        return INSTANCE;
    }

    public void addDefaultHeader(String key, String value) {
        defaultHeaderMap.put(key, value);
    }

    public String escapeString(String str) {
        try{
            return URLEncoder.encode(str, "utf8").replaceAll("\\+", "%20");
        }
        catch(UnsupportedEncodingException e) {
            return str;
        }
    }

    public static Object deserialize(String json, String containerType, Class<?> cls) throws ApiException {
        try{
            if("List".equals(containerType)) {
                JavaType typeInfo = JsonUtil.getJsonMapper().getTypeFactory().constructCollectionType(List.class, cls);
                List<?> response = (List<?>) JsonUtil.getJsonMapper().readValue(json, typeInfo);
                return response;
            }
            else if(String.class.equals(cls)) {
                if(json != null && json.startsWith("\"") && json.endsWith("\"") && json.length() > 1)
                    return json.substring(1, json.length() - 2);
                else
                    return json;
            }
            else {
                return JsonUtil.getJsonMapper().readValue(json, cls);
            }
        }
        catch (IOException e) {
            throw new ApiException(500, e.getMessage());
        }
    }

    public static String serialize(Object obj) throws ApiException {
        try {
            if (obj != null)
                return JsonUtil.getJsonMapper().writeValueAsString(obj);
            else
                return null;
        }
        catch (Exception e) {
            throw new ApiException(500, e.getMessage());
        }
    }

    public String invokeAPI(String host, String path, String method, Multimap<String, String> queryParams, Object body, Multimap<String, String> headerParams, Multimap<String, String> formParams, String contentType) throws ApiException {

        Client client = getClient(host);

        StringBuilder b = new StringBuilder();

        for(String key : queryParams.keySet()) {
            Collection<String> values = queryParams.get(key);
            for (String value : values) {
                if (value != null){
                    if(b.toString().length() == 0) {
                        b.append("?");
                    } else {
                        b.append("&");
                    }
                    b.append(escapeString(key)).append("=").append(escapeString(value));
                }
            }
        }
        
        String querystring = b.toString();

        Builder builder = client.resource(host + path + querystring).accept("*/*");
        for(String key : headerParams.keySet()) {
            builder.header(key, headerParams.get(key));
        }

        for(String key : defaultHeaderMap.keySet()) {
            if(!headerParams.containsKey(key)) {
                builder.header(key, defaultHeaderMap.get(key));
            }
        }
        ClientResponse response = null;

        if("GET".equals(method)) {
            response = (ClientResponse) builder.get(ClientResponse.class);
        }
        else if ("POST".equals(method)) {
            if(body == null) {
                // EV NOTE - codegen assumes that one "body" is passed
                // via each method instead of a parameterized list,
                // which is kinda not what we want. So, just serialize
                // the queryParams and set to the body
                String formData = encodeFormData(formParams);
                response = builder.type(contentType).post(ClientResponse.class, formData);
            } else {
                response = builder.type(contentType).post(ClientResponse.class, serialize(body));
            }
        }
        else if ("PUT".equals(method)) {
            if(body == null)
                response = builder.put(ClientResponse.class, serialize(body));
            else {
                if("application/x-www-form-urlencoded".equals(contentType)) {
                    String formData = encodeFormData(headerParams);
                    response = builder.type(contentType).put(ClientResponse.class, formData);
                }
                else
                    response = builder.type(contentType).put(ClientResponse.class, serialize(body));
            }
        }
        else if ("DELETE".equals(method)) {
            if(body == null)
                response = builder.delete(ClientResponse.class, serialize(body));
            else
                response = builder.type(contentType).delete(ClientResponse.class, serialize(body));
        }
        else {
            throw new ApiException(500, "unknown method type " + method);
        }
        if(response.getClientResponseStatus() == ClientResponse.Status.NO_CONTENT) {
            return null;
        }
        else if(response.getClientResponseStatus().getFamily() == Family.SUCCESSFUL) {
            return (String) response.getEntity(String.class);
        }
        else {
            throw new ApiException(
                response.getClientResponseStatus().getStatusCode(),
                response.getEntity(String.class));
        }
    }

    /**
     * EV NOTE: this has been abstracted slightly to support both POST
     * and PUT, since EV POST requests require data to be submitted as
     * application/x-www-form-urlencoded.
     *
     * @param  Multimap<string, string> params
     * @return String
     */
    private String encodeFormData(Multimap<String, String>params) {

        StringBuilder formParamBuilder = new StringBuilder();

        // encode the form params
        for(String key : params.keySet()) {
            Collection<String> values = params.get(key);
            for (String value : values) {
                if(value != null && !"".equals(value.trim())) {
                    if(formParamBuilder.length() > 0) {
                        formParamBuilder.append("&");
                    }
                    try {
                        formParamBuilder.append(URLEncoder.encode(key, "utf8")).append("=").append(URLEncoder.encode(value, "utf8"));
                    }
                    catch (Exception e) {
                        // move on to next
                    }
                }
            }
        }

        return formParamBuilder.toString();
    }

    private Client getClient(String host) {
        if(!hostMap.containsKey(host)) {
            Client client = Client.create();
            client.addFilter(new LoggingFilter());
            hostMap.put(host, client);
        }
        return hostMap.get(host);
    }
}

