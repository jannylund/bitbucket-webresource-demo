package fi.apio.conditions;

import com.atlassian.plugin.webresource.condition.SimpleUrlReadingCondition;

public class IsPluginLicensedCondition extends SimpleUrlReadingCondition
{
    @Override
    protected boolean isConditionTrue()
    {
        return false;
    }

    @Override
    protected String queryKey()
    {
        // This string will be appended to URLs as a GET parameter
        // whenever 'isConditionTrue' returns true.
        // You should make the string short, but unique to your app.
        return "myPluginName";
    }
}