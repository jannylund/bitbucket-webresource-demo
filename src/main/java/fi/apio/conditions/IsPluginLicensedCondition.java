package fi.apio.conditions;

import java.util.Map;

import com.atlassian.plugin.web.Condition;
import com.atlassian.plugin.webresource.condition.SimpleUrlReadingCondition;


public class IsPluginLicensedCondition extends SimpleUrlReadingCondition implements Condition {

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
        return true;
    }
}