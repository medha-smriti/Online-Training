package InitTwitter;

import com.sun.org.glassfish.gmbal.ParameterNames;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.TwitterException;
import twitter4j.User;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <h1>Tweeting new Posts on timeline</h1>
 * <p>When a person wants to put new status on their timeline,
 *  the status is updated with the provided input string
 *  </p>
 *
 *  @author medha.smriti
 *  @since  14.07.2020
 *  @version 1.0
*/
public class CreatePost {

    static Twitter twitter = new TwitterFactory().getInstance();

    /**
     * The method takes a string as input and updates it as
     * the status on the current user's timeline.
     */
    @PostConstruct
    public static void newPost(String tweet)
    {
        try {
            User user = twitter.verifyCredentials();
            System.out.println("Current user who is updating the status is: " + user.getName());

            twitter.updateStatus(tweet);
            System.out.println("tweet successful");
        } catch (TwitterException te) {
            System.out.println("Error Encountered while posting on twitter: " + te.getStatusCode())   ;
            System.out.println(te.getMessage());
        }
    }
}
