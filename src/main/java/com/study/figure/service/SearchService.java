package com.study.figure.service;

import java.util.Map;

public interface SearchService {
    
    public Map<String, Object> integratedSearch(String token, String searchKeyword) throws Exception;
    public Map<String, Object> userSearch(Long userId, String token) throws Exception;
}
