package InitTwitter;

import jdk.nashorn.internal.objects.annotations.Getter;
import twitter4j.Location;
import twitter4j.ResponseList;
import twitter4j.TwitterFactory;
import twitter4j.Twitter;
import twitter4j.Status;
import twitter4j.TwitterException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * <h1>Getting Newsfeed/timeline of </h1>
 * <p>Reloading the timeline of the logged in user,
 * with the new feeds that were generated from the previous time
 * it was loaded.
 * Also loads a single status using a status id.
 * And provides a list of location considered trendy.
 * </p>
 *
 *  @author medha.smriti
 *  @since  14.07.2020
 *  @version 1.0
 */
public class UserTimelineFetcher {

    static Twitter twitter = new TwitterFactory().getInstance();

    /**
     * Getting all the posts from users timeline,
     * from the time it was loaded previously,
     * and printing them on the console.
     */
    @Getter
    public static void getAll()
    {
        try{
            List<Status >statuses = twitter.getHomeTimeline();
            for(Status status: statuses) {
                System.out.println(status.getUser().getName() + " " + status.getText());
            }
        } catch (TwitterException te) {
            System.out.println("Error Encountered while trying to get: " + te.getStatusCode());
            System.out.println(te.getMessage());        }
    }

    /**
     * Getting a single post from the user's timeline,
     * which has the status id as the input value.
     * @param statusId
     */
    @Getter
    public static void getById(String statusId)
    {
        try{
            Status status1 = twitter.showStatus(Long.parseLong(statusId));
            System.out.println(status1.getUser().getName()+ " has posted the following " + status1.getText());
        } catch (TwitterException te) {
            System.out.println("Error Encountered while trying to get status by Id: " + te.getStatusCode());
            System.out.println(te.getMessage());
        }
    }

    /**
     * Gets a List of all the locations which are considered
     * trendy according to twitter
     */
    @Getter
    public static void getLatestTrendyLocation()
    {
        try{
            ResponseList<Location> locationList = twitter.getAvailableTrends();
            for(Location location: locationList) {
                System.out.println(location);
            }
        } catch (TwitterException te) {
            System.out.println("Error Encountered while trying to get Trendy Location: " + te.getStatusCode());
            System.out.println(te.getMessage());
        }
    }
}
