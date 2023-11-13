package com.study.figure.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Work {
    private Long workId;
    private String name;
    private String jDesc;
    private String status;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private Long createUserId;
    private LocalDateTime createDateTime;
    private Long updateUserId;
    private LocalDateTime updateDateTime;
}
