package com.astrapay.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Note{

    private Long id;

    @Size (min = 3, message = "Title must be at least 3 characters")
    private String title;

    @NotBlank(message = "Content is required")
    private String content;
}
