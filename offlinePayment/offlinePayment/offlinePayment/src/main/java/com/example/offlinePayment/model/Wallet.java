package com.example.offlinePayment.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Data
@Builder

@AllArgsConstructor
@Entity
@Table(name = "wallet_table")
@ToString
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long walletId;

    @OneToOne
    @JoinColumn(name = "userId")
    private User user;

    private Double balance;

    private Double offlineBalance;


    @ElementCollection
    @CollectionTable(name = "wallet_codes", joinColumns = @JoinColumn(name = "wallet_id"))
    @Column(name = "code")
    @Builder.Default
    private Set<String> codes = new HashSet<>();


    public Wallet(User user)
    {
        this.user=user;
        this.balance = Double.valueOf(0);
        this.offlineBalance = Double.valueOf(0);
    }
    public Wallet() {
        this.setBalance(Double.valueOf(0));
        this.setOfflineBalance(Double.valueOf(0));
    }
    public Wallet(Long walletId)
    {
        this.walletId=walletId;

    }
}
