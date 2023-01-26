package com.example.spingboot.dao;

import com.example.spingboot.domain.vo.PageVo;

import java.util.List;

/**
 * @author abbas
 * @description: TODO
 * @date 2022/3/15 9:01
 * @param <E> entity 实体类
 * @param <V> vo 类
 * @param <D> dto 类
 */
public interface BaseDao<E,V,D> {

        void insert(E entity) throws Exception;

        void insertSelective(E entity) throws Exception;

        void insertBatch(List<E> list) throws Exception;

        void deleteByPrimaryKey(Integer primaryKey) throws Exception;

        void deleteByPrimaryKey(String primaryKey) throws Exception;

        void deleteSelective(V query) throws Exception;

        void deleteBatch(Integer[] array) throws Exception;

        void updateByPrimaryKey(E entity) throws Exception;

        void updateByPrimaryKeySelective(E entity) throws Exception;

        void updateBatch(List<E> list) throws Exception;

        D selectByPrimaryKey(Integer key) throws Exception;

        D selectByPrimaryKey(String key) throws Exception;

        List<D> selectListBySelective(V query) throws Exception;

        List<E> selectListAll(PageVo query) throws Exception;

        int selectCountAll() throws Exception;

        int selectCountBySelective(V query) throws Exception;

}
