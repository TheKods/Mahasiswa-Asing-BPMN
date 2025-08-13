package io.university.gunadarma.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "app")
public class AppProperties {
    private Autostart autostart = new Autostart();

    public Autostart getAutostart() {
        return autostart;
    }

    public void setAutostart(Autostart autostart) {
        this.autostart = autostart;
    }

    public static class Autostart {
        private boolean enabled;

        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }
    }
} 