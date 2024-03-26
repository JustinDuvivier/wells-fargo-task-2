package com.wellsfargo.counselor.entity;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Portfolio {

    @Id
    @GeneratedValue
    private long portfolioId;

    @Column(nullable = false)
    private Date creationDate;

    @ManyToOne
    @JoinColumn(name = "clientId", nullable = false)
    private Client client;


    @OneToMany(mappedBy = "portfolio")
    private List<Security> securities;


    protected Portfolio() {
        this.securities = new ArrayList<>();
    }

    public Portfolio(long portfolioId, Date creationDate) {
        this.portfolioId = portfolioId;
        this.creationDate = creationDate;
        this.securities = new ArrayList<>();

    }

    public long getPortfolioId() {
        return portfolioId;
    }

    public void setPortfolioId(long portfolioId) {
        this.portfolioId = portfolioId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
