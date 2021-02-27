package mx.org.certificatic.springboot.practica26.zuul.apigateway.fallback;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import com.netflix.hystrix.exception.HystrixTimeoutException;
import com.netflix.zuul.context.RequestContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class UpperCaseFallbackProvider2 implements FallbackProvider {

	private String responseBody = "{\"uppercase\":\"%s\", \"from\":\"from Zuul Fallback\"}";

	@Override
	public String getRoute() {
		return "uppercase-microservice";
	}

	@Override
	public ClientHttpResponse fallbackResponse(String route, final Throwable cause) {
		log.info("[Fallback Provider] Exception {}: {}", cause.getClass().getSimpleName(), cause.getMessage());
		
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest servletRequest = ctx.getRequest();
		
		String[] arr = servletRequest.getRequestURI().split("/");
		
		String dept = arr[arr.length-1];
		
		return response(HttpStatus.OK, dept.toUpperCase());
	}

	private ClientHttpResponse response(final HttpStatus status, String dept) {
		return new ClientHttpResponse() {
			@Override
			public HttpStatus getStatusCode() throws IOException {
				return status;
			}

			@Override
			public int getRawStatusCode() throws IOException {
				return status.value();
			}

			@Override
			public String getStatusText() throws IOException {
				return status.getReasonPhrase() + " customized";
			}

			@Override
			public void close() {
			}

			@Override
			public InputStream getBody() throws IOException {
				return new ByteArrayInputStream(String.format(responseBody, dept).getBytes());
			}

			@Override
			public HttpHeaders getHeaders() {
				HttpHeaders headers = new HttpHeaders();
				headers.setContentType(MediaType.APPLICATION_JSON);
				return headers;
			}
		};
	}
}