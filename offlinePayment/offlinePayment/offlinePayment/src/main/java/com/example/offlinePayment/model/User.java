package com.example.offlinePayment.model;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString


public class User {

    @Id
    private String userId;
    private String userName;
    private String userEmail;
    private boolean isApproved;
    private Long approvalTimestamp;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Wallet wallet;
    Boolean user_status;

    Boolean user_enrolled;

    Boolean user_enrollapproved;

    Double user_latitude;

    Double user_longitude;
    @Enumerated(EnumType.STRING)
    Role role;
}
