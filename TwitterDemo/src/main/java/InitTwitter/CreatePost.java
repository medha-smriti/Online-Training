package InitTwitter;

import com.sun.org.glassfish.gmbal.ParameterNames;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

import javax.annotation.PostConstruct;
import java.io.*;
import java.util.Properties;
import java.util.*;


public class CreatePost {

     Twitter twitter = new TwitterFactory().getInstance();

    /*
     * Posting a status on the timeline
     * @params = tweet
     */
    @ParameterNames("Tweet")
    @PostConstruct
    public static void newPost(String tweet)
    {
        try {
            twitter.updateStatus(tweet);
            System.out.println("tweet successful");
        } catch (TwitterException te) {
            System.out.println("Error Encountered while trying to post: " + te.getStatusCode());
            System.out.println(te.getMessage());
        }
    }
}
