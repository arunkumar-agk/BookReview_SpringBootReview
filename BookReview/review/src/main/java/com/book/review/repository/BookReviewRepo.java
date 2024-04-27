package com.book.review.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.book.review.model.BookReview;

@Repository
public interface BookReviewRepo extends JpaRepository<BookReview, Integer> {
}