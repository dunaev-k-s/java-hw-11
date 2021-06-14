package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FeedMovie {
    private int id;
    private String title;
    private String genre;
    private String imageUrl;
    private String movieUrl;
    private int premierDate;
}
