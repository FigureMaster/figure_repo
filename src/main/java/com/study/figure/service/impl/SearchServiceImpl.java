package com.study.figure.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.figure.mybatis.SearchMapper;
import com.study.figure.service.SearchService;
import com.study.figure.service.TokenProvider;

@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private SearchMapper searchMapper;

    @Autowired
    private TokenProvider tokenProvider;

    @Override
    public Map<String, Object> integratedSearch(String token, String searchKeyword) throws Exception {
        if (StringUtils.isEmpty(token)) {
            return null;
        }
        String userId = tokenProvider.getUserId(token);
        Map<String, Object> param = new HashMap<>();
        param.put("userId", userId);
        param.put("searchKeyword", searchKeyword);
        return searchMapper.integratedSearch(param);
    }

    @Override
    public Map<String, Object> userSearch(Long userId, String token) throws Exception {
        if (StringUtils.isEmpty(token) || userId == null) {
            return null;
        }
        String loginUserId = tokenProvider.getUserId(token);
        Map<String, Object> param = new HashMap<>();
        param.put("userId", userId);
        param.put("loginUserId", loginUserId);
        return searchMapper.userSearch(param);
    }

}
