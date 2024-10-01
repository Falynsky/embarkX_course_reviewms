package com.falynsky.reviewms.app.services.impl;

import com.falynsky.reviewms.app.dto.ReviewDTO;
import com.falynsky.reviewms.app.enities.Review;
import com.falynsky.reviewms.app.repositories.ReviewRepository;
import com.falynsky.reviewms.app.services.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@AllArgsConstructor
@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    @Override
    public List<Review> getReviewsByCompanyId(Long companyId) {
        return getReviews(companyId);
    }

    @Override
    public void addReview(Long companyId, Review review) {
        review.setCompanyId(companyId);
        reviewRepository.save(review);
    }

    @Override
    public Review getReviewById(Long reviewId) {
        return getReview(reviewId);
    }

    @Override
    public void updateReview(Long reviewId, ReviewDTO updatedReview) {

        if (!reviewRepository.existsById(reviewId)) {
            throw new NoSuchElementException("Review not found");
        }

        Review foundedReview = getReview(reviewId);

        foundedReview.setRating(updatedReview.getRating() == null ? foundedReview.getRating() : updatedReview.getRating());
        foundedReview.setReview(updatedReview.getReview() == null ? foundedReview.getReview() : updatedReview.getReview());
        foundedReview.setDescription(updatedReview.getDescription() == null ? foundedReview.getDescription() : updatedReview.getDescription());

        reviewRepository.save(foundedReview);
    }

    @Override
    public void deleteReview(Long reviewId) {
        if (!reviewRepository.existsById(reviewId)) {
            throw new NoSuchElementException("Review not found");
        }

        Review foundedReview = getReview(reviewId);

        reviewRepository.delete(foundedReview);
    }

    private Review getReview(Long reviewId) {
        Review review = reviewRepository.findById(reviewId).orElse(null);

        if (review == null) {
            throw new NoSuchElementException("Review not found");
        }

        return review;
    }

    private List<Review> getReviews(Long companyId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);

        if (reviews == null) {
            throw new NoSuchElementException("No reviews found for selected company id");
        }

        return reviews;
    }
}
