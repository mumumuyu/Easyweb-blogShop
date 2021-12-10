package com.lgd.dao;

import com.lgd.pojo.Count;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ReportYearMapper {
    List<Integer> reportYearBoke(String year);

    List<Count> reportByYears();

    List<Integer> reportYearForOrder(String year);

    List<Count> reportByYearsForOrder();
}

