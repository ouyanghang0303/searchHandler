package com.tigerobo.searchhandler.mapper;

import com.tigerobo.searchhandler.entity.KeyPersonnel;

public interface KeyPersonnelMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table key_personnel
     *
     * @mbg.generated Tue Dec 11 10:20:06 CST 2018
     */
    int deleteByPrimaryKey(Integer serialno);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table key_personnel
     *
     * @mbg.generated Tue Dec 11 10:20:06 CST 2018
     */
    int insert(KeyPersonnel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table key_personnel
     *
     * @mbg.generated Tue Dec 11 10:20:06 CST 2018
     */
    int insertSelective(KeyPersonnel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table key_personnel
     *
     * @mbg.generated Tue Dec 11 10:20:06 CST 2018
     */
    KeyPersonnel selectByPrimaryKey(Integer serialno);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table key_personnel
     *
     * @mbg.generated Tue Dec 11 10:20:06 CST 2018
     */
    int updateByPrimaryKeySelective(KeyPersonnel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table key_personnel
     *
     * @mbg.generated Tue Dec 11 10:20:06 CST 2018
     */
    int updateByPrimaryKey(KeyPersonnel record);
}