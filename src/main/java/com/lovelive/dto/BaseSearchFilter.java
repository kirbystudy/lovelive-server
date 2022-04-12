package com.lovelive.dto;

import lombok.Data;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.validation.constraints.Min;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 小埋
 * @version 1.0
 * @Description TODO
 * @Date 2022/4/11 10:47
 */
@Data
public class BaseSearchFilter {

    /**
     * 页数
     */
    @Min(value = 1, message = "page最小值为1")
    private Integer page = 1;

    /**
     * 每页显示的条数
     */
    @Min(value = 0, message = "page最小值为1")
    private Integer size = 10;

    private String direction = "desc";

    private List<String> sortBy = new ArrayList<>();

    public Pageable toPageable() {
        sortBy.add("createdTime");
        List<Sort.Order> orders = new ArrayList<>();
        for (String sort : sortBy) {
            orders.add(new Sort.Order(Sort.Direction.fromString(direction), sort));
        }
        return PageRequest.of(page - 1, size, Sort.by(orders));
    }
}
