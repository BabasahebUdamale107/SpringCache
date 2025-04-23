package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

@Service
public class MyCacheService {

    @Autowired
    private CacheManager cacheManager;

    public void savePerson(PersonDTO person) {
        String cacheName = person.getName(); // dynamic cache name
        Cache cache = cacheManager.getCache(cacheName);
        if (cache != null) {
            cache.put("data", person);
        }
    }

    public PersonDTO getPerson(String name) {
        Cache cache = cacheManager.getCache(name);
        if (cache != null) {
            Cache.ValueWrapper wrapper = cache.get("data");
            if (wrapper != null) {
                return (PersonDTO) wrapper.get();
            }
        }
        return null;
    }
}
