package com.example.spingboot.common.handler;

import com.example.spingboot.common.enums.VehicleClassEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author abbas
 * @description: TODO
 * @date 2022/3/30 21:06
 */
public class VehicleClassEnumHandler extends BaseTypeHandler<VehicleClassEnum> {
        @Override
        public void setNonNullParameter(PreparedStatement preparedStatement, int i, VehicleClassEnum vehicleClassEnum, JdbcType jdbcType) throws SQLException {

        }

        @Override
        public VehicleClassEnum getNullableResult(ResultSet resultSet, String s) throws SQLException {
                return VehicleClassEnum.getVehicleClassEnum(resultSet.getString(s));
        }

        @Override
        public VehicleClassEnum getNullableResult(ResultSet resultSet, int i) throws SQLException {
                return null;
        }

        @Override
        public VehicleClassEnum getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
                return null;
        }
}
