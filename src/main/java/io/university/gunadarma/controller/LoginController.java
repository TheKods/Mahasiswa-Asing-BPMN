package io.university.gunadarma.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        
        if (authentication instanceof OAuth2AuthenticationToken) {
            OAuth2User oauthUser = (OAuth2User) authentication.getPrincipal();
            
            model.addAttribute("name", oauthUser.getAttribute("name"));
            model.addAttribute("email", oauthUser.getAttribute("email"));
            model.addAttribute("provider", ((OAuth2AuthenticationToken) authentication).getAuthorizedClientRegistrationId());
        }
        
        return "dashboard";
    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/login?logout";
    }
} 