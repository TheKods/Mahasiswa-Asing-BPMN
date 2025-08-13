package io.university.gunadarma.config;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationMetricsListener {

	private final MeterRegistry meterRegistry;

	public AuthenticationMetricsListener(MeterRegistry meterRegistry) {
		this.meterRegistry = meterRegistry;
	}

	@EventListener
	public void onAuthenticationSuccess(AuthenticationSuccessEvent event) {
		if (event.getAuthentication() instanceof OAuth2AuthenticationToken token) {
			String provider = token.getAuthorizedClientRegistrationId();
			meterRegistry.counter("auth_logins_total", "provider", provider).increment();
		}
	}
} 