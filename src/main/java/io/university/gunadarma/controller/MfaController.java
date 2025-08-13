package io.university.gunadarma.controller;

import io.university.gunadarma.service.MfaService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MfaController {

	private final MfaService mfaService;

	public MfaController(MfaService mfaService) {
		this.mfaService = mfaService;
	}

	@GetMapping("/mfa")
	public String mfaPage(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth instanceof OAuth2AuthenticationToken token) {
			OAuth2User user = (OAuth2User) token.getPrincipal();
			String email = user.getAttribute("email");
			String name = user.getAttribute("name");
			mfaService.sendOtp(email, name);
			model.addAttribute("email", email);
		}
		return "mfa";
	}

	@PostMapping("/mfa")
	public String verify(@RequestParam("code") String code, Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth instanceof OAuth2AuthenticationToken token) {
			OAuth2User user = (OAuth2User) token.getPrincipal();
			String email = user.getAttribute("email");
			if (mfaService.verify(email, code)) {
				return "redirect:/dashboard";
			}
			model.addAttribute("email", email);
			model.addAttribute("error", true);
			return "mfa";
		}
		return "redirect:/login";
	}
} 