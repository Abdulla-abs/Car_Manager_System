package com.example.spingboot.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author abbas
 * @description: TODO
 * @date 2022/3/15 8:34
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentLogVo extends PageVo implements Serializable {

        private Date createTimeFrom;

        private Date createTimeTo;
}
