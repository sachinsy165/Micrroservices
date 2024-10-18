package com.in288minutes.microservices.currency_exchange_service;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Exchange_value_repository extends JpaRepository<ExchangeValue, Long>
{
    ExchangeValue  findByFromAndTo(String from,String to);//11 th
}
