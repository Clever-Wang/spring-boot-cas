package org.apereo.cas.audit.spi.config;

import org.apereo.inspektr.audit.spi.AuditResourceResolver;
import org.aspectj.lang.JoinPoint;

/**
 * @author: wangsaichao
 * @date: 2018/8/10
 * @description:
 */
public class DeleteServiceResourceResolver implements AuditResourceResolver {
    @Override
    public String[] resolveFrom(JoinPoint target, Object returnValue) {
        return new String[0];
    }

    @Override
    public String[] resolveFrom(JoinPoint target, Exception exception) {
        return new String[0];
    }
}
