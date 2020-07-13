package InitTwitter;

import jdk.nashorn.internal.objects.annotations.Getter;
import twitter4j.*;
import java.util.*;

public class GetFeeds {

    /*
     * Getting all the posts from one's timeline
     */
    @Getter
    public static void GetAll()
    {
        try{
            Twitter twitter = new TwitterFactory().getInstance();
            List<Status >statuses = twitter.getHomeTimeline();
            for(Status status: statuses)
                System.out.println(status.getUser().getName()+ " " + status.getText());
        } catch (TwitterException te) {
            System.out.println("Error Encountered while trying to get: " + te.getStatusCode());
            System.out.println(te.getMessage());        }
    }
}
