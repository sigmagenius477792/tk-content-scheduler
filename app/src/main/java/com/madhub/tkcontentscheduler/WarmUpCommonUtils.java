```java
package com.madhub.tkcontentscheduler;

/**
 * WarmUpCommonUtils is a final utility class designed to support various features
 * of the MadHub application, specifically tailored for content scheduling and account
 * warm-up processes on social media platforms like Facebook, Instagram, and TikTok.
 * 
 * This class encapsulates methods that facilitate content scheduling, user search,
 * and interaction automation. The methods are static and reusable, ensuring that
 * developers can easily access the functionality without instantiating the class.
 *
 * The architecture follows best practices for utility classes in Java, ensuring
 * that all methods are statically accessible and that the class cannot be instantiated,
 * promoting clean code structure and maintainability.
 */
public final class WarmUpCommonUtils {

    // Private constructor to prevent instantiation
    private WarmUpCommonUtils() {}

    /**
     * Generates a keyword-based filter for searching users on TikTok.
     * 
     * @param keyword The keyword to use for searching users.
     * @param followerCountMin Minimum follower count for filtered users.
     * @param followingCountMin Minimum following count for filtered users.
     * @return A string representing the filter query for TikTok user search.
     * 
     * This method utilizes parameterized filtering to ensure that only relevant
     * users are targeted based on specified criteria, enhancing the efficiency
     * of marketing efforts by focusing on potential client outreach.
     */
    public static String generateTikTokUserSearchFilter(String keyword, int followerCountMin, int followingCountMin) {
        // Validate keyword input
        if (keyword == null || keyword.isEmpty()) {
            throw new IllegalArgumentException("Keyword must not be empty.");
        }
        
        // Construct the filter query
        StringBuilder filterBuilder = new StringBuilder();
        filterBuilder.append("keyword:").append(keyword)
                     .append(", followerCount>=").append(followerCountMin)
                     .append(", followingCount>=").append(followingCountMin);
        
        return filterBuilder.toString();
    }

    /**
     * Constructs a comment post for TikTok videos based on provided parameters.
     * 
     * @param videoId The ID of the TikTok video where the comment will be posted.
     * @param commentContent The content of the comment to be posted.
     * @param commentCount The number of comments to be posted.
     * @return A formatted string representing the comments to be posted.
     * 
     * This method enables the automation of comment posting on TikTok,
     * allowing users to effectively engage with videos related to their
     * marketing strategies. Proper comment composition is crucial for interaction
     * and visibility on the platform.
     */
    public static String constructTikTokCommentPost(String videoId, String commentContent, int commentCount) {
        if (videoId == null || commentContent == null || commentCount <= 0) {
            throw new IllegalArgumentException("Invalid input parameters.");
        }

        StringBuilder commentBuilder = new StringBuilder();
        for (int i = 0; i < commentCount; i++) {
            commentBuilder.append("Posting comment on video ID: ").append(videoId)
                          .append(" with content: ").append(commentContent).append("\n");
        }
        return commentBuilder.toString();
    }

    /**
     * Configures the parameters for Facebook account warm-up operations.
     *
     * @param interactionProbability The probability of interactions such as likes and comments.
     * @param executionProbability The execution probability distribution for warm-up tasks.
     * @return A string summary of the configured parameters.
     *
     * This method aids in setting up the parameters for simulating real user 
     * behavior on Facebook, thereby improving account activity and reducing 
     * the risk of account bans. Proper configuration is critical for effective 
     * account management strategies.
     */
    public static String configureFacebookWarmUpParameters(double interactionProbability, double executionProbability) {
        if (interactionProbability < 0 || interactionProbability > 1 || 
            executionProbability < 0 || executionProbability > 1) {
            throw new IllegalArgumentException("Probabilities must be between 0 and 1.");
        }

        return String.format("Configured Facebook Warm-Up with Interaction Probability: %.2f, Execution Probability: %.2f",
                              interactionProbability, executionProbability);
    }

    /**
     * Validates user input for the content scheduling feature.
     * 
     * @param content The content to be scheduled for posting.
     * @param scheduledTime The time at which the content should be posted.
     * @return True if the input is valid; otherwise, throws an IllegalArgumentException.
     * 
     * This method ensures that content to be scheduled adheres to the necessary
     * validation rules for proper functionality within the MadHub scheduling system.
     */
    public static boolean validateContentSchedulingInput(String content, long scheduledTime) {
        if (content == null || content.isEmpty()) {
            throw new IllegalArgumentException("Content must not be empty.");
        }
        if (scheduledTime <= System.currentTimeMillis()) {
            throw new IllegalArgumentException("Scheduled time must be in the future.");
        }
        return true;
    }

    /**
     * Formats and returns the current date and time in a specified format
     * for scheduling posts.
     *
     * @return A string representing the current date and time in a user-friendly format.
     * 
     * This method is essential for providing a standardized date-time format
     * that can be utilized across various scheduling functionalities, ensuring
     * consistency in datetime representation within the MadHub application.
     */
    public static String getCurrentFormattedDateTime() {
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new java.util.Date());
    }
}
```

### Explanation of the Code:
- **Final Utility Class**: The class `WarmUpCommonUtils` is a final class, preventing instantiation and ensuring a clean utility design.
- **Static Methods**: Each method is static, providing easy access to the utility functions without requiring object creation.
- **Detailed Method Comments**: Each method includes detailed comments that explain its purpose, parameters, and return values, emphasizing how they contribute to MadHub's functionality.
- **Input Validation**: Methods include input validation to ensure reliability and prevent runtime errors.
- **Usage Scenarios**: The methods focus on real-world applications such as TikTok user searches and Facebook account warm-up processes, highlighting how they support MadHub's automation capabilities. 

This implementation addresses the need for a structured, comprehensive utility class that enhances the functionality of a social media management tool like MadHub.
