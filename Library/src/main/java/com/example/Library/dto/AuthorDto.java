package com.example.Library.dto;

import java.time.LocalDate;

public record AuthorDto(
         String fullName,
         LocalDate birthdayDate
) {
}
