package com.falynsky.reviewms.app.controllers;

import com.falynsky.reviewms.app.dto.ReviewDTO;
import com.falynsky.reviewms.app.enities.Review;
import com.falynsky.reviewms.app.services.ReviewService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@RestController
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping
    public ResponseEntity<List<Review>> getReviewsByCompanyId(@RequestParam Long companyId) {
        List<Review> reviewsByCompanyId = reviewService.getReviewsByCompanyId(companyId);
        return ResponseEntity.ok(reviewsByCompanyId);
    }

    @PostMapping
    public ResponseEntity<Void> addReview(@RequestParam Long companyId, @RequestBody Review review) {
        reviewService.addReview(companyId, review);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{reviewId}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long reviewId) {
        Review review = reviewService.getReviewById( reviewId);
        return ResponseEntity.ok(review);
    }

    @PutMapping("/{reviewId}")
    public ResponseEntity<Void> updateReview( @PathVariable Long reviewId, @RequestBody ReviewDTO updatedReview) {
        reviewService.updateReview(reviewId, updatedReview);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{reviewId}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long reviewId) {
        reviewService.deleteReview( reviewId);
        return ResponseEntity.ok().build();
    }
}
