package com.lovelive.repository.specs;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author 小埋
 * @version 1.0
 * @Description TODO
 * @Date 2022/4/9 18:07
 */
@Data
@AllArgsConstructor
public class SearchCriteria {

    private String key;
    private Object value;
    private SearchOperation operation;
}
