package com.projects.thebestpiwobackend.piwa;


//Code from: https://www.geeksforgeeks.org/elo-rating-algorithm/

public class EloRatingCalculator {
    //How much every battle affects the rating
    private final static int K = 30;

    // Function to calculate the Probability
    private double probability(int rating1, int rating2) {
        // Calculate and return the expected score
        return 1.0 / (1 + Math.pow(10, (rating1 - rating2) / 400.0));
    }

    // Function to calculate Elo rating
    // K is a constant.
    // outcome determines the outcome: 1 for Player A win, 0 for Player B win, 0.5 for draw.
    public RatingPair calculateNewRatings(int winnerRating, int loserRating) {
        // Calculate the Winning probability of Player B
        double Pb = probability(winnerRating, loserRating);

        // Calculate the Winning probability of Player A
        double Pa = probability(loserRating, winnerRating);

        // Update the Elo Ratings
        winnerRating = (int) (winnerRating + K * (1 - Pa));
        loserRating = (int) (loserRating + K * ((-1)*Pb));

        return new RatingPair(winnerRating, loserRating);
    }
}
