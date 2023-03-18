package com.dohatec.pcbook;

public interface RatingStore {
    Rating Add(String laptopID, double score);
}
