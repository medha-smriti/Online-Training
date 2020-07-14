package InitTwitter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * InitTwitter class is defined to initiate the application
 * which uses the Twitter4j api integration to post and get
 * statuses on/from twitter.
 * The starter main function call other classes to perform
 * the get and post on twitter timeline.
 *
 * @author medha.smriti
 * @since  14.07.2020
 * @version 1.0
 */
public class InitTwitter {

    /**
     * This method is the starting point for the application
     * and calls The CreatePost and UserTimelineFetcher classes
     * to post and get statuses from twitter.
     *
     * @param args
     */
    public static void main (String[] args) {
        int flag = 0;
        try{
            System.out.println("Enter code to choose post or get:");
            Scanner sc = new Scanner(new InputStreamReader(System.in));
            flag = sc.nextInt();
            if(flag == 1 ) {
                try {
                    System.out.println("Please Enter the new STATUS: ");
                    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                    String tweet = br.readLine();

                    CreatePost createPost = new CreatePost();
                    createPost.newPost(tweet);
                } catch (IOException io) {
                    System.out.println("Error Encountered while writing a post: ");
                    System.out.println(io.getMessage());
                }
            }
            else {
                System.out.println("Getting the posts from timeline");
                UserTimelineFetcher userTimelineFetcher = new UserTimelineFetcher();
                if (flag == 0) {
                    userTimelineFetcher.getAll();
                } else if (flag == 2) {
                    userTimelineFetcher.getLatestTrendyLocation();
                } else {
                    try {
                        System.out.println("Enter the status Id to be fetched: ");
                        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                        String statusId = br.readLine();

                        userTimelineFetcher.getById(statusId);
                    } catch (IOException e) {
                        System.out.println("Error Encountered while entering status Id: ");
                        System.out.println(e.getMessage());
                    }
                }
            }
        } catch (NoSuchElementException e){
            System.out.println("Exception in taking integer input  " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException ae) {
            System.out.println("Exception in get while trying to getbyId  " + ae.getMessage());
        }
    }
}
