package InitTwitter;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InitTwitter {
    public static void main (String args[])
    {
        try {
            System.out.println("Please Enter the new STATUS: ");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String tweet = br.readLine();
            CreatePost createPost = new CreatePost();
            createPost.NewPost(tweet);

            System.out.println("Getting the posts from timeline");
            GetFeeds getFeeds = new GetFeeds();
            getFeeds.GetAll();

        } catch (Exception ex) {
            System.out.println("Error Encountered while trying to post or Get: ");
            System.out.println(ex.getMessage());        }
    }
}
