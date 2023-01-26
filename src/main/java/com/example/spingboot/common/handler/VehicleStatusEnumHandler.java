package com.example.spingboot.common.handler;

import com.example.spingboot.common.enums.VehicleStatusEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author abbas
 * @description: TODO
 * @date 2022/3/30 21:09
 */
public class VehicleStatusEnumHandler extends BaseTypeHandler<VehicleStatusEnum> {
        @Override
        public void setNonNullParameter(PreparedStatement preparedStatement, int i, VehicleStatusEnum vehicleStatusEnum, JdbcType jdbcType) throws SQLException {

        }

        @Override
        public VehicleStatusEnum getNullableResult(ResultSet resultSet, String s) throws SQLException {
                return VehicleStatusEnum.getVehicleStatusEnum(resultSet.getString(s));
        }

        @Override
        public VehicleStatusEnum getNullableResult(ResultSet resultSet, int i) throws SQLException {
                return null;
        }

        @Override
        public VehicleStatusEnum getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
                return null;
        }
}
