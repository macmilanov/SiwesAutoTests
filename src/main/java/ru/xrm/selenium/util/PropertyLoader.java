package ru.xrm.selenium.util;

import org.apache.maven.model.Activation;
import org.apache.maven.model.Model;
import org.apache.maven.model.Profile;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;

import java.io.File;
import java.io.FileReader;
import java.util.List;
import java.util.Properties;

/*
 * Class that extracts properties from the prop file.
 *
 * @author Sebastiano Armeli-Battana
 */
public class PropertyLoader
{
    private static final String PROP_FILE = "/application.properties";

    private static final String POM_FILE="pom.xml";

    private static  final String WORKSPACE_FILE=".idea/workspace.xml";

    private static  final String externalProfile="xrm";

    private Model pomModel;

    private static Properties activeProperties;

    public PropertyLoader()
    {
        File pom = new File(POM_FILE);
        pomModel = null;
        FileReader pomFileReader = null;
        MavenXpp3Reader pomMavenReader = new MavenXpp3Reader();
        try
        {
            pomFileReader = new FileReader(pom);
            pomModel = pomMavenReader.read(pomFileReader);
        }
        catch(Exception ex)
        {
            System.out.println("Error trying to read pom.xml");
        }
    }


    public PropertyLoader setActiveProfileProperties(String profileID)
    {
        Profile defaultP = null;

        List<Profile> profiles = pomModel.getProfiles();
        if(profiles.size()==0)
        {
            return this;
        }
        for (Profile profile : profiles)
        {
            if (profileID != null)
            {
                if (profile.getId().equals(profileID))
                {
                    activeProperties = profile.getProperties();
                    return this;
                }
            }
            Activation activation = profile.getActivation();
            if ((defaultP == null) && (activation != null) && (activation.isActiveByDefault()))
            {
                defaultP = profile;
            }
        }
        if(defaultP!=null)
        {
            activeProperties=defaultP.getProperties();
            return  this;
        }
        else
        {
            activeProperties=profiles.get(0).getProperties();
            return this;
        }
    }

    public static String loadProperty(String name)
    {
        String value = "";

        if (name != null)
        {

            try
            {
                value = activeProperties.getProperty(name);
            }
            catch (Exception e)
            {
                e.printStackTrace();
                System.out.println("can't load property");
            }
        }
        return value;
    }
}