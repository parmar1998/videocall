package com.rp.videocall.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class User {
    private String userName;
    private String email;
    private String password;
    private String status;
}
