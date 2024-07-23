package com.example.demo;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface UserMapper {
    @Select("SELECT * FROM schema_1.user WHERE id=#{id}")
    User getCaseById(Long id);

    @Insert("INSERT INTO schema_1.uer(id, name) values(#{id},#{name})")
    void insertUser(User caseT);

    @Insert("INSERT INTO #{schema_1}.user(id, name) values(#{id},#{name})")
    void insertUserIntoSchema(User userT, String schema_1);


    @Select("""
            <script>
                <foreach item="schemas" index="index" collection="schemas">
                    SELECT * FROM ${schema}.user
                    <if test="index+1 &lt; schemas.size">
                        UNION ALL
                    </if>
                </foreach>
            </script>
            """)
    List<User> selectAllCases(@Param("schemas") List<String> schemas);

    @Select("""
            <script>
                <foreach item="schema" index="index" collection="schemas">
                    SELECT count(*), '${schema}' as schema FROM ${schema}.case
                    <if test="index+1 &lt; schemas.size">
                        UNION ALL
                    </if>
                </foreach>
            </script>
            """)
    List<CountOfSchemas> selectAllCasesCount(@Param("schemas") List<String> schemas);


}
