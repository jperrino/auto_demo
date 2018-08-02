package helpers;

import data.PropertiesProvider;
import driver.DriverInstanceManager;

public class PropertyInstanceManager {

    private static PropertiesProvider property;

    public static PropertiesProvider getPropertyInstance()
    {
        if(property == null)
        {
            synchronized(DriverInstanceManager.class)
            {
                property = new PropertiesProvider();
            }
        }
        return property;
    }
}
