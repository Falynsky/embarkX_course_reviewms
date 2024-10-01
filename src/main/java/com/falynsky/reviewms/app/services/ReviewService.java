package com.falynsky.reviewms.app.services;

import com.falynsky.reviewms.app.dto.ReviewDTO;
import com.falynsky.reviewms.app.enities.Review;

import java.util.List;

public interface ReviewService {

    List<Review> getReviewsByCompanyId(Long companyId);

    void addReview(Long companyId, Review review);

    Review getReviewById(Long reviewId);

    void updateReview(Long reviewId, ReviewDTO updatedReview);

    void deleteReview( Long reviewId);
}
