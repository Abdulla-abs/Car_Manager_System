package com.example.spingboot.aop;

import com.example.spingboot.domain.entity.CommentLog;
import com.example.spingboot.service.CommentLogService;
import com.example.spingboot.utils.UserUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author abbas
 * @description: TODO
 * @date 2022/4/8 7:57
 */

@Component
@Aspect
public class CommentLogAop {

        @Autowired
        private CommentLogService commentLogService;

        static Map<String,String> tableNames = new HashMap<>();


        static {
                tableNames.put("Master","mst_master");
                tableNames.put("Vendor","mst_vendor");
                tableNames.put("Dealer","mst_dealer");
                tableNames.put("VehicleStatus","mst_vehicle_status");
                tableNames.put("AuditHeader","trn_audit_header");
                tableNames.put("AuditDetail","trn_audit_detail");
                tableNames.put("AuditResult","trn_audit_result");
                System.out.println("----------------------------static-------------------------");
        }

        @Pointcut("execution(void com.example.spingboot.service.impl.*.*(..))")
        public void doCommentLogPointcut(){}

        @Pointcut("!execution(void com.example.spingboot.service.impl.CommentLog*.*(..))")
        public void notDoCommentPointcut() {}

        @AfterReturning(value = "doCommentLogPointcut() && notDoCommentPointcut()")
        public void doCommentLog(JoinPoint joinPoint) throws Exception{
                System.out.println("----------------------------doComment-------------------------");

                String target = joinPoint.getTarget().getClass().getName();
                String table = getTable(target);

                String method = joinPoint.getSignature().getName();
                String commentLog = getCommentLog(method,table);

                CommentLog entity = new CommentLog();
                entity.setCommentLog(commentLog);
                entity.setAccountId(UserUtil.getUser().getAccountId());
                entity.setCreateTime(new Date());

                commentLogService.save(entity);
        }

        private String getTable(String target){
                for (String s : tableNames.keySet()) {
                        if (target.contains(s)){
                                return tableNames.get(s);
                        }
                }
                return null;
        }

        private String getCommentLog(String method,String table){
                String commentLog = "";
                if (method.contains("save")) {
                        commentLog = "对表："+table+"，进行了增加操作";
                }else if (method.contains("update")){
                        commentLog = "对表："+table+"，进行了更新操作";
                }else if (method.contains("delete")){
                        commentLog = "对表："+table+"，进行了删除操作";
                }
                return commentLog;
        }
}
