package com.study.figure.mybatis;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SearchMapper {

    public Map<String, Object> integratedSearch(Map<String, Object> param);
    public Map<String, Object> userSearch(Map<String, Object> param);
}
