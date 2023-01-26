package com.example.spingboot.common.handler;

import com.example.spingboot.common.enums.AuditResultEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author abbas
 * @description: TODO
 * @date 2022/3/30 18:31
 */
public class AuditResultEnumHandler extends BaseTypeHandler<AuditResultEnum> {

        @Override
        public void setNonNullParameter(PreparedStatement preparedStatement, int i, AuditResultEnum auditResultEnum, JdbcType jdbcType) throws SQLException {

        }

        @Override
        public AuditResultEnum getNullableResult(ResultSet resultSet, String s) throws SQLException {
                int value = resultSet.getInt(s);
                return AuditResultEnum.getAuditResultEnum(value);
        }

        @Override
        public AuditResultEnum getNullableResult(ResultSet resultSet, int i) throws SQLException {
                return null;
        }

        @Override
        public AuditResultEnum getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
                return null;
        }
}
