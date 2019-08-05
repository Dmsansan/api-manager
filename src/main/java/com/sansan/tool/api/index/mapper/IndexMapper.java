package com.sansan.tool.api.index.mapper;

import com.sansan.tool.api.entity.index.ApiUserActivies;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface IndexMapper {
    List<ApiUserActivies> queryUserActivies(Map<String, Object> params);
}
