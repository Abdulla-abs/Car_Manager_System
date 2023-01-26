package com.example.spingboot.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author abbas
 * @description: TODO
 * @date 2022/3/9 18:08
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentLog implements Serializable {

        private Integer logId;

        private Date createTime;

        private String commentLog;

        private String accountId;

}
