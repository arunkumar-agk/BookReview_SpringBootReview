package com.book.review.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.review.model.BookReview;
import com.book.review.repository.BookReviewRepo;

@Service
public class BookReviewService {

    @Autowired
    private BookReviewRepo bookReviewRepo;

    public BookReview create(BookReview bookReview) {
        return bookReviewRepo.save(bookReview);
    }

    public boolean updateDetails(int reviewId, BookReview bookReview) {
        if (bookReviewRepo.findById(reviewId).isEmpty()) {
            return false;
        }
        bookReviewRepo.save(bookReview);
        return true;
    }

    public boolean deleteReview(int reviewId) {
        if (bookReviewRepo.findById(reviewId).isEmpty()) {
            return false;
        }
        bookReviewRepo.deleteById(reviewId);
        return true;
    }

    public BookReview getReviewById(int reviewId) {
        return bookReviewRepo.findById(reviewId).orElse(null);
    }
}