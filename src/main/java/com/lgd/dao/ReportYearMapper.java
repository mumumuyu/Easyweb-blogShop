package com.lgd.dao;

import com.lgd.bean.Boke;
import com.lgd.bean.Count;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ReportYearMapper {
    List<Integer> reportYearBoke(String year);

    List<Count> reportByYears();
}

