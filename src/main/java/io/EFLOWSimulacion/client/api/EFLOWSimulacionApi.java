package io.EFLOWSimulacion.client.api;

import io.EFLOWSimulacion.client.ApiClient;
import io.EFLOWSimulacion.client.ApiException;
import io.EFLOWSimulacion.client.ApiResponse;
import io.EFLOWSimulacion.client.Configuration;
import io.EFLOWSimulacion.client.Pair;
import io.EFLOWSimulacion.client.ProgressRequestBody;
import io.EFLOWSimulacion.client.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;

import io.EFLOWSimulacion.client.model.Peticion;
import io.EFLOWSimulacion.client.model.Respuesta;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EFLOWSimulacionApi {
    private ApiClient apiClient;
    public EFLOWSimulacionApi() {
        this(Configuration.getDefaultApiClient());
    }
    public EFLOWSimulacionApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }
    public ApiClient getApiClient() {
        return apiClient;
    }
    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }
    
    public okhttp3.Call eflowCall(String xApiKey, Peticion request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = request;
        String localVarPath = "";
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (xApiKey != null)
        localVarHeaderParams.put("x-api-key", apiClient.parameterToString(xApiKey));
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);
        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);
        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new okhttp3.Interceptor() {
                @Override
                public okhttp3.Response intercept(okhttp3.Interceptor.Chain chain) throws IOException {
                    okhttp3.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }
        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    private okhttp3.Call eflowValidateBeforeCall(String xApiKey, Peticion request, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        if (xApiKey == null) {
            throw new ApiException("Missing the required parameter 'xApiKey' when calling eflow(Async)");
        }
        if (request == null) {
            throw new ApiException("Missing the required parameter 'request' when calling eflow(Async)");
        }
        
        okhttp3.Call call = eflowCall(xApiKey, request, progressListener, progressRequestListener);
        return call;
    }
    
    public Respuesta eflow(String xApiKey, Peticion request) throws ApiException {
        ApiResponse<Respuesta> resp = eflowWithHttpInfo(xApiKey, request);
        return resp.getData();
    }
    
    public ApiResponse<Respuesta> eflowWithHttpInfo(String xApiKey, Peticion request) throws ApiException {
        okhttp3.Call call = eflowValidateBeforeCall(xApiKey, request, null, null);
        Type localVarReturnType = new TypeToken<Respuesta>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

}
