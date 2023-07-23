package com.ws.Repository;

import java.util.List;

import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.ws.document.Server;

public interface DNSRepo extends MongoRepository<Server, Integer> {

    @Aggregation(pipeline = { "{$sample:{size:1}}" })
    AggregationResults<Server> random();

    @Query("{ 'country' : ?0 }")
    List<Server> getShortUrlBasedOnProximity(String country);
}