package io.EFLOWSimulacion.client.api;

import io.EFLOWSimulacion.client.ApiClient;
import io.EFLOWSimulacion.client.ApiException;
import io.EFLOWSimulacion.client.model.Peticion;
import io.EFLOWSimulacion.client.model.Respuesta;
import okhttp3.OkHttpClient;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.Assert;
import org.junit.Before;

import java.util.concurrent.TimeUnit;

public class ApiTest {
    
	private Logger logger = LoggerFactory.getLogger(ApiTest.class.getName());
	private final EFLOWSimulacionApi api = new EFLOWSimulacionApi();
	private ApiClient apiClient = null;

	@Before()
	public void setUp() {
		this.apiClient = api.getApiClient();
		this.apiClient.setBasePath("the_url");
		OkHttpClient insecureClient = ApiClient.getClientNoSSLVerification();
		OkHttpClient okHttpClient = insecureClient.newBuilder()
				.readTimeout(60, TimeUnit.SECONDS).build();
		apiClient.setHttpClient(okHttpClient);
	}
	
    
    @Test
    public void eflowTest() throws ApiException {
        String xApiKey = "your_api_key";
        Peticion persona = new Peticion();
        
        persona.setFolio("000016");
        persona.setTipoDocumento("1");
        persona.setNumeroDocumento("00000002");
        
		try {
			Respuesta response = api.eflow(xApiKey, persona);
	        Assert.assertTrue(response != null);
	        if(response != null) {
	        	logger.info(response.toString());
	        }
		} catch (ApiException e) {
			logger.info(e.getResponseBody());
		}
    }
    
}