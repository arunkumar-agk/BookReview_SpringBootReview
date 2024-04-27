package com.book.review.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.book.review.model.BookReview;
import com.book.review.service.BookReviewService;

@RestController
public class BookReviewController {

    @Autowired
    private BookReviewService bookReviewService;

    @PostMapping("/api/bookreview")
    public ResponseEntity<BookReview> addReview(@RequestBody BookReview bookReview) {
        BookReview addedReview = bookReviewService.create(bookReview);
        return new ResponseEntity<>(addedReview, HttpStatus.CREATED);
    }

    @PutMapping("/api/bookreview/{reviewId}")
    public ResponseEntity<BookReview> updateReview(@PathVariable("reviewId") int reviewId, @RequestBody BookReview bookReview) {
        if (bookReviewService.updateDetails(reviewId, bookReview)) {
            return new ResponseEntity<>(bookReview, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/api/bookreview/{reviewId}")
    public ResponseEntity<Boolean> deleteReview(@PathVariable("reviewId") int reviewId) {
        if (bookReviewService.deleteReview(reviewId)) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/api/bookreview/{reviewId}")
    public ResponseEntity<BookReview> getReviewById(@PathVariable("reviewId") int reviewId) {
        BookReview review = bookReviewService.getReviewById(reviewId);
        if (review != null) {
            return new ResponseEntity<>(review, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}