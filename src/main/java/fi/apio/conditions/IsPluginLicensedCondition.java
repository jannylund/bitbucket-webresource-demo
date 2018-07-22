package fi.apio.conditions;

import java.util.Map;

import javax.inject.Inject;

import com.atlassian.plugin.spring.scanner.annotation.imports.ComponentImport;
import com.atlassian.plugin.web.Condition;
import com.atlassian.plugin.webresource.condition.SimpleUrlReadingCondition;
import com.atlassian.upm.api.license.PluginLicenseManager;


public class IsPluginLicensedCondition extends SimpleUrlReadingCondition implements Condition {

    @ComponentImport
    private final PluginLicenseManager pluginLicenseManager;

    @Inject
    public IsPluginLicensedCondition(final PluginLicenseManager pluginLicenseManager) {
        this.pluginLicenseManager = pluginLicenseManager;
    }

    @Override
    protected boolean isConditionTrue() {
        return true;
    }

    @Override
    protected String queryKey() {
        // This string will be appended to URLs as a GET parameter
        // whenever 'isConditionTrue' returns true.
        // You should make the string short, but unique to your app.
        return "myPluginName";
    }

    @Override
    public boolean shouldDisplay(Map<String, Object> map) {
        if (pluginLicenseManager.getLicense().isDefined()) {
            return pluginLicenseManager.getLicense().get().isValid();
        } else {
            return false;
        }
    }
}