package com.api.core.dao;

import com.api.core.dao.model.TestConfiguration;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface TestConfigureMapper {
    @Select({"select id_tag,count from test_configure"})
    @Results({
            @Result(
                    column = "id_tag",
                    property = "idTag"
            ),
            @Result(
                    column = "count",
                    property = "count"
            )
    })
    List<TestConfiguration> getAllTestConfiguration();

    @Update({"UPDATE test_configure SET count = count + 1 WHERE id_tag = #{tag}"})
    void updateTestConfigurationCountByIdTag(@Param("tag") String var1);

    @Update({"UPDATE test_configure SET count = count + #{count} WHERE id_tag = #{idTag}"})
    void updateTestConfigurationCount(@Param("testConfiguration") TestConfiguration testConfiguration);

}
