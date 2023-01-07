import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;



public class Bitly
{
    public String zipCode;
    JsonElement jse;



    public Bitly(String zip)
    {
        zipCode = zip;
    }

    public String getCity()
    {
        if(jse == null) fetch();
        return jse.getAsJsonObject().get("current_observation").getAsJsonObject().get("display_location").getAsJsonObject().get("city").getAsString();
    }

    public String getTime()
    {
        if(jse == null) fetch();
        return jse.getAsJsonObject().get("current_observation").getAsJsonObject().get("observation_time_rfc822").getAsString();
    }

    public String getTemp()
    {
        if (jse == null) fetch();
        return jse.getAsJsonObject().get("current_observation").getAsJsonObject().get("temperature_string").getAsString();
    }

    public String getConditions()
    {
        if (jse == null) fetch();
        return jse.getAsJsonObject().get("current_observation").getAsJsonObject().get("weather").getAsString();
    }

    public String getIcon()
    {
        if (jse == null) fetch();
        return jse.getAsJsonObject().get("current_observation").getAsJsonObject().get("icon_url").getAsString();
    }

    public void fetch()
    {
        String wunderGround = "http://api.wunderground.com/api/1655f919bbcd29ed/conditions/q/" + zipCode + ".json";

        try
        {
            URL bitlyURL = new URL(wunderGround);

            InputStream is = bitlyURL.openStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            jse = new JsonParser().parse(br);

        }
        catch (java.net.MalformedURLException mue)
        {
            System.out.println("URL not well formed");
            mue.printStackTrace();
        }
        catch (java.io.IOException ioe)
        {
            System.out.println("Got IO Exception");
            ioe.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        String zip = "95746";
        Bitly b = new Bitly(zip);
        System.out.println(b.getTemp());
        System.out.println(b.getConditions());
        System.out.println(b.getIcon());
        System.out.println(b.getCity());
        System.out.println(b.getTime());
    }
}